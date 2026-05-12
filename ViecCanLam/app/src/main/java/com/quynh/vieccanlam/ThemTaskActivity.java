package com.quynh.vieccanlam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ThemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtName = findViewById(R.id.edtName);
                EditText edtMess = findViewById(R.id.edtMess);
                EditText edtDate = findViewById(R.id.edtDate);
                EditText edtPriority = findViewById(R.id.edtPriority);
                // 1. Lấy dữ liệu
                String tenCV = edtName.getText().toString().trim();
                String mess = edtMess.getText().toString().trim();
                String date = edtDate.getText().toString().trim();
                String priority = edtPriority.getText().toString().trim();

                // 2. Kiểm tra dữ liệu (Rất quan trọng, nếu rỗng Firebase có thể từ chối)
                if (tenCV.isEmpty()) {
                    edtName.setError("Vui lòng nhập tên!");
                    return;
                }

                // 3. Tạo đối tượng
                TASK task = new TASK(tenCV, date, mess, priority);

                // 4. Kết nối và Lưu
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("TASK");

                // Tạo một ID duy nhất cho mỗi công việc (Công việc 1, Công việc 2...)
                String key = databaseReference.push().getKey();

                if (key != null) {
                    databaseReference.child(key).setValue(task)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(ThemTaskActivity.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Dòng này sẽ cho bạn biết tại sao không lưu được (ví dụ: Permission Denied)
                                    Toast.makeText(ThemTaskActivity.this, "Lỗi Firebase: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    android.util.Log.e("FIREBASE_ERROR", e.getMessage());
                                }
                            });
                }
            }
        });
    }
}