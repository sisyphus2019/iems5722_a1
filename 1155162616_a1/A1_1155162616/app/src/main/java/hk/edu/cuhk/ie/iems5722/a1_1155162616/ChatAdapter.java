package hk.edu.cuhk.ie.iems5722.a1_1155162616;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    //布局资源
    private LayoutInflater inflater;
    //数据源
    private List<MessageBean> messageBeanList;

    public ChatAdapter(){}

    public ChatAdapter(Context context,List<MessageBean> messageBeans){
        this.messageBeanList = messageBeans;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return messageBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.messagelist_item,null);
            holder.text = (TextView)convertView.findViewById(R.id.message_send);
            holder.time = (TextView)convertView.findViewById(R.id.message_time);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        //输出
        holder.text.setText(messageBeanList.get(position).getText());
        holder.time.setText(messageBeanList.get(position).getDate());

        return convertView;
    }

    //缓冲池
    public final class ViewHolder{
        public TextView text;
        public TextView time;
    }

    /* @Override
    public int getItemViewType(int position) {
        MessageBean bean = messageBeanList.get(position);
        return bean.getType();
    }*/

    //使每个item不能点击
    /*@Override
    public boolean isEnabled(int position){
        return false;
    }*/


}
