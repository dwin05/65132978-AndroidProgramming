package com.quynh.vieccanlam;

import android.content.Intent; // Thiếu cái này sẽ không chuyển màn hình được
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTasks;
    private TaskAdapter adapter;
    private List<TASK> taskList;
    private DatabaseReference databaseReference;
    private FloatingActionButton btnOpenAdd; // Nút để mở màn hình thêm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ các View
        rvTasks = findViewById(R.id.rvTasks);
        btnOpenAdd = findViewById(R.id.floatingActionButton); // ID nút thêm ở màn hình chính

        // 2. Thiết lập RecyclerView
        taskList = new ArrayList<>();
        adapter = new TaskAdapter(taskList);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(adapter);

        // 3. Sự kiện Click để chuyển sang màn hình ThêmTaskActivity
        btnOpenAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemTaskActivity.class);
                startActivity(intent);
            }
        });

        // 4. Lấy dữ liệu từ Firebase về hiển thị
        databaseReference = FirebaseDatabase.getInstance().getReference("TASK");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                taskList.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    TASK task = data.getValue(TASK.class);
                    if (task != null) {
                        taskList.add(task);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi nếu cần thiết
                Toast.makeText(MainActivity.this, "Lỗi tải dữ liệu: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}