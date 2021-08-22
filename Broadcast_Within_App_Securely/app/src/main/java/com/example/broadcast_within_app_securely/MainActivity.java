package com.example.broadcast_within_app_securely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSend;
    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 101);
        registerLocalReceiver();
        setContentView(R.layout.activity_main);
        mBtnSend = findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(this);
    }



    private void registerLocalReceiver() {
        receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter("com.example.kunal");
        registerReceiver(receiver, intentFilter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent("com.example.kunal");
        intent.putExtra("Message", "Hello from Activity one");
        sendBroadcast(intent, Manifest.permission.CAMERA);
    }
}