package com.quynh.thigk2nguyenthidiemquynh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThanhPhoAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ThanhPho> dsThanhPho;

    public ThanhPhoAdapter(Context context, int layout, ArrayList<ThanhPho> dsThanhPho) {
        this.context = context;
        this.layout = layout;
        this.dsThanhPho = dsThanhPho;
    }

    @Override
    public int getCount() {
        return dsThanhPho.size(); // Trả về số lượng item
    }

    @Override
    public Object getItem(int position) {
        return dsThanhPho.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Lớp ViewHolder giúp ứng dụng chạy mượt mà hơn, không bị giật lag khi cuộn danh sách
    private class ViewHolder {
        ImageView imgLand;
        TextView txtTen, txtDiaChi;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            // Ánh xạ các thành phần trong file item_thanhpho.xml
            holder.imgLand = convertView.findViewById(R.id.imgLand);
            holder.txtTen = convertView.findViewById(R.id.textView);
            holder.txtDiaChi = convertView.findViewById(R.id.tvDiaChi);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Gán dữ liệu vào View
        ThanhPho thanhPho = dsThanhPho.get(position);
        holder.txtTen.setText(thanhPho.getTen());
        holder.txtDiaChi.setText(thanhPho.getDiaChi());
        holder.imgLand.setImageResource(thanhPho.getHinhAnh());

        return convertView;
    }
}