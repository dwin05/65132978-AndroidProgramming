package com.quynh.optap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI, btnMonAn, btnBaiThuoc, btnIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBMI = findViewById(R.id.btnBMI);
        btnMonAn = findViewById(R.id.btnMonAn);
        btnBaiThuoc = findViewById(R.id.btnBaiThuoc);


        btnBMI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, mhBMI.class);
            startActivity(intent);
        });

        btnMonAn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LVMonAn.class);
            startActivity(intent);
        });

        btnBaiThuoc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DanhSachBaiThuoc.class);
            startActivity(intent);
        });

        Button btnIntro = findViewById(R.id.btnIntro);
        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Intro.class);
                startActivity(intent);
            }
        });
    }
}