package com.lee.jeson316.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lee.jeson316.mydemo.activites.DesignAvtivity;
import com.lee.jeson316.mydemo.activites.SearchViewActivity;
import com.lee.jeson316.mydemo.expand.ExpandActivity;
import com.lee.jeson316.mydemo.okhttpdemo.OkhttpDemoActivity;
import com.lee.jeson316.mydemo.rxjavademo.RxJavaAvtivity;
import com.lee.jeson316.mydemo.savestatus.StatusStoryActivity;
import com.lee.jeson316.mydemo.showmessage.ShowMessageActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLLContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLLContainer = (LinearLayout) findViewById(R.id.ll_base_container);
        addButView("Design", DesignAvtivity.createInstance(this));
        addButView("ShowImage", ShowMessageActivity.createInstance(this));
        addButView("ExpList", ExpandActivity.createInstance(this));
        addButView("RxJava", RxJavaAvtivity.createInstance(this));
        addButView("Okhttp", OkhttpDemoActivity.createInstance(this));
        addButView("SearchView", SearchViewActivity.createInstance(this));
        addButView("StatusSave", StatusStoryActivity.createInstance(this));
//        addButView("Design", DesignAvtivity.createInstance(this));
    }

    private void addButView(String des, final Intent activityIntent) {
        Button but = new Button(this);
        but.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        but.setText(des);
        but.setAllCaps(false);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityIntent);
            }
        });
        mLLContainer.addView(but);
    }
}
