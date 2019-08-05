package com.wzq.listveiw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        //lv条目的点击事件儿
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //传递对象
                intent.putExtra("key_person",list.get(i));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "点击..", Toast.LENGTH_SHORT).show();
            }
        });


        // listview的长按事件儿
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //传递对象

                startActivity(intent);
                Toast.makeText(MainActivity.this, "长按", Toast.LENGTH_SHORT).show();

//                return false;   // 长按后,会再次进入点击事件儿;
                 return true;       // 只会进入长按事件儿
            }
        });






    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Person("爱因斯坦"+i,"年龄"+i));
        }
    }


}
