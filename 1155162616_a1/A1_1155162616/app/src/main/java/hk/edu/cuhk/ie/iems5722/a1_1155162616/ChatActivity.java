package hk.edu.cuhk.ie.iems5722.a1_1155162616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private EditText getMessageField;
    private Button sendButton;
    private ListView messageListView;
    //数据
    private List<MessageBean> messageBeanList = new ArrayList<MessageBean>();
    //适配器
    ChatAdapter chatAdapter = new ChatAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //引入布局
        setContentView(R.layout.activity_chat);

        //获取按钮
        sendButton = findViewById(R.id.sendMessage);

        //获取ListView对象
        messageListView = (ListView)findViewById(R.id.messageList);
        //准备数据源 准备适配器
        //将适配器关联ListView
        messageListView.setAdapter(new ChatAdapter(this,messageBeanList));

    }


    public void backMainActivity(View view) {

        startActivity(new Intent(this, MainActivity.class));
    }

    public void sendMessage(View view) {
        //获取文本框
        getMessageField = findViewById(R.id.getMessage);
        String text = getMessageField.getText().toString();
        //输入内容判空
        if (text.length()==0)
        {
            Toast.makeText(this, "Text cannot be empty!", Toast.LENGTH_SHORT).show();
        }
        else{
            MessageBean messageBean = new MessageBean();
            messageBean.setText(text);
            //在此处设置时间
            messageBean.setDate(getCurrentTime());

            messageBeanList.add(messageBean);
            messageListView.setAdapter(new ChatAdapter(this,messageBeanList));
            messageListView.setSelection(messageBeanList.size());
            //清空文本框
            getMessageField.setText("");
        }
    }

    public String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date curDate = new Date(System.currentTimeMillis());
        String curTime = formatter.format(curDate);
        return curTime;
    }
}
