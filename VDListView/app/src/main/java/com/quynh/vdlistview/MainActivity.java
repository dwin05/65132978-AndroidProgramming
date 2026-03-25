package com.quynh.vdlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        //1. tao list
        ArrayList<String> dsTinh = new ArrayList<String>();
        dsTinh.add("Khanh Hoa");
        dsTinh.add("Thanh Hoa");
        dsTinh.add("Phu Yen");
        dsTinh.add("Kien Giang");
        dsTinh.add("Ho Chi Minh");
        dsTinh.add("Khanh Hoa");
        dsTinh.add("Thanh Hoa");
        dsTinh.add("Phu Yen");
        dsTinh.add("Kien Giang");
        dsTinh.add("Ho Chi Minh");
        dsTinh.add("Khanh Hoa");
        dsTinh.add("Thanh Hoa");
        dsTinh.add("Phu Yen");
        dsTinh.add("Kien Giang");
        dsTinh.add("Ho Chi Minh");
        //2. adapter
        ArrayAdapter<String> adapterTinh = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                dsTinh);
        // 3. connect  dieu khien va listview
        ListView lvTinh = findViewById(R.id.lvTinh);
        lvTinh.setAdapter(adapterTinh);

        AdapterView.OnItemClickListener BoLangNghe = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String choose = dsTinh.get(position);
                Toast.makeText(MainActivity.this,"Ban vua chon: "+ choose, Toast.LENGTH_LONG).show();
            }
        };
        lvTinh.setOnItemClickListener(BoLangNghe);
    }
}