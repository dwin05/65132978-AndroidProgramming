package com.quynh.optap1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LVMonAn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lvmon_an);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView lvMenu = findViewById(R.id.lvMenu);
        ArrayList<Menu> dsMonAn = new ArrayList<Menu>();
        dsMonAn.add(new Menu("Ca vien chien mam toi", 50_000, "mo ta ve mon an mo to", R.drawable.cavien));
        dsMonAn.add(new Menu("Tra ta thanh nhiet", 10_000, "mo ta ve mon an mo to", R.drawable.tt));
        dsMonAn.add(new Menu("Bap xao bo", 20_000, "mo ta ve mon an mo to", R.drawable.bap));
        dsMonAn.add(new Menu("Banh trang nuong", 15_000, "mo ta ve mon an mo to", R.drawable.banhtrang));
        dsMonAn.add(new Menu("Tra sua tran chau", 15_000, "mo ta ve mon an mo to", R.drawable.ts));
        dsMonAn.add(new Menu("Nem nuong NT", 15_000, "mo ta ve mon an mo to", R.drawable.nem));
        dsMonAn.add(new Menu("Ca vien chien mam toi", 50_000, "mo ta ve mon an mo to", R.drawable.cavien));
        dsMonAn.add(new Menu("Tra ta thanh nhiet", 10_000, "mo ta ve mon an mo to", R.drawable.tt));
        dsMonAn.add(new Menu("Bap xao bo", 20_000, "mo ta ve mon an mo to", R.drawable.bap));
        dsMonAn.add(new Menu("Banh trang nuong", 15_000, "mo ta ve mon an mo to", R.drawable.banhtrang));
        dsMonAn.add(new Menu("Tra sua tran chau", 15_000, "mo ta ve mon an mo to", R.drawable.ts));
        dsMonAn.add(new Menu("Nem nuong NT", 15_000, "mo ta ve mon an mo to", R.drawable.nem));

        MenuAdapter adapter = new MenuAdapter(dsMonAn,this);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu choose = dsMonAn.get(position);
                Toast.makeText(LVMonAn.this, choose.getTen(), Toast.LENGTH_LONG).show();
            }
        });
    }
}