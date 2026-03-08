package com.quynh.giaiptbac1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
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

        EditText edtA, edtB, edtKQ;

        ImageButton btnTinh;

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTinh = findViewById(R.id.btnTinh);

        btnTinh.setOnClickListener(v -> {
            if(edtA.getText().toString().isEmpty() || edtB.getText().toString().isEmpty()){
                edtKQ.setText("Vui long nhap A va B");
                return;
            }
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());

            if(a == 0 && b == 0){
                edtKQ.setText("Vo so nghiem!");
            } else if (a == 0) {
                edtKQ.setText(" VO nghiem!");
            }
            else edtKQ.setText(" " + (double)(-b)/a);
        });
    }
}