package bw.com.yuekaoa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MAdapter extends BaseAdapter {
    Context context;
    ArrayList<Person> lists = new ArrayList();


    public MAdapter(Context context, ArrayList<Person> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            //创建布局
            convertView = View.inflate(context, R.layout.listview, null);

            //寻找控件
            viewHolder.tv_id = convertView.findViewById(R.id.tv_id);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);

            //关联
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.tv_id.setText(lists.get(position).getId());
        viewHolder.tv_name.setText(lists.get(position).getName());

        return convertView;
    }

    // 当集合数据改变的时候,把数据重置;
    public void setData(ArrayList<Person> lists) {
        this.lists = lists;
        MAdapter.this.notifyDataSetChanged(); // 刷新适配器,
    }


    //创建复用类
    static class ViewHolder {
        TextView tv_id;
        TextView tv_name;
    }
}
