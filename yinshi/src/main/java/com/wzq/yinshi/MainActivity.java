package com.wzq.yinshi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 隐式跳转
     * @param view
     */
    public void send(View view) {

        //跳转短信的页面
        Intent intent=new Intent();

        //设置action,action字符串是android提供的,
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:1300000000"));
        intent.putExtra("sms_body","发送短信内容");

        startActivity(intent);
    }
}
