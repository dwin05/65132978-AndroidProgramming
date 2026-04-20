package com.quynh.thigk2nguyenthidiemquynh;

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
    Button btnHCN, btnTP, btnDiaDiem, btnIntro;
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
        btnHCN = findViewById(R.id.btnHCN);
        btnTP = findViewById(R.id.btnTP);
        btnDiaDiem = findViewById(R.id.btnDiaDiem);
        btnIntro = findViewById(R.id.btnIntro);
        btnHCN.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HCN.class));
        });

        btnTP.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LVThanhPho.class));
        });


        btnIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Intro.class);
                startActivity(intent);
            }
        });
    }
}