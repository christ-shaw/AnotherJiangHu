package com.example.materialtest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.materialtest.BannerModel;
import com.example.materialtest.MyTaskAdapter;
import com.example.materialtest.R;
import com.example.materialtest.TaskItem;
import com.example.materialtest.grid.MyGridAdapter;
import com.example.materialtest.grid.MyGridView;
import com.sivin.Banner;
import com.sivin.BannerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibinxiao on 2017/2/2.
 */

public class HomeFragment extends Fragment
{

    private SwipeRefreshLayout swipeRefresh;

    private MyGridView myGridView;

    private Banner mBanner;


    private MyTaskAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);

        buildupBanner(view);
        buildupGrid(view);



        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置adapter
        adapter = new MyTaskAdapter(getContext(),getNewsList());
        recyclerView.setAdapter(adapter);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });



        return view;
    }

    private void buildupGrid(View view) {
        myGridView=(MyGridView) view.findViewById(R.id.gridview);
        myGridView.setAdapter(new MyGridAdapter(getContext()));
    }

    private void buildupBanner(View view)
    {
        mBanner = (Banner) view.findViewById(R.id.id_banner);

        List<BannerModel> imgs = new ArrayList<BannerModel>();
        BannerModel bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title1);
        bannerModel.setTips("江湖秘籍");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title2);
        bannerModel.setTips("昭告天下");
        imgs.add(bannerModel);


        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title3);
        bannerModel.setTips("生财有道");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title4);
        bannerModel.setTips("人在江湖");
        imgs.add(bannerModel);

        bannerModel = new BannerModel();
        bannerModel.setImageId(R.mipmap.title5);
        bannerModel.setTips("海纳百川");
        imgs.add(bannerModel);


        BannerAdapter adapter = new BannerAdapter<BannerModel>(imgs) {
            @Override
            protected void bindTips(TextView tv, BannerModel bannerModel) {
                tv.setText(bannerModel.getTips());
            }
            @Override
            public void bindImage(ImageView imageView, BannerModel bannerModel) {
                Glide.with(getActivity())
                        .load(bannerModel.getImageId())
                        .placeholder(R.mipmap.empty)
                        .error(R.mipmap.error)
                        .fitCenter()
                        .into(imageView);
            }
        };
        mBanner.setBannerAdapter(adapter);
        mBanner.notifiDataHasChanged();
    }



    public static TaskItem createNewItem(String title, String info, String price)
    {
        TaskItem orderListItem1 = new TaskItem();
        orderListItem1.setTitle(title);
        orderListItem1.setContent(info);
        orderListItem1.setPrice(price+"元");
        orderListItem1.setStatus("2");
        orderListItem1.setDate("2015-10-26 10:33");
        return orderListItem1;
    }

    public static List<TaskItem> getNewsList( )
    {
        List<TaskItem> listItems = new ArrayList<>();
        listItems.add(createNewItem("送泡面", "深夜12点女朋友饿了，寻5号楼女同学给308寝的xx送包泡面", "20"));
        listItems.add(createNewItem("送伞", "女朋友聊天在上自习，寻A市B校同学去102自习室送一把伞", "20"));
        listItems.add(createNewItem("拉萨明信片", "相识纪念日，寻拉萨大学的同学给女朋友寄一张明信片到南京大学", "30"));
        listItems.add(createNewItem("求床位", "下周有同学来北京玩，学校内寻求两个床位", "40"));
        listItems.add(createNewItem("介绍校况", "高三学生，寻学长介绍一下学校情况", "30"));
        listItems.add(createNewItem("求导师信息", "跨城市考研，了解xx导师信息。", "200"));
        listItems.add(createNewItem("组织活动", "毕业10周年聚会，请一位同学帮忙联系学校组织活动。", "200"));
        listItems.add(createNewItem("补考试题", "上学期高数挂科了，马上补考，寻补考试题。", "100"));
        listItems.add(createNewItem("面经", "明天华为二面，寻找一位拿到offer的同学，咨询面试技巧。", "100"));
        listItems.add(createNewItem("求联系方式", "求外语系美女联系方式，打赏100元。", "100"));
        listItems.add(createNewItem("求西藏拍照", "给女朋友惊喜，求西藏学友在布达拉宫旁边写字拍照", "200"));
        listItems.add(createNewItem("求钢琴兼职", "侄子要学习钢琴，求介绍广州音乐学院钢琴专业兼职", "30"));
        listItems.add(createNewItem("北京稻香村", "想吃稻香村点心，求北京同学买和邮寄，打赏五十元", "50"));
        listItems.add(createNewItem("快闪", "2月14号想给女友惊喜，求十个人快闪，每人打赏五十元。", "50"));
        listItems.add(createNewItem("聚活动", "家乐福开业，寻三十人参与，一小时20元。", "20"));
        listItems.add(createNewItem("电脑维修", "电脑坏了急用，求维修。", "100"));
        listItems.add(createNewItem("魔兽副本", "魔兽世界，求三人组队带刷副本。", "20"));
        listItems.add(createNewItem("图书馆占座", "明天早上8.30，求图书馆占两位置，打赏十元。", "10"));
        listItems.add(createNewItem("代上英语", "明天上午前两节英语课求同学代上", "10"));
        listItems.add(createNewItem("英语四级答案", "求英语四级答案", "500"));
        listItems.add(createNewItem("物理期末考题", "马上考试，求大学物理去年期末考题", "50"));
        listItems.add(createNewItem("代取快递", "308寝室寻人长期代取快递", "1"));
        listItems.add(createNewItem("带烟", "已经熄灯锁门，求一包香烟", "20"));
        listItems.add(createNewItem("买演唱会门票", "明天下午寻一同学帮忙排队买演唱会门票", "50"));
        listItems.add(createNewItem("借吉他", "哪位同学有吉他，借用三天", "30"));
        listItems.add(createNewItem("借自行车", "借自行车一天", "10"));
        listItems.add(createNewItem("代资料", "天下午有去深圳大学的同学吗？顺便帮忙代一份资料过去", "6"));
        listItems.get(0).setStatus("1");
        listItems.get(1).setStatus("1");
        return listItems;

    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }

}
