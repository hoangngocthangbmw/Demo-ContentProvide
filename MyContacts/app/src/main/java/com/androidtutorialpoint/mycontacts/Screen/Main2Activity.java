package com.androidtutorialpoint.mycontacts.Screen;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidtutorialpoint.mycontacts.R;

public class Main2Activity extends AppCompatActivity {
    private TextView txtTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        ContentResolver contentResolver=getContentResolver();
        Uri uri=Uri.parse("content://com.androidtutorialpoint.mycontacts/contacts");
        Cursor cursor= contentResolver.query(uri,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            txtTest.append(cursor.getString(1)+"\n"+cursor.getString(2)+"\n");
            cursor.moveToNext();
        }
    }

    private void initView() {
        txtTest=(TextView)findViewById(R.id.txtTest);
    }
}
