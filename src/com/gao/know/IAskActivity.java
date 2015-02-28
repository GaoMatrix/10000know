package com.gao.know;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IAskActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(IAskActivity.class.getSimpleName());
        
    }
}
