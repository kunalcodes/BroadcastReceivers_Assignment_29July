package com.example.second_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 101);
        registerLocalReceiver();
        setContentView(R.layout.activity_main);
    }



    private void registerLocalReceiver() {
        receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter("com.example.kunal");
        registerReceiver(receiver, intentFilter);
    }
}