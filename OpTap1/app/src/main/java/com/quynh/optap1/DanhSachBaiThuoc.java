package com.quynh.optap1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DanhSachBaiThuoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_bai_thuoc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView rvBaiThuoc = findViewById(R.id.rvBaiThuoc);

        // Khởi tạo dữ liệu mẫu
        ArrayList<BaiThuoc> dsBaiThuoc = new ArrayList<>();
        dsBaiThuoc.add(new BaiThuoc(R.drawable.cavien, "Trị cảm cúm", "3 ngày", "Uống nhiều nước ấm, nghỉ ngơi."));
        dsBaiThuoc.add(new BaiThuoc(R.drawable.tt, "Trị ho khan", "5 ngày", "Ngậm chanh đào mật ong."));
        // Thêm các bài thuốc khác...

        // Cài đặt Adapter và LayoutManager
        BaiThuocAdapter adapter = new BaiThuocAdapter(dsBaiThuoc, this);
        rvBaiThuoc.setLayoutManager(new LinearLayoutManager(this));
        rvBaiThuoc.setAdapter(adapter);
    }
}