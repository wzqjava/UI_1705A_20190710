package com.wzq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    String hobby = "";
    private EditText ed_name;
    private EditText ed_sex;
    private EditText ed_hobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_back = (Button) findViewById(R.id.btn_back);
        // 找控件
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_sex = (EditText) findViewById(R.id.ed_sex);
        ed_hobby = (EditText) findViewById(R.id.ed_hobby);

        // 得到第一个页面传过来的intent,从中取值
        final Intent intent = getIntent();
        String name = intent.getStringExtra("key_name");
        String sex = intent.getStringExtra("key_sex");
        String hobby = intent.getStringExtra("key_hobby");


        //设置值
        ed_name.setText(name);
        ed_sex.setText(sex);
        ed_hobby.setText(hobby);

        //回传值点击事件儿
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到值
                String name = ed_name.getText().toString();
                String sex = ed_sex.getText().toString();
                String hobby = ed_hobby.getText().toString();

                // 创建新的intent,向新Intent中存入值
                Intent intent1 = new Intent();
                intent1.putExtra("key_name1",name);
                intent1.putExtra("key_sex1",sex);
                intent1.putExtra("key_hobby1",hobby);

                // 设置结果
                setResult(101,intent1);

                finish(); //关闭当前Activity


            }
        });






    }
}
