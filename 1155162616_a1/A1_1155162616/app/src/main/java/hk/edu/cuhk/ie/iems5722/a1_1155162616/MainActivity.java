package hk.edu.cuhk.ie.iems5722.a1_1155162616;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

//默认的activity
public class MainActivity extends AppCompatActivity {

    private Button defaultbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置按钮透明度
        defaultbutton = findViewById(R.id.defaultButton);
        defaultbutton.getBackground().setAlpha(50);
    }

    //创建监听事件
    public void startChatActivity(android.view.View view){
        startActivity(new Intent(this,ChatActivity.class));
    }
}
