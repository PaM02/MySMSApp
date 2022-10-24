package com.example.mysmsapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.view.View;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.textView);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
    }

    @SuppressLint("SetTextI18n")
    public void Read_SMS(View view){
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null,null,null);

        cursor.moveToFirst();

        myTextView.setText(cursor.getString(2)+" "+cursor.getString(12));

    }
}