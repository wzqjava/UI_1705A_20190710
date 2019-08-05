package com.wzq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name,ed_pwd1,ed_pwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //给程序设置布局
        setContentView(R.layout.activity_main);


        Button btn_registe = (Button) findViewById(R.id.btn_registe);



        btn_registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取全局上下文
                MApplication application = (MApplication)getApplication();
                //存入数据
                application.setTemp("1705A");

                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });










    }
}
