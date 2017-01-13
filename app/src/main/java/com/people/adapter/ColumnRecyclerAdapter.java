package com.people.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.people.R;
import com.people.bean.ColumnBean;

import java.util.List;

public class ColumnRecyclerAdapter extends RecyclerView.Adapter<ColumnRecyclerAdapter.MyViewHolder> {

    private OnItemClickListener mOnItemClickListener;
    Context context;
    List<ColumnBean.DataBean> columndata;

    public ColumnRecyclerAdapter(Context context, List<ColumnBean.DataBean> columndata) {
        this.context = context;
        this.columndata = columndata;
    }

    //点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.columnrecycler_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.columnRecycler_text.setText(columndata.get(position).getName());
        holder.columnRecycler_texttop.setText(columndata.get(position).getDescription());
        Glide.with(context)
                .load(columndata.get(position).getThumbnail())//图片的url
                .diskCacheStrategy(DiskCacheStrategy.ALL) //缓冲全尺寸
                .centerCrop() //设置居中
                .placeholder(R.mipmap.ani_popover_loading_yz_11)//加载中图片
                .into((holder).columnRecycler_img);//显示图片的控件

        //判断是否设置了监听器
        //单击判断
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return columndata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView columnRecycler_texttop;
        TextView columnRecycler_text;
        ImageView columnRecycler_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            columnRecycler_texttop = (TextView) itemView.findViewById(R.id.columnrecycler_texttop);
            columnRecycler_text = (TextView) itemView.findViewById(R.id.columnRecycler_text);
            columnRecycler_img = (ImageView) itemView.findViewById(R.id.columnRecycler_img);
        }
    }

    //点击监听接口
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
