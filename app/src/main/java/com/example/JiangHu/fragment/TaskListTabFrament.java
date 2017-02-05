package com.example.JiangHu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.JiangHu.R;
import com.example.JiangHu.TaskItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibinxiao on 2017/2/2.
 */

public class TaskListTabFrament extends Fragment {

    ViewPager viewPager;

    public static TaskItem createNewItem(String title, String info, String price, String access) {
        TaskItem orderListItem1 = new TaskItem();
        orderListItem1.setTitle(title);
        orderListItem1.setContent(info);
        orderListItem1.setPayment(price + "元");
        orderListItem1.setStatus("2");
        orderListItem1.setBeginDate("2015-10-26 10:33");
        orderListItem1.setAcccessbility(access);
        return orderListItem1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tasklist, null);


        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter =
                new PagerAdapter(getActivity().getSupportFragmentManager(), getContext());
        viewPager.setAdapter(pagerAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;

    }

    public void refresh()
    {
        viewPager.getAdapter().notifyDataSetChanged();
    }


    class PagerAdapter extends FragmentStatePagerAdapter {

        String tabTitles[] = new String[]{"本校", "本市", "系统"};
        Context context;

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            EachTabFragment fragment  = (EachTabFragment) super.instantiateItem(container, position);
//            fragment.refreshData();
//            return fragment;
//        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return EachTabFragment.newInstance(0);
                case 1:
                    return EachTabFragment.newInstance(1);
                case 2:
                    return EachTabFragment.newInstance(2);
                default:
                    return EachTabFragment.newInstance(0);
            }

        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }


    } ;

    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
