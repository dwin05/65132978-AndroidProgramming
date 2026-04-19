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

public class ChiTietMonAN extends AppCompatActivity {
    TextView tvTen, tvGia, tvMoTa;
    ImageView imgMon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_mon_an);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvTen = findViewById(R.id.tvTen);
        tvGia = findViewById(R.id.tvGia);
        tvMoTa = findViewById(R.id.tvMoTa);
        imgMon = findViewById(R.id.imgMonAn);

        // Nhận dữ liệu từ Intent
        String ten = getIntent().getStringExtra("ten");
        int gia = getIntent().getIntExtra("gia", 0);
        String mota = getIntent().getStringExtra("mota");
        int hinh = getIntent().getIntExtra("hinh", 0);

        // Set dữ liệu lên UI
        tvTen.setText(ten);
        tvGia.setText(String.valueOf(gia )+ " VND");
        tvMoTa.setText(mota);
        imgMon.setImageResource(hinh);
    }
}