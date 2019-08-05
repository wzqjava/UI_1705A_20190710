package com.wzq.listveiw;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
        * 1--activity中写listview控件, 创建一个条目布局
        * 2--activity 中 找到控件设置适配器
        * 3-- 创建适配器 自定义类 extend BaseAdapter
        *      getcount
        *      getItem
        *      getItemId
        *      getView;
        */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> list;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);


        //初始化数据
        initData();
        //创建自定义数据适配器
        final MAdapter mAdapter = new MAdapter(MainActivity.this,list);
        //设置适配器
        lv.setAdapter(mAdapter);

    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Person("爱因斯坦"+i,"年龄"+i));
        }
    }



























}
