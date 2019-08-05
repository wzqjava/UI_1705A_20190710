package com.wzq;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv_name = findViewById(R.id.tv_name);

        //得到全局上下文
        MApplication application = (MApplication)getApplication();
        //得到 第一个页面存入的数据
        String temp = application.getTemp();

        Toast.makeText(application, temp, Toast.LENGTH_SHORT).show();


    }
}
