package com.example.demo2.Packler;

import com.example.demo2.Bean;
import com.example.demo2.CallBeack.CallBeack;
import com.example.demo2.Moder.Moder;
import com.example.demo2.MyView.MyView;

public class ImpPackler implements Packler,CallBeack {
    private Moder moder;
    private MyView myView;

    public ImpPackler(Moder moder, MyView myView) {
        this.moder = moder;
        this.myView = myView;
    }

    @Override
    public void Chenggong(Bean bean) {
        myView.Chenggong(bean);
    }

    @Override
    public void Shibai(String str) {
        myView.Shibai(str);
    }

    @Override
    public void getData() {
        moder.getData(this);
    }
}
