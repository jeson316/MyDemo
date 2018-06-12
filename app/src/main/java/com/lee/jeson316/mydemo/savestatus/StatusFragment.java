package com.lee.jeson316.mydemo.savestatus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lee.jeson316.mydemo.R;

public class StatusFragment extends Fragment {

    private String data;
    private EditText mEditText;
    private   Button mButton;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status_save, null);
        mEditText = view.findViewById(R.id.et_status_save_input);
        mButton = view.findViewById(R.id.but_status_save_add);
        mEditText.setText(data);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "add one!!!";
                mEditText.setText(data);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


}
