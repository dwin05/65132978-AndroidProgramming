package com.quynh.optap1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BaiThuocAdapter extends RecyclerView.Adapter<BaiThuocAdapter.ViewHolder> {

    private ArrayList<BaiThuoc> dsBaiThuoc;
    private Context context;

    public BaiThuocAdapter(ArrayList<BaiThuoc> dsBaiThuoc, Context context) {
        this.dsBaiThuoc = dsBaiThuoc;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai_thuoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiThuoc baiThuoc = dsBaiThuoc.get(position);

        holder.imgBaiThuoc.setImageResource(baiThuoc.getHinhAnh());
        holder.tvTenBaiThuoc.setText(baiThuoc.getTenBaiThuoc());
        holder.tvThoiGian.setText(baiThuoc.getThoiGian());

        // BẮT SỰ KIỆN CLICK ĐỂ LẤY 0.5 ĐIỂM
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChitietBaiThuoc.class);
            // Truyền dữ liệu sang màn hình chi tiết
            intent.putExtra("TEN_BAI", baiThuoc.getTenBaiThuoc());
            intent.putExtra("THOI_GIAN", baiThuoc.getThoiGian());
            intent.putExtra("MO_TA", baiThuoc.getMoTa());
            intent.putExtra("HINH", baiThuoc.getHinhAnh());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dsBaiThuoc.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBaiThuoc;
        TextView tvTenBaiThuoc, tvThoiGian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBaiThuoc = itemView.findViewById(R.id.imgBaiThuoc);
            tvTenBaiThuoc = itemView.findViewById(R.id.tvTenBaiThuoc);
            tvThoiGian = itemView.findViewById(R.id.tvThoiGian);
        }
    }
}