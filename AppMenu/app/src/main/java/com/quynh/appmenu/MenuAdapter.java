package com.quynh.appmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    private ArrayList<Menu> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MenuAdapter(ArrayList<Menu> dsMonAn, Context _context) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int position) {
        return dsMonAn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // view item hien tai
        View viewHienHanh = convertView;
        //kt
        if(viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.item_menu, null);
        Menu monAnHienTai = dsMonAn.get(position);

        TextView tv_Ten = viewHienHanh.findViewById(R.id.tvTen);
        TextView tv_Gia = viewHienHanh.findViewById(R.id.tvGia);
        TextView tv_MoTa = viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView img_MonAn = viewHienHanh.findViewById(R.id.imgMonAn);
        //set
        tv_Ten.setText(monAnHienTai.getTen());
        tv_Gia.setText(String.valueOf(monAnHienTai.getGia()));
        tv_MoTa.setText(monAnHienTai.getMoTa());
        img_MonAn.setImageResource(monAnHienTai.getIdAnh());
        return viewHienHanh;
    }
}
