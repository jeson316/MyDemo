package com.lee.jeson316.mydemo.okhttpdemo;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.lee.jeson316.mydemo.R;
import com.lee.jeson316.mydemo.okhttpdemo.fragment.OkHttpFragment;

public class OkhttpDemoActivity extends AppCompatActivity {

    public static final String Tag = "OKHTTPFragment";

    public static Intent createInstance(Context context) {
        return new Intent(context, OkhttpDemoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_containtor);
        initActionBar();
        initUI();

    }

    private void initActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initUI() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.base_container, new OkHttpFragment(), Tag)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
