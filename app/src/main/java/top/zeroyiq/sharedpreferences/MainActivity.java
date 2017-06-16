package top.zeroyiq.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.btn_save_data)
    void Save() {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("name", "张三");
        editor.putInt("age", 21);
        editor.putBoolean("married", false);
        editor.apply();
        Toast.makeText(this, "Save Data success", Toast.LENGTH_SHORT).show();
    }
    @BindView(R.id.tv_output)
    TextView textViewOutPut;
    @OnClick(R.id.btn_restore_data)
    void Read(){
        SharedPreferences pre = getSharedPreferences("data",MODE_PRIVATE);
        String name = pre.getString("name","");
        int age = pre.getInt("age",0);
        Boolean married = pre.getBoolean("married",false);
        String result="姓名："+name+"\n年龄："+age+"\n是否结婚："+married;
        textViewOutPut.setText(result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
