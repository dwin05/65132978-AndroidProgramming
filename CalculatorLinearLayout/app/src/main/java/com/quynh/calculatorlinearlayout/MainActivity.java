package com.quynh.calculatorlinearlayout;

import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2, edtKQ;
    Button btnCong, btnTru, btnNhan, btnChia;
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
        timDieuKhien();
    }
    void timDieuKhien(){
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edtKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }

    public void Cong(View v){
        //lay dw lieu tu 2 dkhien
        String so1 = edt1.getText().toString();
        String so2 = edt2.getText().toString();
        // chuyen dl tu chuoi sang so
        float soThu1 = Float.parseFloat(so1);
        float soThu2 = Float.parseFloat(so2);

        float Tong = soThu1 + soThu2;

        String KQ = String.valueOf(Tong);
        edtKQ.setText(KQ);
    }
    public void Tru(View v){
        //lay dw lieu tu 2 dkhien
        String so1 = edt1.getText().toString();
        String so2 = edt2.getText().toString();
        // chuyen dl tu chuoi sang so
        float soThu1 = Float.parseFloat(so1);
        float soThu2 = Float.parseFloat(so2);

        float Tong = soThu1 - soThu2;

        String KQ = String.valueOf(Tong);
        edtKQ.setText(KQ);
    }
    public void Nhan(View v){
        //lay dw lieu tu 2 dkhien
        String so1 = edt1.getText().toString();
        String so2 = edt2.getText().toString();
        // chuyen dl tu chuoi sang so
        float soThu1 = Float.parseFloat(so1);
        float soThu2 = Float.parseFloat(so2);

        float Tong = soThu1 * soThu2;

        String KQ = String.valueOf(Tong);
        edtKQ.setText(KQ);
    }
    public void Chia(View v){
        //lay dw lieu tu 2 dkhien
        String so1 = edt1.getText().toString();
        String so2 = edt2.getText().toString();
        // chuyen dl tu chuoi sang so
        float soThu1 = Float.parseFloat(so1);
        float soThu2 = Float.parseFloat(so2);

        if(soThu2 != 0){
            float Tong = soThu1 / soThu2;
            String KQ = String.valueOf(Tong);
            edtKQ.setText(KQ);
        }
        else edtKQ.setText("So thu 2 phai khac 0!");
    }
}