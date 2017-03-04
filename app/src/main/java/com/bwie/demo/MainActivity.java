package com.bwie.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;



import java.util.ArrayList;

import java.util.List;

public
class
MainActivity extends AppCompatActivity {

    private String path="http://i.dxy.cn/snsapi/home/feeds/list/all?sid=4df0360f-2a20-4198-beb8-4dc5660c4f08&u=zhetianyishou&s=10&mc=0000000049029dcaffffffff99d603a9&token=TGT-13165-buaw5fHpqLlefw9bSOB0oF41fobaV4rMZmK-50&hardName=iToolsAVM_T0008098S&ac=4124c5f1-2029-4fda-b06f-a87ac5ad8d11&bv=2013&vc=6.0.6&tid=c25e673d-e82a-4e46-bd4e-c1e86d497126&vs=4.4.4&ref_tid=54720e1a-7eed-4993-9f51-3d760f3d0b2e";
    private String titlepath="http://i.dxy.cn/snsapi/event/count/list/all";
    private List<String> stringList=new ArrayList<>();
    private List<String> titleList=new ArrayList<>();
    private List<ContentBean> contentBeanList=new ArrayList<>();
    private Banner banner;


    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        banner=  (Banner) findViewById(R.id.banner);
        getdate();
    }

    //请求正文数据
    public void getdate(){

        OkHttpUtils.get().url(path).build().execute(new StringCallback() {

            @Override
            public void onError(Request request, Exception e) {

            }
            @Override
            public void onResponse(String response) {


                Bean bean = new Gson().fromJson(response, Bean.class);
                List<Bean.ItemsBean> items = bean.getItems();
                for (int i = 0; i < items.size(); i++) {

                    ContentBean contentBean = new Gson().fromJson(items.get(i).getContent(), ContentBean.class);
                    contentBeanList.add(contentBean);

                }
                MyAdapter myAdapter = new MyAdapter(items,contentBeanList,MainActivity.this);
                recyclerView.setAdapter(myAdapter);

            }
        });
        //请求轮播图
        OkHttpUtils.get().url(titlepath).build().execute(new StringCallback() {

            @Override
            public void onError(Request request, Exception e) {

            }
            @Override
            public void onResponse(String response) {

                CarouselBean carouselBean = new Gson().fromJson(response, CarouselBean.class);

                List<CarouselBean.ItemsBean> items = carouselBean.getItems();

                for (int i=0;i<items.size();i++){

                    stringList.add(items.get(i).getPath());
                    titleList.add(items.get(i).getTitle());
                }
                //设置轮播图的类型
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
                banner.setImageLoader(new GImager());
                banner.setImages(stringList);
                banner.setBannerTitles(titleList);
                //开始轮播
                banner.start();

            }
        });
    }


}
