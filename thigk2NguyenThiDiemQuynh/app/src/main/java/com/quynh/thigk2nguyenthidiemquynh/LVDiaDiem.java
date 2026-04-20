package com.quynh.thigk2nguyenthidiemquynh;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LVDiaDiem extends AppCompatActivity {

    private ListView lvMenu;
    private ArrayList<DiaDiem> danhSachDiaDiem;
    private DiaDiemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Cập nhật lại đúng tên file layout XML của màn hình ListView này nhé (ví dụ: activity_lvdia_diem)
        setContentView(R.layout.activity_dia_diem);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvMenu = findViewById(R.id.lvMenu);

        // Tạo danh sách dữ liệu địa điểm
        danhSachDiaDiem = new ArrayList<>();
        // R.mipmap.ic_launcher là ảnh mặc định, bạn có thể thay bằng R.drawable.ten_anh_cua_ban
        danhSachDiaDiem.add(new DiaDiem("Hồ Hoàn Kiếm", "Địa chỉ: Quận Hoàn Kiếm, Hà Nội", R.mipmap.logar_valley));
        danhSachDiaDiem.add(new DiaDiem("Bà Nà Hills", "Địa chỉ: Hòa Vang, Đà Nẵng", R.mipmap.national_park));
        danhSachDiaDiem.add(new DiaDiem("Dinh Độc Lập", "Địa chỉ: Quận 1, TP. Hồ Chí Minh", R.mipmap.nt_beach));
        danhSachDiaDiem.add(new DiaDiem("Vinpearl Land", "Địa chỉ: Đảo Hòn Tre, Nha Trang", R.mipmap.sunset));
        danhSachDiaDiem.add(new DiaDiem("Thung Lũng Tình Yêu", "Địa chỉ: Phường 8, Đà Lạt", R.mipmap.logar_valley));

        // Khởi tạo Adapter
        // Nhớ đổi R.layout.item_diadiem thành tên file XML chứa CardView của bạn
        adapter = new DiaDiemAdapter(this, R.layout.item_land, danhSachDiaDiem);

        // Gắn Adapter vào ListView
        lvMenu.setAdapter(adapter);
    }
}