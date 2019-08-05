package bw.com.yuekaoa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
/**
 * 启动页
 * wzq
 * 7-25
 */
public class Main3Activity extends AppCompatActivity {

    private Button hui;
    private Person p;
    private EditText et_1;
    private EditText et_2;
    AutoCompleteTextView atTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        atTextview = findViewById(R.id.atTextview);
        initAutoTV();
        et_1 = findViewById(R.id.et_1);
        et_2 = findViewById(R.id.et_2);
        final Intent intent = getIntent();
        //获取传递过来的对象;
        p = (Person) intent.getSerializableExtra("key");
        //设置值
        et_1.setText(p.getName());
        et_2.setText(p.getId());

        hui = findViewById(R.id.hui);
        //按钮点击事件
        hui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_1.getText().toString();
                String id = et_2.getText().toString();
                Person person = new Person();
                person.setName(name);
                person.setId(id);

                Intent intent1 =   new Intent();
                intent1.putExtra("key_person1",person);
                setResult(101,intent1);
                finish();

            }
        });


    }

    private void initAutoTV() {

        //设置 自动文本框提示数据源;
        String[] tip = {"roll", "rollBall","red","redBean"};

        /**
         *  创建适配器,ArrayAdapter,比较简单,适合条目只有一行文字的条目
         *   this: 上下文
         *   simple_list_item_1 ,提示布局,使用的是android sdk 中提供的简单布局;
         */
        ArrayAdapter arrayAdapter
                = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tip);

        //设置适配器
        atTextview.setAdapter(arrayAdapter);



    }


}
