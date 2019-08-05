package com.wzq.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String tag = "MainActivity******";
    int anInt = 0;
    /**
     *
     * 每次调用这个方法的时候,记录当前页面的活动进度  3:20
     * 下次启动的时候, 使用记录变量
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        Log.e(tag, "onConfigurationChanged---");


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(tag, "onSaveInstanceState---");
    }

    // 重写
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(tag, "onCreate---创建");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart---开始,用户眼睛可见,但不可摸");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.d(tag, "onResume---用户可以操作当前页面");
    }


    // -----------
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.d(tag, "onPause---暂停");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.d(tag, "onStop--停止");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(tag, "onDestroy--销毁");

    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Log.d(tag, "onRestart--重建");


    }
}
