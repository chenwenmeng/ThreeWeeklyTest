package com.bwie.demo;


import android.content.Context;

import android.support.v7.widget.RecyclerView;



import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;


import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 类描述:
 * 作者：陈文梦
 * 时间:2017/3/4 09:24
 * 邮箱:18310832074@163.com
 */

public
class
MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<ContentBean> contentBeanList;
    private List<Bean.ItemsBean> beanList;


    public MyAdapter(List<Bean.ItemsBean> beanList, List<ContentBean> contentBeanList, Context context) {
        this.beanList = beanList;
        this.contentBeanList = contentBeanList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item1, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        Glide.with(context).load("http://img.dxycdn.com/avatars/120/" + beanList.get(position).getInfoAvatar()).into(viewHolder.imageView1);
        viewHolder.textView1.setText(contentBeanList.get(position).getSubject());
        viewHolder.textView2.setText(contentBeanList.get(position).getBody());
        if(TextUtils.isEmpty(contentBeanList.get(position).getUrl())){
            viewHolder.imageView2.setVisibility(View.GONE);
        }else {
            viewHolder.imageView2.setVisibility(View.VISIBLE);
            Glide.with(context).load("http://res.dxycdn.com/upload/" + contentBeanList.get(position).getUrl()).into(viewHolder.imageView2);
        }

    }

    @Override
    public int getItemCount() {
        return contentBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1, imageView2;
        TextView textView1, textView2;


        public MyViewHolder(View itemView) {
            super(itemView);

            imageView1 = (ImageView) itemView.findViewById(R.id.item_image);
            imageView2 = (ImageView) itemView.findViewById(R.id.item_image2);
            textView1 = (TextView) itemView.findViewById(R.id.item_text);
            textView2 = (TextView) itemView.findViewById(R.id.item_text2);


        }
    }
}
