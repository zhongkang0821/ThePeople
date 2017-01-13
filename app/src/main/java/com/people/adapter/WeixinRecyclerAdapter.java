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
import com.people.bean.WeixinBean;

import java.util.List;

public class WeixinRecyclerAdapter extends RecyclerView.Adapter<WeixinRecyclerAdapter.MyViewHolder> {

    Context context;
    List<WeixinBean.NewslistBean> freshweixinList;
    private OnItemClickListener mOnItemClickListener;

    public WeixinRecyclerAdapter(Context context, List<WeixinBean.NewslistBean> freshweixinList) {
        this.context = context;
        this.freshweixinList = freshweixinList;
    }

    //点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weixinrecycler_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.weixinaddress.setText(freshweixinList.get(position).getDescription());
        holder.weixindate.setText(freshweixinList.get(position).getCtime());
        holder.weixintitle.setText(freshweixinList.get(position).getTitle());
        Glide.with(context)
                .load(freshweixinList.get(position).getPicUrl())//图片的url
                .diskCacheStrategy(DiskCacheStrategy.ALL) //缓冲全尺寸
                .centerCrop() //设置居中
                .placeholder(R.mipmap.ani_popover_loading_yz_11)//加载中图片
                .into(holder.weixinimg);//显示图片的控件
        //判断是否设置了监听器
        //单击判断
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,freshweixinList.get(position)); // 2
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return freshweixinList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView weixinimg;
        TextView weixintitle;
        TextView weixinaddress;
        TextView weixindate;

        public MyViewHolder(View itemView) {
            super(itemView);
            weixinimg = (ImageView) itemView.findViewById(R.id.weixinImg);
            weixintitle = (TextView) itemView.findViewById(R.id.weixintitle);
            weixinaddress = (TextView) itemView.findViewById(R.id.weixinaddress);
            weixindate = (TextView) itemView.findViewById(R.id.weixindate);
        }
    }

    //点击监听接口
    public interface OnItemClickListener{
        void onItemClick(View view, WeixinBean.NewslistBean position);
    }
}
