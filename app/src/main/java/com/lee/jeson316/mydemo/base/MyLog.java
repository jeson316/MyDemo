package com.lee.jeson316.mydemo.base;

public class MyLog {

    public static void E(Object t, String msg) {
        android.util.Log.e(t.getClass().getName().toUpperCase(), msg);
    }
}
