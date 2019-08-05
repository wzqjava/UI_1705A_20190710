package bw.com.yuekaoa;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * 启动页
 * wzq
 * 7-25
 */
public class Main2Activity extends AppCompatActivity {


    private ListView lv;
    private MAdapter mAdapter;

    //创建大集合
    ArrayList<Person> lists = new ArrayList<Person>();
    int ps;
    private ProgressDialog progressDialog;

    //创建handler

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.dismiss();   // 集合中有数了,关闭加载进度条
            ArrayList<Person> listTemp = (ArrayList) msg.obj;
            lists.addAll(listTemp); // 把子线程发送过来的临时集合放入大集合中;
            mAdapter.setData(lists);    // 把集合传递过去刷新适配器;


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lv);
        //初始化数据
        initData();

        mAdapter = new MAdapter(Main2Activity.this, lists);
        lv.setAdapter(mAdapter);

        //点击传值
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * position为点击的下标;设置成全局变量,回传的时候要更新点击的条目;
                 */
                ps = position;
                Person person = lists.get(position);
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("key", person); // Person类要实现序列化接口
                startActivityForResult(intent, 101);   // 传值并等待接收回传;

            }
        });


        //长按弹出对话框删除
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("提示框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("您要删除吗?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.e("wzq", "删除了下标:"+position);
                        lists.remove(position); // 改变集合中的数据
                        mAdapter.setData(lists); // 把删除后的集合传递给适配器,
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Main2Activity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create().show();
                return true;
            }
        });
    }

    /**
     * 接收回传数据的方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            Person person1 = (Person) data.getSerializableExtra("key_person1");
            // ps是刚才点击的条目下标
            lists.set(ps, person1);
            mAdapter.setData(lists);


        }
    }

    public void initData() {

        showProgressDia(); // 加载进度要放在主线程;
        //创建线程
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ArrayList<Person> listTemp = new ArrayList<Person>();
                for (int i = 1; i < 20; i++) {
                    listTemp.add(new Person("爱因斯坦" + i, "300" ));

                }
                Message message = new Message();
                message.what = 1;
                message.obj = listTemp; // message中装着集合
                handler.sendMessage(message);
            }
        }.start();

    }

    // 显示加载进度条
    private void showProgressDia() {
        progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setTitle("加载提示");
        progressDialog.setMessage("加载中,请稍后.....");

        progressDialog.setCancelable(true); //  可取消
        progressDialog.setCanceledOnTouchOutside(true); //  触摸加载之外区域可以取消;
        progressDialog.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
        lv.setOnLongClickListener(null);
        lv.setOnItemClickListener(null);
    }
}
