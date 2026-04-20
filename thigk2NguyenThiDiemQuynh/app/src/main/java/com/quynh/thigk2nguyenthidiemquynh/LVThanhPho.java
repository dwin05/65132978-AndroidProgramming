package com.quynh.thigk2nguyenthidiemquynh;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LVThanhPho extends AppCompatActivity {

    private ListView lvMenu;
    private ArrayList<String> dsTinhThanh;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Lưu ý: Thay "activity_lvmon_an" bằng đúng tên file XML layout của bạn
        setContentView(R.layout.activity_lvthanh_pho);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Ánh xạ ListView từ XML
        lvMenu = findViewById(R.id.lvMenu);

        // 2. Tạo nguồn dữ liệu (Danh sách 10 tỉnh/thành phố)
        dsTinhThanh = new ArrayList<>();
        dsTinhThanh.add("Hà Nội");
        dsTinhThanh.add("Hải Phòng");
        dsTinhThanh.add("Huế");
        dsTinhThanh.add("Đà Nẵng");
        dsTinhThanh.add("Nha Trang");
        dsTinhThanh.add("Đà Lạt");
        dsTinhThanh.add("TP. Hồ Chí Minh");
        dsTinhThanh.add("Vũng Tàu");
        dsTinhThanh.add("Cần Thơ");
        dsTinhThanh.add("Nguyễn Thị Diễm Quỳnh");

        // 3. Khởi tạo Adapter
        // Sử dụng android.R.layout.simple_list_item_1 là một layout có sẵn của Android
        // cung cấp một TextView đơn giản cho mỗi dòng của ListView
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dsTinhThanh
        );

        // 4. Gắn Adapter vào ListView để hiển thị dữ liệu
        lvMenu.setAdapter(adapter);

        // 5. Bắt sự kiện khi click vào một mục trong ListView (Tùy chọn thêm để app tương tác tốt hơn)
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy tên tỉnh thành tại vị trí được click
                String tenTinhThanh = dsTinhThanh.get(position);
                // Hiển thị thông báo (Toast)
                Toast.makeText(LVThanhPho.this, "Bạn đã chọn: " + tenTinhThanh, Toast.LENGTH_SHORT).show();
            }
        });
    }
}