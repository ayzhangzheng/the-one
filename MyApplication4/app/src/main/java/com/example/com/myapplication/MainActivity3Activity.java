package com.example.com.myapplication;

import android.content.ContentValues;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.com.myapplication.Database;

public class MainActivity3Activity extends ActionBarActivity {
    Database database = new Database(this,"dict",null,1);
    Integer id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
    }
    public void insert(View v){
        EditText enText=(EditText)findViewById(R.id.enText);
        EditText chText=(EditText)findViewById(R.id.chText);
        ContentValues contentValues=new ContentValues();
        contentValues.put("en",enText.getText().toString());
        contentValues.put("ch", chText.getText().toString());
        String showToast=null;
        if(id != -1){
            database.getWritableDatabase().insert("dict", null, contentValues);
            showToast="插入成功";

        }else {

        }
        Toast.makeText(this,showToast,Toast.LENGTH_SHORT);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
