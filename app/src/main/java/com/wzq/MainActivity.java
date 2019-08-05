package com.wzq;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 *
 *          *
 *          * @param position
 *          * @param convertView
 *          * @param parent
 *          * @return 返回当前条目;
 *          *
 *          *优化的步骤:
 *          * 1 if中-->写ifelse, if中
 *          *      *生成复用对象
 *          *      *生成复用视图
 *                *寻找复用控件
 *                *设置tag
 *           2 else中-->
 *                *拿到tag,就是拿到复用对象
 *           3  ifelse--->
 *                *写完之后,就代表复用结束, 给复用对象中的控件赋值;
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<Person> list  = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);

        initData(); //初始化模拟数据
        MAdapter mAdapter = new MAdapter(); //创建适配器
        listView.setAdapter(mAdapter);      //添加适配器


    }

    /**
     * 准备条目集合数据
     */
    private void initData() {
        for (int i = 0; i <20 ; i++) {
            list.add(new Person("艾因斯坦" + i,"300"));
        }

    }

    /**
     * 适配器,专门给listview控件提供数据的;
     */
    class MAdapter extends BaseAdapter{

                // 返回视图,并给视图中的控件赋值
                @Override
                public View getView(int position, View convertView, ViewGroup viewGroup) {

                    ViewHolder viewHolder ;
                    if (convertView  == null) {    // 设置条目视图,找到视图中的控件
                        //优化对象
                        viewHolder = new ViewHolder();
                        //条目视图对象
                        convertView = View.inflate(MainActivity.this,R.layout.lv_item,null);
                        viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
                        viewHolder.tv_age = convertView.findViewById(R.id.tv_age);
                        convertView.setTag(viewHolder); //把优化对象和条目视图进行关联

                    }else {
                        // 从条目视图拿到优化对象;
                        viewHolder = (ViewHolder)convertView.getTag();

                    }

                    viewHolder.tv_name.setText(list.get(position).getName());
                    viewHolder.tv_age.setText(list.get(position).getAge());


            return convertView; // 返回带数据的条目视图
        }

        //返回集合的长度;
        @Override
        public int getCount() {
            return list.size();
        }

        //返回一个个条目对象
        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        // 返回条目的下标
        @Override
        public long getItemId(int i) {
            return i;
        }


    }

    //优化类
    static  class ViewHolder{
        TextView tv_name;
        TextView tv_age;
    }



}
