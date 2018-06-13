package com.lee.jeson316.mydemo.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.jeson316.mydemo.R;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonTrue, mButtonFalse, mButtonNext, mButtonPrev;
    private TextView mTextViewShow;
    private int numPostion;
    private Questions[] ques = new Questions[]{
            new Questions(R.string.question_australia, true),
            new Questions(R.string.question_oceans, true),
            new Questions(R.string.question_mideast, false),
            new Questions(R.string.question_africa, false),
            new Questions(R.string.question_americas, true),
            new Questions(R.string.question_asia, true)
    };
    private Questions q = ques[0];

    public static Intent createInstance(Context context) {
        return new Intent(context, QuizActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initUI();
        initData();
    }

    private void initUI() {
        mButtonTrue = findViewById(R.id.but_quiz_true);
        mButtonFalse = findViewById(R.id.but_quiz_false);
        mTextViewShow = findViewById(R.id.tv_quiz_show);
        mButtonNext = findViewById(R.id.but_quiz_next);
        mButtonPrev = findViewById(R.id.but_quiz_prev);
        //给控件添加点击事件监听。否则即使activity实现了View.OnClickListener接口也是无效过的；
        mButtonFalse.setOnClickListener(this);
        mButtonTrue.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
        mButtonPrev.setOnClickListener(this);
        mTextViewShow.setText(q.getTextResID());
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_quiz_true:
                showToast(true);
                break;
            case R.id.but_quiz_false:
                showToast(false);
                break;
            case R.id.but_quiz_next:
                nextQuestion();
                break;
            case R.id.but_quiz_prev:
                prevQuestion();
                break;
        }

    }

    //下一到题，注意角标越界
    private void nextQuestion() {
        if (numPostion % ques.length != (ques.length - 1)) {
            numPostion++;
            q = ques[numPostion % ques.length];
            mTextViewShow.setText(q.getTextResID());
        }
    }

    //上一到题，注意角标越界
    private void prevQuestion() {
        if (numPostion % ques.length != 0) {
            numPostion--;
            q = ques[numPostion % ques.length];
            mTextViewShow.setText(q.getTextResID());
        }
    }

    private void showToast(boolean pressButTrue) {
        int stringId = R.string.toast_quiz_wrong;
        if ((q.isAnswerTrue() && pressButTrue) || (!q.isAnswerTrue() && !pressButTrue)) {
            stringId = R.string.toast_quiz_right;
        }
        Toast toast = Toast.makeText(this, stringId, Toast.LENGTH_SHORT);
        //更改toast的显示位置
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (outState != null) {

        }
    }
}
