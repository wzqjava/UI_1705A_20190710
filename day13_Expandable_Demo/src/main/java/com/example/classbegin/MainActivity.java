package com.example.classbegin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ExpandableListView exLv;    // 二级列表控件;
    private List<String> groupList;     //分组集合,里面装的是字符串;
    private List<List<ChildUser>> allChildList; //子集合,里面装的是每一个组的集合;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exLv = (ExpandableListView) findViewById(R.id.exLV);
        initData(); //初始化数据;
        MAdapter mAdapter = new MAdapter();
        exLv.setAdapter(mAdapter);

        // 孩子的点击事件儿;
        exLv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String name = allChildList.get(groupPosition).get(childPosition).getName();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }


    //自定义的适配器;
    class MAdapter extends BaseExpandableListAdapter{

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            // inflate view
            // if elst 优化
                // ViewHolder;
            // 控件赋值
            ViewHolder0 viewHolder0;
            if (convertView == null) {
                viewHolder0 = new ViewHolder0();
                convertView = View.inflate(MainActivity.this, R.layout.group_item, null);
                viewHolder0.g_text = convertView.findViewById(R.id.g_text);
                convertView.setTag(viewHolder0);

            }else {
                viewHolder0 = (ViewHolder0)convertView.getTag();
            }

            viewHolder0.g_text.setText(groupList.get(groupPosition));//设置分组名称;
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder1 viewHolder1;
            if (convertView == null) {
                viewHolder1 = new ViewHolder1();
                convertView = View.inflate(MainActivity.this,R.layout.child_item,null);
                viewHolder1.c_name = convertView.findViewById(R.id.c_name);
                viewHolder1.c_message = convertView.findViewById(R.id.c_message);
                convertView.setTag(viewHolder1);
            }else {
                viewHolder1 =  (ViewHolder1)convertView.getTag();
            }
            //赋值;
            viewHolder1.c_name.setText(allChildList.get(groupPosition).get(childPosition).getName());
            viewHolder1.c_message.setText(allChildList.get(groupPosition).get(childPosition).getMessage());
            return convertView;
        }




        //返回分组的数量
        @Override
        public int getGroupCount() {

            return groupList.size();
        }

        //得到孩子的数量***
        @Override
        public int getChildrenCount(int groupPosition) {
            return allChildList.get(groupPosition).size();
        }

        //得到分组中的对象***
        @Override
        public Object getGroup(int groupPosition) {
            return groupList.get(groupPosition);
        }

        //获取孩子对象***
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return allChildList.get(groupPosition).get(childPosition);
        }

        //返回某个分组的id
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        // 返回孩子的id;
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //        分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们。
        @Override
        public boolean hasStableIds() {
            return true;
        }


        //   指定位置上的子元素是否可选中
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }


        class ViewHolder0{
            TextView g_text;

        }


         class ViewHolder1 {

             public TextView c_name;
             public TextView c_message;

         }
    }






    private void initData() {

        groupList = new ArrayList<String>();    //组的集合
        groupList.add("aa");
        groupList.add("bb");
        groupList.add("cc");

        //--------------------------------

        allChildList = new ArrayList<List<ChildUser>>();// 大集合里面装的是多个小集合;

        List<ChildUser> list01 = new ArrayList<ChildUser>();
        list01.add(new ChildUser( "aaa01", "a01"));
        list01.add(new ChildUser( "aaa01", "a01"));
        list01.add(new ChildUser( "aaa01", "a01"));
        list01.add(new ChildUser( "aaa01", "a01"));

        List<ChildUser> list02 = new ArrayList<ChildUser>();
        list02.add(new ChildUser( "a02", "a02"));
        list02.add(new ChildUser( "a02", "a02"));
        list02.add(new ChildUser( "a02", "a02"));
        list02.add(new ChildUser( "a02", "a02"));

        List<ChildUser> list03 = new ArrayList<ChildUser>();
        list03.add(new ChildUser( "a03", "a03"));
        list03.add(new ChildUser( "a03", "a03"));
        list03.add(new ChildUser( "a03", "a03"));
        list03.add(new ChildUser( "a03", "a03"));

        allChildList.add(list01);
        allChildList.add(list02);
        allChildList.add(list03);

    }




}
