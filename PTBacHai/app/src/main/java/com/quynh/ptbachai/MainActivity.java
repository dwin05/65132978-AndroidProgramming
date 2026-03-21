package com.quynh.ptbachai;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtC, edtKQ;
    Button btnTinh;
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
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        edtKQ = findViewById(R.id.edtKQ);
        btnTinh  = findViewById(R.id.btnTinh);

        btnTinh.setOnClickListener(v -> {

            try {
                double a = Double.parseDouble(edtA.getText().toString().trim());
                double b = Double.parseDouble(edtB.getText().toString().trim());
                double c = Double.parseDouble(edtC.getText().toString().trim());
                if (a == 0) {
                    if (b == 0) {
                        edtKQ.setText("Phương trình vô nghiệm");
                    } else {
                        double x = -c / b;
                        edtKQ.setText("x = " + x);
                    }
                    return;
                }
                double delta = b*b - 4*a*c;
                if (delta < 0) {
                    edtKQ.setText("Phương trình vô nghiệm");
                }
                else if (delta == 0) {
                    double x = -b / (2*a);
                    edtKQ.setText("Nghiệm kép x = " + x);
                }
                else {
                    double x1 = (-b + Math.sqrt(delta)) / (2*a);
                    double x2 = (-b - Math.sqrt(delta)) / (2*a);
                    edtKQ.setText("x1 = " + x1 + "\nx2 = " + x2);
                }
            } catch (Exception e) {
                edtKQ.setText("Vui lòng nhập đầy đủ số hợp lệ");
            }
        });
    }
}