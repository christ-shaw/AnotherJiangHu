package com.example.JiangHu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.JiangHu.Constant;
import com.example.JiangHu.MyTaskAdapter;
import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibinxiao on 2017/2/2.
 */

public class EachTabFragment extends Fragment {

    public MyTaskAdapter adapter;
    private List<TaskItem> taskList = new ArrayList<>();
    private int mPage;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String title;


    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void  refreshData(TaskItem newData)
    {
        taskList.add(0,newData);
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("page");

    }

    public static EachTabFragment newInstance(int page) {
        Bundle args = new Bundle();

        args.putInt("page", page);
        EachTabFragment fragment = new EachTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_each_tab, container, false);


        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.each_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
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

                                refreshData();
                                adapter.notifyDataSetChanged();
                                swipeRefreshLayout.setRefreshing(false);

                            }
                        });
                    }
                }).start();
            }
        });

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);

        refreshData();
        adapter = new MyTaskAdapter(getContext(),taskList);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

    public void refreshData()
    {
        taskList.clear();
        for (int i = 0; i < Constant.TaskFactory.size(); i++)
        {
            if (Integer.parseInt(Constant.TaskFactory.get(i).getAcccessbility()) == mPage)
            taskList.add(Constant.TaskFactory.get(i));
        }
    }

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }


}
