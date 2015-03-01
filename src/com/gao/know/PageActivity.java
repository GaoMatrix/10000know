
package com.gao.know;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.gao.know.adapter.ViewPagerAdapter;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class PageActivity extends Activity {

    private ViewPager mViewPager;
    private LocalActivityManager mLocalActivityManager;
    private SlidingMenu mSlidingMenu;

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
        
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        // 实例化一个slidingmenu
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT);// slidingmenu出现的屏幕左右方向
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置滑出slidingmenu的地方
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);// 设置主页面和slidingmenu页面之间的阴影图片
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影的宽度
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置主页面在slidingmenu上显示的宽度
        // sm.setBehindWidth(400);//直接设置slidingmenu的宽度
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);// 将当前的slidingmenu作为activity的一部分显示

        mSlidingMenu.setMenu(R.layout.activity_main);// 设置slidingmenu显示的layout
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("I'm Slidind menu");
        
        //new NavigationHandler(this, mSlidingMenu);// 实现导航页的动画需要的代码量比较大，所以写在单独的类中。
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
