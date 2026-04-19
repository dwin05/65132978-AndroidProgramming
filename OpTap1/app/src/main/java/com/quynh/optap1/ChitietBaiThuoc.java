package com.quynh.optap1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChitietBaiThuoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chitiet_bai_thuoc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvTen = findViewById(R.id.tvChiTietTen);
        TextView tvThoiGian = findViewById(R.id.tvChiTietThoiGian);
        TextView tvMoTa = findViewById(R.id.tvChiTietMoTa);
        ImageView imgHinh = findViewById(R.id.imgChiTietHinh);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String ten = intent.getStringExtra("TEN_BAI");
        String thoiGian = intent.getStringExtra("THOI_GIAN");
        String moTa = intent.getStringExtra("MO_TA");
        int hinh = intent.getIntExtra("HINH", 0);

        // Hiển thị lên giao diện
        if (ten != null) { // Tránh lỗi Null Pointer
            tvTen.setText(ten);
            tvThoiGian.setText("Thời gian điều trị: " + thoiGian);
            tvMoTa.setText(moTa);
            imgHinh.setImageResource(hinh);
        }
    }
}