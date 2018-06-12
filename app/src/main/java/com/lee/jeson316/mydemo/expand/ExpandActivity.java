package com.lee.jeson316.mydemo.expand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.lee.jeson316.mydemo.R;

import java.util.ArrayList;
import java.util.List;

//https://blog.csdn.net/dl10210950/article/details/52525492
public class ExpandActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String> groupList;
    private List<List<String>> childList;
    private ExpAdapter<String> adapter;

    public static Intent createInstance(Context context) {
        return new Intent(context, ExpandActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_expand);
        initView();
    }

    private void initView() {
        expandableListView = findViewById(R.id.exp_lv);
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        addData("幼稚园同学", new String[]{"周杰伦", "江一燕 ", "佟丽娅", "高圆圆", "刘诗诗", "刘亦菲", "angleBaby", "张静初", "张含韵",});
        addData("小学同学", new String[]{"光头强", "熊大", "熊二", "妙蛙种子", "比卡丘", "双蛋瓦斯", "贪吃蛇"});
        addData("初中同学", new String[]{"苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里"});
        addData("高中同学", new String[]{"习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"});
        addData("大学同学", new String[]{"周杰伦", "江一燕 ", "佟丽娅", "高圆圆", "刘诗诗", "刘亦菲", "angleBaby", "张静初", "张含韵",});
        addData("研究生同学", new String[]{"光头强", "熊大", "熊二", "妙蛙种子", "比卡丘", "双蛋瓦斯", "贪吃蛇"});
        addData("博士同学", new String[]{"苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里"});
        addData("教授同事", new String[]{"习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"});
        addData("众仙家名册", new String[]{"苍井空", "小泽玛利亚", "吉泽明步", "波多野结衣", "爱川美里菜", "小川阿佐美", "桃谷绘里香", "泷泽萝拉", "北原多香子", "石川施恩惠", "北条麻妃", "麻仓优", "羽田爱", "保坂绘里", "习近平", "胡锦涛", "江泽民", "毛泽东", "秦始皇", "李世民", "武则天", "曹操", "刘备", "孙权"});
        adapter = new ExpAdapter<>(groupList,childList,this);
        expandableListView.setAdapter(adapter);
//        expandableListView.setGroupIndicator(null);   // 隐藏默认的折叠箭头
    }

    /**
     * 用来添加数据的方法
     */
    private void addData(String group, String[] friend) {
        groupList.add(group);
        //每一个item打开又是一个不同的list集合
        List<String> childitem = new ArrayList<>();
        for (int i = 0; i < friend.length; i++) {
            childitem.add(friend[i]);
        }
        childList.add(childitem);
    }
}