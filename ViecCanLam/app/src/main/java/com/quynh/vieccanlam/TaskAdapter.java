package com.quynh.vieccanlam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<TASK> mListTasks;

    // Constructor để nhận danh sách dữ liệu
    public TaskAdapter(List<TASK> mListTasks) {
        this.mListTasks = mListTasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout item_task (bạn cần tạo file xml này như hướng dẫn bên dưới)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TASK task = mListTasks.get(position);
        if (task == null) {
            return;
        }

        // Đổ dữ liệu từ object TASK vào TextView
        holder.tvName.setText(task.getName());
        holder.tvDate.setText("Ngày: " + task.getDate());
    }

    @Override
    public int getItemCount() {
        if (mListTasks != null) {
            return mListTasks.size();
        }
        return 0;
    }

    // ViewHolder để ánh xạ các view trong dòng item
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDate;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView2);
            tvDate = itemView.findViewById(R.id.textView4);
        }
    }
}