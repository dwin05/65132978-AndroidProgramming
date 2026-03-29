package com.quynh.recyclerview_landscape;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder>{
    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context contect, ArrayList<LandScape> listData) {
        this.context = contect;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //lay doi tuong hien thi
        LandScape landScapeHienThi = listData.get(position);
        // trich thong tin
        String caption = landScapeHienThi.getFileImage();
        // dat anh vao holder
        holder.tvCaption.setText(landScapeHienThi.cantion);
        //dat anh
            String packageName = holder.itemView.getContext().getPackageName();
            int imgID = holder.itemView.getResources().getIdentifier(caption, "mipmap", packageName);
        holder.imgLandScape.setImageResource(imgID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView imgLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textView);
            imgLandScape = itemView.findViewById(R.id.imgLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriClick = getAbsoluteAdapterPosition();
            LandScape phtuClick = listData.get(viTriClick);
            String ten = phtuClick.cantion;
            String tenFile = phtuClick.fileImage;
            String chuoiTB = "Ban vua click vao: "+ ten;
            Toast.makeText(v.getContext(), chuoiTB, Toast.LENGTH_LONG).show();
        }
    }
}
