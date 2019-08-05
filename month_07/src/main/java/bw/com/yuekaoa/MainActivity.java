package bw.com.yuekaoa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 启动页
 * wzq
 * 7-25
 * ctrl+alt+L 代码格式化;
 */
public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    int time = 5;
    int pro = 0;
    private TextView tv_2;
    private ImageView iv1;
    private Button btn_tiao;
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (time <= 0) {
                //跳转
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();

            } else {
                time--;
                pro = pro + 20; // 进度条每次+20
                tv_2.setText(time + "");
                pb.setProgress(pro);    //设置进度
                handler.sendEmptyMessageDelayed(1, 1000);
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到id
        pb = findViewById(R.id.pb);
        //点击按钮跳转
        btn_tiao = findViewById(R.id.btn_tiao);
        iv1 = findViewById(R.id.iv1);
        tv_2 = findViewById(R.id.tv_2);
        tv_2.setText("5");
        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                // 延迟1秒发消息;
                handler.sendMessageDelayed(message, 1000);
            }
        }.start();

        playAnimation();    // 播放动画


        //点击时间
        btn_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              time = 0; // handler 里面会判断time大小,进行跳转;
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        });


    }

    /**
     * 播放动画
     */
    private void playAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0,360);
        rotateAnimation.setDuration(5000);
        iv1.startAnimation(rotateAnimation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        btn_tiao.setOnClickListener(null);// 把监听置空;
        handler.removeMessages(1);// 生命周期中取消发送消息;
    }
}
