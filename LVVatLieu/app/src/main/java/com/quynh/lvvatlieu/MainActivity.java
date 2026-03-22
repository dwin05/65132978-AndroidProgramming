package com.quynh.lvvatlieu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        ArrayList<String> dsVatLieu = new ArrayList<String>();
        dsVatLieu.add("Xi mang");
        dsVatLieu.add("Gach");
        dsVatLieu.add("Cat san");
        dsVatLieu.add("Son chong tham");
        dsVatLieu.add("Gach men");
        dsVatLieu.add("Xi mang");
        dsVatLieu.add("Gach");
        dsVatLieu.add("Cat san");
        dsVatLieu.add("Son chong tham");
        dsVatLieu.add("Gach men");
        dsVatLieu.add("Xi mang");
        dsVatLieu.add("Gach");
        dsVatLieu.add("Cat san");
        dsVatLieu.add("Son chong tham");
        dsVatLieu.add("Gach men");

        ArrayAdapter<String> adapterVatLieu = new ArrayAdapter<String>(this,
                R.layout.lv,
                dsVatLieu);
        ListView lvVatLieu = findViewById(R.id.lvVatLieu);
        lvVatLieu.setAdapter(adapterVatLieu);
    }
}