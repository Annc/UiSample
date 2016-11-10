package com.example.dou.uisample;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Dou on 2016/4/11.
 */
public class MyTableActivity extends TabActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost1 = getTabHost();
        TabHost.TabSpec tabSpec1 = tabHost1.newTabSpec("Tab1")
                .setIndicator("one",getResources().getDrawable(R.drawable.tu))
                .setContent(new Intent(this,MyListActivity.class));
        tabHost1.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost1.newTabSpec("Tab2")
                .setIndicator("TWO",getResources().getDrawable(R.drawable.tu))
                .setContent(new Intent(this,MainActivity.class));
        tabHost1.addTab(tabSpec2);

    }

}
