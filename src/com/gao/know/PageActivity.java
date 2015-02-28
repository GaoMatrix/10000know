
package com.gao.know;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gao.know.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageActivity extends Activity {

    private ViewPager mViewPager;
    private LocalActivityManager mLocalActivityManager;

    /**
     * 让ViewPager滑动activity ViewPager滑动view或者是Fragment
     * 滑动的activity的生命周日方法只有onCreate会被调用，onResume ... 不会被调用
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_layout);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        // 将滑动的Activity转成view
        mLocalActivityManager = new LocalActivityManager(this, true);
        mLocalActivityManager.dispatchCreate(savedInstanceState);// 必须被调用
        initAcitivities();
    }

    /**
     * 将滑动的Activity转成view
     */
    private void initAcitivities() {
        List<View> viewList = new ArrayList<View>();

        Intent intent = new Intent(this, MainActivity.class);
        View mainView = mLocalActivityManager.startActivity("MainActivity", intent).getDecorView();
        viewList.add(mainView);

        Intent intent2 = new Intent(this, IAskActivity.class);
        View iaskView = mLocalActivityManager.startActivity("IAskActivity", intent2).getDecorView();
        viewList.add(iaskView);

        // 将viewList放到ViewPager的适配器中去显示
        ViewPagerAdapter adapter = new ViewPagerAdapter(viewList);
        mViewPager.setAdapter(adapter);
    }

}
