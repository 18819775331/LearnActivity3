package com.example.learnactivity3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<City> fruitList;

    public MyAdapter(List<City> fruitList){
        this.fruitList=fruitList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView grid_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grid_txt = itemView.findViewById(R.id.tv_city);
        }
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_city_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        //设置显示的文字
        holder.grid_txt.setText(fruitList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        //设置显示的item数量为fruitList列表的元素的数量
        return fruitList.size();
    }
}
