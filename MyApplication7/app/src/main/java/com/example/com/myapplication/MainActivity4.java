package com.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity4 extends AppCompatActivity {
    private EditText et_info;
    private Button btn_read;
    private Button btn_save;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        et_info = (EditText) findViewById(R.id.editText);
        btn_read = (Button) findViewById(R.id.button1);
        btn_save = (Button) findViewById(R.id.button2);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                String saveInfo = et_info.getText().toString().trim();
                FileOutputStream fos;
                try {
                    int model = ((CheckBox) findViewById(R.id.checkBox)).isChecked() ? MODE_APPEND : MODE_PRIVATE;
                    fos = openFileOutput("data.txt", model);
                    fos.write(saveInfo.getBytes());
                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity4.this, "数据保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                String content = "";
                try {
                    FileInputStream fis = openFileInput("data.txt");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    content = new String(buffer);
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity4.this, "保存的数据是" + content, Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
    /* }*/
}

