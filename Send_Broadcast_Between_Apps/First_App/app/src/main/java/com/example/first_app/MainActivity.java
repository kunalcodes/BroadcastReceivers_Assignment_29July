package com.example.first_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSend = findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.example.kunal");
        intent.putExtra("Message", "Hello from App One");
        sendBroadcast(intent);
    }
}