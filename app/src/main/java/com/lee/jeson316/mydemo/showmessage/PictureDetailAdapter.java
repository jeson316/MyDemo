package com.lee.jeson316.mydemo.showmessage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lee.jeson316.mydemo.R;

import java.util.ArrayList;
import java.util.List;

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

public class PictureDetailAdapter extends RecyclerView.Adapter<PictureDetailAdapter.PictureDetailViewHolder> implements IClickActionListener<PictureDetailAdapter.PictureDetailViewHolder> {
    private List<IPitctureDetail> data = new ArrayList<>();
    private View view;

    @Override
    public void multClickItems(final PictureDetailViewHolder holder, final int postion) {
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.textView.setText("checked!!!");
                IPitctureDetail iPitctureDetail = data.get(postion);
                if (iPitctureDetail.isChecked()) {
                    data.get(postion).setChecked(false);
                } else {
                    data.get(postion).setChecked(true);
                }
                holder.textView.setText(iPitctureDetail.isChecked() ? R.string.checked : iPitctureDetail.descrpitionId());
            }
        });
    }

    @Override
    public void singleClickItem(PictureDetailViewHolder holder, int postion) {

    }


    class PictureDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        public PictureDetailViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_image_show);
            textView = itemView.findViewById(R.id.tv_item_text_show);
            linearLayout = itemView.findViewById(R.id.ll_bg);
        }
    }

    public PictureDetailAdapter(List<IPitctureDetail> data) {
        this.data = data;
    }

    @Override
    public PictureDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_show, null);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_show2, null);
        }
        return new PictureDetailViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PictureDetailViewHolder holder, int position) {
        IPitctureDetail t = data.get(position);
        holder.imageView.setImageResource(t.getImageId());
        holder.textView.setText(t.isChecked() ? R.string.checked : t.descrpitionId());
        multClickItems(holder, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).itemType();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


}
