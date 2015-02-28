
package com.gao.know;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        View view = findViewById(R.id.welcome_layout);
        AlphaAnimation anim = new AlphaAnimation(0.1f, 1.0f);
        anim.setDuration(3000);
        view.startAnimation(anim);

        anim.setAnimationListener(am);
    }

    private AnimationListener am = new AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            // 动画执行结束的时候去主页面
            Intent intent = new Intent();
            intent.setClass(WelcomeActivity.this, PageActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };

}
