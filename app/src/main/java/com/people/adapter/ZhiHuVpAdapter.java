package com.people.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.people.fragment.ColumnTwoFragment;
import com.people.fragment.DailyOneFragment;
import com.people.fragment.WeiXinThreeFragment;

public class ZhiHuVpAdapter extends FragmentPagerAdapter {
    public final int COUNT = 3;
    private String[] titles = new String[]{"日报" , "专栏 " , " 微信 "};
    private Context context;

    public ZhiHuVpAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment=new DailyOneFragment();
            break;
            case 1:
                fragment=new ColumnTwoFragment();
                break;
            case 2:
                fragment=new WeiXinThreeFragment();
                break;
        }

        return fragment ;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
