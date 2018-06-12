package com.lee.jeson316.mydemo.expand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.lee.jeson316.mydemo.R;

import java.util.List;

public class ExpAdapter<String> extends BaseExpandableListAdapter {
    private List<String> groupData;
    private List<List<String>> childData;
    private Context context;

    public ExpAdapter(List<String> groupData, List<List<String>> childData) {
        this.groupData = groupData;
        this.childData = childData;
    }

    public ExpAdapter(List<String> groupData, List<List<String>> childData, Context context) {
        this.groupData = groupData;
        this.childData = childData;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupData.get(groupPosition);
//        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            holder = new GroupViewHolder();
//            convertView = LayoutInflater.from(context).inflate(R.layout.itme_exp_group, null);
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itme_exp_group, null);
            holder.textView = convertView.findViewById(R.id.tv_time_exp_group);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        String t = groupData.get(groupPosition);
        holder.textView.setText(t.toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (null == convertView) {
            holder = new ChildViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exp_child, null);
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_exp_child, null);
            holder.textView = convertView.findViewById(R.id.tv_item_exp_child);
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        List<String> fList = childData.get(groupPosition);
        String f = fList.get(childPosition);
        holder.textView.setText(f.toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class GroupViewHolder {
        public TextView textView;
    }

    private class ChildViewHolder {
        public TextView textView;
    }

}
