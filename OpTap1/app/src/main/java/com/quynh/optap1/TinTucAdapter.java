package com.quynh.optap1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ViewHolder> {

    private ArrayList<TinTuc> dsTinTuc;
    private Context context;

    public TinTucAdapter(ArrayList<TinTuc> dsTinTuc, Context context) {
        this.dsTinTuc = dsTinTuc;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tin_tuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TinTuc tin = dsTinTuc.get(position);
        holder.tvTieuDe.setText(tin.getTieuDe());
        holder.tvNgayDang.setText(tin.getNgayDang());

        // Mở link bài báo bằng trình duyệt khi click
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tin.getLink()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dsTinTuc.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTieuDe, tvNgayDang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.tvTieuDeRSS);
            tvNgayDang = itemView.findViewById(R.id.tvNgayDangRSS);
        }
    }
}