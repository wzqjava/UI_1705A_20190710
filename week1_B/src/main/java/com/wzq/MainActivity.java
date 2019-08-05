package com.wzq;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 1,sdk路径
 * 2.gradle文件夹的位置
 *  Activity:和我们眼睛交互的界面,是android四大组件之一;
 *
 */
public class MainActivity extends AppCompatActivity {

    String name ="";
    String sex = "";
    String hobby = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册按钮
        Button btn_zhuce = findViewById(R.id.btn_zhuce);
        // 输入框
        final EditText ed_name = findViewById(R.id.ed_name);
        RadioGroup rg = findViewById(R.id.rg);  //单选group
        CheckBox cb_android = findViewById(R.id.cb_android);  //多选


        // 单选框的监听事件儿
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId){
                            case R.id.rb_man:
                                sex= "男";
                            break;
                            case R.id.rb_woman:
                                sex= "女";
                            break;

                        }
            }
        });

        cb_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                hobby = "Android";

            }
        });





        // 按钮的点击事件儿;
        btn_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = ed_name.getText().toString();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("key_name",name);// 可以任意命名,第二个页面接收必须用这个key
                intent.putExtra("key_sex",sex);
                intent.putExtra("key_hobby",hobby);



//                startActivity(intent); // 简单跳转
                /*
                跳转并得到回传数据的启动方式,
                只要用这个方法启动,返回的时候就会自动调用当前页面的onActivityResult
                 */
                startActivityForResult(intent,100);


            }
        });
    }


    /**
     *  想要接受回传的数据,必须重写这个onActivityResult方法
     *  这个方法中的 data,就是第二页面传递过来的intent
      */

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String key_name1 = data.getStringExtra("key_name1");
        String key_sex1 = data.getStringExtra("key_sex1");
        String key_hobby1 = data.getStringExtra("key_hobby1");

        String backString = key_name1+key_sex1+key_hobby1;




        Toast.makeText(this, backString, Toast.LENGTH_SHORT).show();
        Log.e("wzq",backString);


    }
}
