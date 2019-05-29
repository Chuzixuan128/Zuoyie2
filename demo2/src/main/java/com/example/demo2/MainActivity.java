package com.example.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.demo2.Moder.ImpModer;
import com.example.demo2.MyView.MyView;
import com.example.demo2.Packler.ImpPackler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {
    private RecyclerView mLv;
    private ArrayList<Bean.ResultsBean> list;
    private LvMy lvMy;
    private ImpPackler impPackler;

    //楚子轩
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        impPackler = new ImpPackler(new ImpModer(),this);
        initView();
        initData();
    }

    private void initData() {
        impPackler.getData();
    }

    private void initView() {
        mLv = (RecyclerView) findViewById(R.id.lv);
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lvMy = new LvMy(this,list);
        mLv.setLayoutManager(linearLayoutManager);
        mLv.setAdapter(lvMy);
    }

    @Override
    public void Chenggong(Bean bean) {
        List<Bean.ResultsBean> results = bean.getResults();
        list.addAll(results);
        lvMy.setList(list);
        lvMy.notifyDataSetChanged();
    }

    @Override
    public void Shibai(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
