package com.quynh.optap1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mhBMI extends AppCompatActivity {
    EditText edtH, edtW, edtKQ;
    Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mh_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtH = findViewById(R.id.edtH);
        edtW = findViewById(R.id.edtW);
        edtKQ = findViewById(R.id.edtKQ);
        btnTinh = findViewById(R.id.btnTinh);

        btnTinh.setOnClickListener(v -> {
            String hStr = edtH.getText().toString().trim();
            String wStr = edtW.getText().toString().trim();

            if (hStr.isEmpty() || wStr.isEmpty()) {
                edtKQ.setText("Nhập thiếu dữ liệu");
                return;
            }
            hStr = hStr.replace(",", ".");
            wStr = wStr.replace(",", ".");
            try {

                double h = Double.parseDouble(hStr);
                double w = Double.parseDouble(wStr);

                if (h <= 0 || w <= 0) {
                    edtKQ.setText("Dữ liệu phải > 0");
                    return;
                }

                double bmi = w / (h * h);

                String danhGia;

                if (bmi < 18.5) {
                    danhGia = "Gầy";
                } else if (bmi < 25) {
                    danhGia = "Bình thường";
                } else if (bmi < 30) {
                    danhGia = "Thừa cân";
                } else {
                    danhGia = "Béo phì";
                }
                edtKQ.setText(String.format("BMI: %.2f (%s)", bmi, danhGia));

            } catch (NumberFormatException e) {
                edtKQ.setText("Vui lòng nhập số hợp lệ");
            }
        });
    }
}