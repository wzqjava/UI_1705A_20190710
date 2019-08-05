package com.wzq.listveiw;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * author:Created by WangZhiQiang on 2018/10/12.
 */
public class MAdapter extends BaseAdapter {

    Context context;
    ArrayList<Person> list;

    public MAdapter(Context context, ArrayList<Person> list) {
        this.context = context;
        this.list = list;

    }

    /**
     * 返回listview中的条目
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     *
     *
     *          * @param position
     *          * @param convertView
     *          * @param parent
     *          * @return 返回当前条目;
     *          *
     *          *优化的步骤:
     *          * 1 if中-->写ifelse, if中
     *          *      *生成复用对象
     *          *      *生成复用视图
     *          *      *寻找复用控件
     *          *      *设置tag
     *          * 2 else中-->
     *          *      *拿到tag,就是拿到复用对象
     *
     *          * 3  优化之后设置数据--->
     *          *      *写完之后,就代表复用结束, 给复用对象中的控件赋值;
     *          *
     *          *
     *
     */

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //复用类对象;
        ViewHolder viewHolder ;

        if (convertView == null) {
            viewHolder = new ViewHolder();  //创建复用对象
            // 创建复用布局
            convertView = View.inflate(context, R.layout.lv_item, null);
            // 寻找控件;
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_age = convertView.findViewById(R.id.tv_age);

            convertView.setTag(viewHolder); // 把条目对象和复用对象关联;
            Log.e("wzq", "哈哈哈,我是新创建的条目");
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            Log.e("wzq", "嘿嘿嘿,我是复用条目");

        }

        //编译时错误;
        viewHolder.tv_name.setText(list.get(position).getName());
        viewHolder.tv_age.setText(list.get(position).getAge());
        return convertView;
    }


    //返回集合的长度
    @Override
    public int getCount() {
        return list.size();
    }

    //返回集合中某个条目
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //返回某个对象的下标;
    @Override
    public long getItemId(int position) {
        return position;
    }

    //复用类,装的是条目中的控件
    class ViewHolder {
        TextView tv_name;
        TextView tv_age;


    }







}
