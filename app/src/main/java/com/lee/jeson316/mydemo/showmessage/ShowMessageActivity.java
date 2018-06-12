package com.lee.jeson316.mydemo.showmessage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lee.jeson316.mydemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * .::::.
 * .::::::::.
 * :::::::::::
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 * <p>
 * <p>
 * Created by jeson316 on 2018/4/27.
 */

public class ShowMessageActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView recyclerView;
    private TextView textView;
    private List<IPitctureDetail> drawables;
    int[] dras;
    private RecyclerView.Adapter adapter;

    public static Intent createInstance(Context context) {
        return new Intent(context, ShowMessageActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        button = (Button) findViewById(R.id.but_message_add);
        recyclerView = (RecyclerView) findViewById(R.id.rec_message_show);
        textView = (TextView) findViewById(R.id.et_message_input);

        initData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(dras.length);
                drawables.add(new PictureDetail(dras[i], R.string.item_05,new Random().nextInt(2)));
                recyclerView.scrollToPosition(drawables.size()-1);
                adapter.notifyDataSetChanged();
            }
        });
        //瀑布流
//        StaggeredGridLayoutManager staggeredGridLayoutManager =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //标准
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new PictureDetailAdapter(drawables);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        dras = new int[]{R.drawable.t11, R.drawable.t10, R.drawable.t09,R.drawable.t08,R.drawable.t12};

        drawables = new ArrayList<>();

        drawables.add(new PictureDetail(R.drawable.t01, R.string.item_01));
        drawables.add(new PictureDetail(R.drawable.t02, R.string.item_02));
        drawables.add(new PictureDetail(R.drawable.t03, R.string.item_03));
        drawables.add(new PictureDetail(R.drawable.t04, R.string.item_04,1));
        drawables.add(new PictureDetail(R.drawable.t05, R.string.item_05));
        drawables.add(new PictureDetail(R.drawable.t06, R.string.item_06,2));
        drawables.add(new PictureDetail(R.drawable.t05, R.string.item_05));
        drawables.add(new PictureDetail(R.drawable.t04, R.string.item_04));
        drawables.add(new PictureDetail(R.drawable.t03, R.string.item_03,1));
        drawables.add(new PictureDetail(R.drawable.t07, R.string.item_01));
        drawables.add(new PictureDetail(R.drawable.t08, R.string.item_02,2));
    }
}
