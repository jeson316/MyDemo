package com.lee.jeson316.mydemo.rxjavademo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lee.jeson316.mydemo.R;

public class RxJavaAvtivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;

    public static Intent createInstance(Context context) {
        return new Intent(context, RxJavaAvtivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiyt_rx);

        mTabLayout = findViewById(R.id.tabl_rx);
        mViewPager = findViewById(R.id.vp_rx);
    }
}
