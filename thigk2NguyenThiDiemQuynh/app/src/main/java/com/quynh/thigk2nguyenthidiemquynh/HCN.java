package com.quynh.thigk2nguyenthidiemquynh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HCN extends AppCompatActivity {
    private EditText edtH, edtW, edtCV, edtDT;
    private Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hcn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtH = findViewById(R.id.edtH);
        edtW = findViewById(R.id.edtW);
        edtCV = findViewById(R.id.edtCV);
        edtDT = findViewById(R.id.edtDT);
        btnTinh = findViewById(R.id.btnTinh);

        // Khóa ô hiển thị kết quả để người dùng không chỉnh sửa được phần này
        edtCV.setFocusable(false);
        edtDT.setFocusable(false);

        // Cài đặt sự kiện click cho nút Tính
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhChuViDienTich();
            }
        });
    } // <-- ĐÃ SỬA: Đóng ngoặc hàm onCreate() tại đây

    // HÀM MỚI ĐƯỢC ĐẶT Ở NGOÀI onCreate()
    private void tinhChuViDienTich() {
        // Lấy chuỗi dữ liệu người dùng nhập vào
        String strH = edtH.getText().toString().trim();
        String strW = edtW.getText().toString().trim();

        // Kiểm tra xem người dùng có để trống không
        if (strH.isEmpty() || strW.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ H (Chiều dài) và W (Chiều rộng)!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Ép kiểu chuỗi sang số thập phân (double)
            double h = Double.parseDouble(strH);
            double w = Double.parseDouble(strW);

            // Công thức tính
            double chuVi = (h + w) * 2;
            double dienTich = h * w;

            // Ép kiểu kết quả ngược lại thành chuỗi và gán vào 2 ô EditText kết quả
            edtCV.setText(String.format("%.2f", chuVi));
            edtDT.setText(String.format("%.2f", dienTich));

        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ nếu người dùng nhập ký tự không phải là số hợp lệ
            Toast.makeText(this, "Dữ liệu nhập vào phải là số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}