package com.lee.jeson316.mydemo.showmessage;


public interface IClickActionListener<T>{

    void multClickItems(T holder,int postion);

    void singleClickItem(T holder,int postion);

}
