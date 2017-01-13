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
import com.people.bean.DailyBean;

import java.util.List;

public class DailyRecyclerAdapter extends RecyclerView.Adapter<DailyRecyclerAdapter.MyViewHolder>{
//点击  Context context;
    private Context context;
    private  List<DailyBean.StoriesBean> dailylist;
    private OnItemClickListener mOnItemClickListener;

    public DailyRecyclerAdapter(Context context, List<DailyBean.StoriesBean> dailylist) {
        this.context = context;
        this.dailylist = dailylist;
    }

//点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dailyrecycler_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.dailyRecycler_text.setText(dailylist.get(position).getTitle());
        final List<String> s = dailylist.get(position).getImages();
        Glide.with(context)
                .load(s.get(0))//图片的url
                .diskCacheStrategy(DiskCacheStrategy.ALL) //缓冲全尺寸
                .centerCrop() //设置居中
                .placeholder(R.mipmap.ani_popover_loading_yz_11)//加载中图片
                .into(holder.dailyrecycler_img);//显示图片的控件
        //判断是否设置了监听器
        //单击判断
         if(mOnItemClickListener != null){
             //为ItemView设置监听器
               holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition(); // 1
                        mOnItemClickListener.onItemClick(holder.itemView,dailylist.get(position)); // 2
                    }
               });
         }
    }

    @Override
    public int getItemCount() {
        return dailylist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dailyRecycler_text;
        ImageView dailyrecycler_img;
        public MyViewHolder(View itemView) {
            super(itemView);
            dailyRecycler_text = (TextView) itemView.findViewById(R.id.dailyrecycler_text);
            dailyrecycler_img = (ImageView) itemView.findViewById(R.id.dailyrecycler_img);
        }
    }
    //点击监听接口
    public interface OnItemClickListener{
        void onItemClick(View view, DailyBean.StoriesBean position);
    }
}
