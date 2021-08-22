package com.example.broadcast_within_app_securely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTvMessage = findViewById(R.id.tvMessage);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mTvMessage.setText(getIntent().getStringExtra("key"));
        }


    }


}