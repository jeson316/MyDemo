package com.lee.jeson316.mydemo.savestatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lee.jeson316.mydemo.R;
import com.lee.jeson316.mydemo.base.BaseActivity;

public class StatusStoryActivity extends BaseActivity {

    private static final String TAG = "STATUS_FRAGMENT";
    private StatusFragment mStatusFragment;

    public static Intent createInstance(Context context) {
        return new Intent(context, StatusStoryActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containtor);
        initUI();
    }

    private void initUI() {
        mStatusFragment = (StatusFragment) getSupportFragmentManager().findFragmentByTag(TAG);
        if (mStatusFragment == null) {
            mStatusFragment = new StatusFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.base_container, mStatusFragment, TAG)
                    .commit();
            mStatusFragment.setData("hahhahaha");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
