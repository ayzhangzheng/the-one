package com.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,MainActivity2Activity.class);
                Bundle bundle=new Bundle();
                EditText userName=(EditText) findViewById(R.id.editText);
                EditText userPass=(EditText) findViewById(R.id.editText2);
                RadioGroup rg=(RadioGroup)findViewById(R.id.rg1);
                RadioButton userSex = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
                CheckBox userLike1=(CheckBox)findViewById(R.id.checkBox);
                CheckBox userLike2=(CheckBox)findViewById(R.id.checkBox2);
                CheckBox userLike3=(CheckBox)findViewById(R.id.checkBox3);
                List<CheckBox> checkBoxList = new ArrayList<>();
                checkBoxList.add(userLike1);
                checkBoxList.add(userLike2);
                checkBoxList.add(userLike3);
                StringBuffer sb = new StringBuffer();
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()) {
                        sb.append(checkbox.getText().toString() + "  ");
                    }
                }
                bundle.putString("username",userName.getText().toString());
                bundle.putString("userpass",userPass.getText().toString());
                bundle.putString("usersex",userSex.getText().toString());
                bundle.putString("userlike",sb.toString());

                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
