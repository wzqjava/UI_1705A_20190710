package wzq.com.day15_handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 主线程:ui线程,界面显示的那个线程
 * <p>
 * 子线程不能更新主线程ui
 */
public class MainActivity extends AppCompatActivity {

    int time = 5;
    private TextView tv;

    /**
     *  在不同线程中传递数据 ---传递数据,
     * 创建handler对象, 在线程间通信
     */
    Handler handler = new Handler(){
        // 只要发消息就会进入handleMessage;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time <= 0) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                finish();
            }else {
                time --;
                tv.setText(time + "");
                // 发送空消息, 延迟1秒
                handler.sendEmptyMessageDelayed(1,1000);  //发送空消息;

            }

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("5");

        //模拟子线程
        new Thread(){
            @Override
            public void run() {
                super.run();

                Message message = new Message();
                message.what =1;
                message.arg1 =1;
                message.arg2 = 2;

                // 延迟1000毫秒发消息;
                handler.sendMessageDelayed(message,1000);

            }
        }.start();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消发送what值为1的消息;
        handler.removeMessages(1);

    }
}
