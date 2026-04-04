package com.quynh.appnghenhac;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MHDangNhap extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);
    }
    public void QuayVe(View v){
        Intent iMHChinh = new Intent(MHDangNhap.this, MainActivity.class);
        startActivity(iMHChinh);
    }
}
