package com.wzq.sendobject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
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

//    String name ="";
//    String sex = "";
//    String hobby = "";
    private Person person;
    private RadioButton rb_man;
    private RadioButton rb_woman;

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

        rb_man = findViewById(R.id.rb_man);
        rb_woman = findViewById(R.id.rb_woman);

        person = new Person();


        // 单选框的监听事件儿
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId){
                            case R.id.rb_man:
                                person.setSex("男");

                            break;
                            case R.id.rb_woman:
                               person.setSex("女");
                            break;

                        }
            }
        });

        cb_android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                person.setHobby("Android");

            }
        });





        // 按钮的点击事件儿;
        btn_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ed_name.getText().toString();
                person.setName(name);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //把对象存入intent;
                intent.putExtra("key_person",person);



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
     * 接收回传值的方法;
     *  想要接受回传的数据,必须重写这个onActivityResult方法
     *  这个方法中的 data,就是第二页面传递过来的intent
      */

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent intent1) {
        super.onActivityResult(requestCode, resultCode, intent1);

        if (intent1 != null) {
            Person person1 = (Person) intent1.getSerializableExtra("key_person1");

            String backString = person1.getName()+person1.getSex()+person1.getHobby();

            Toast.makeText(this, backString, Toast.LENGTH_SHORT).show();
            Log.e("wzq",backString);

            String sex = person1.getSex();

            if ("男".equals(sex) ) {
                rb_man.setChecked(true);
            }

            if ("女".equals(sex) ) {
                rb_woman.setChecked(true);
            }

        }



    }
}
