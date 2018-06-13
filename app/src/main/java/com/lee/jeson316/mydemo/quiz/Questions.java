package com.lee.jeson316.mydemo.quiz;

import android.support.annotation.StringRes;

public class Questions {
    @StringRes
    private int mTextResID;
    private boolean mAnswerTrue;

    public Questions() {
    }

    public Questions(int textResID, boolean answerTrue) {
        mTextResID = textResID;
        mAnswerTrue = answerTrue;
    }

    public int getTextResID() {
        return mTextResID;
    }

    public void setTextResID(@StringRes int textResID) {
        mTextResID = textResID;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
