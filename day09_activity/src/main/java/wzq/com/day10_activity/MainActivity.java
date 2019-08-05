package wzq.com.day10_activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

/**
 *
 * standard   标准模式
 *
 *
 singleTop    顶部单例模式

 ·singleTask	当Activity不存在，则会在当前task创建一个新的实例，若存在，则会把task中在其之上的其它Activity
 				destory掉并调用它的onNewIntent方法。

 ·singleInstance	只有一个实例，并且这个实例独立运行在一个task中，这个task只有这个实例，不允许有别的Activity存在。
 			这是一个极端的模式。一般适用于需要在系统中只存在一个实例的场景，比如Android系统的来电页面，
 			多次来电均使用的是一个Activity。
 */
public class MainActivity extends Activity {
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
