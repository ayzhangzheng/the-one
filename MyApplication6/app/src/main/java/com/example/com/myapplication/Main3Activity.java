package com.example.com.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.com.myapplication.Database;

public class Main3Activity extends ActionBarActivity {
    Database database = new Database(this,"dict",null,1);
    private int id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void insert(View v) {
        EditText enText = (EditText) findViewById(R.id.enText);
        EditText chText = (EditText) findViewById(R.id.chText);
        ContentValues contentValues = new ContentValues();
        contentValues.put("english", enText.getText().toString());
        contentValues.put("chinese", chText.getText().toString());
        String showToast;
        if (id != -1) {
            database.getWritableDatabase().update("dict", contentValues, "id = ?", new String[]{id + ""});
            showToast = "update successful！";
        } else {
            database.getWritableDatabase().insert("dict", null, contentValues);
            showToast = "insert successful";
        }
        enText.setText("");
        chText.setText("");
        Toast.makeText(this, showToast, Toast.LENGTH_SHORT).show();
    }

    public void search(View v) {
        Cursor cursor = searchWord();
        String result = "";
        if (cursor.getColumnCount()==0) {
            result = "查无此词";
        }
        while (cursor.moveToNext()) {
            result += cursor.getInt(0) + ";" + cursor.getString(1) + ";" + cursor.getString(2);
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    public void delete(View v) {
        EditText searchText = (EditText) findViewById(R.id.edit_search);
        database.getWritableDatabase().delete("dict", "english like ? or chinese like ?",
                new String[]{"%" + searchText.getText().toString() + "%", "%" + searchText.getText().toString() + "%"});
        Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
    }

    public void update(View v){
        Cursor cursor = searchWord();
        cursor.moveToFirst();
        ((EditText) findViewById(R.id.enText)).setText(cursor.getString(1));
        ((EditText) findViewById(R.id.chText)).setText(cursor.getString(2));
        id = cursor.getInt(0);
    }

    public Cursor searchWord() {
        String searchText = ((EditText) findViewById(R.id.edit_search)).getText().toString();
        return database.getReadableDatabase().query("dict", null,
                "english like ? or chinese like ?",
                new String[]{"%" + searchText + "%", "%" + searchText + "%"},
                null, null, null);
    }
}
