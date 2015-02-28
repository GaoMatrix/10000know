
package com.gao.know.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private List<View> list;

    public ViewPagerAdapter(List<View> list) {
        this.list = list;
    }

    /**
     * 一共有多少个数量
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 判断当前view是不是来自object
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    /**
     * item被销毁的时候
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        ViewPager vp = (ViewPager) container;
        View view = list.get(position);
        vp.removeView(view);
    }

    /**
     * item被生成的时候
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewPager vp = (ViewPager) container;
        View view = list.get(position);
        vp.addView(view);
        return view;
    }

}
