package com.example.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Button button1=(Button) findViewById(R.id.button);
        TextView textView=(TextView)findViewById(R.id.showUser);
        TextView textView2=(TextView)findViewById(R.id.showPass);
        TextView textView3=(TextView)findViewById(R.id.showSex);
        TextView textView4=(TextView)findViewById(R.id.showLike);

        Intent intent=getIntent();
        textView.setText(intent.getExtras().getString("username"));
        textView2.setText(intent.getExtras().getString("userpass"));
        textView3.setText(intent.getExtras().getString("usersex"));
        textView4.setText(intent.getExtras().getString("userlike"));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}

