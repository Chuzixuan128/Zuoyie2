package com.example.demo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LvMy extends RecyclerView.Adapter<LvMy.ViewHolder> {

    Context context;
    ArrayList<Bean.ResultsBean> list;

    public LvMy(Context context, ArrayList<Bean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<Bean.ResultsBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LvMy.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
        }

    @Override
    public void onBindViewHolder(@NonNull LvMy.ViewHolder viewHolder, int i) {
        Bean.ResultsBean bean = list.get(i);
        Glide.with(context).load(bean.getUrl()).into(viewHolder.img);
        viewHolder.tv.setText(bean.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
