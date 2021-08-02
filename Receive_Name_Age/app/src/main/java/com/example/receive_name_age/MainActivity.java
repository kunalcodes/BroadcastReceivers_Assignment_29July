package com.example.receive_name_age;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvName;
    private TextView mTvAge;
    private Button mBtnSend;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        registerLocalReceiver();
        initViews();

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.receive_name_age");
                intent.putExtra("Name", "Name: Abhishek");
                intent.putExtra("Age", "Age: 10");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.receive_name_age");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvName);
        mTvAge = findViewById(R.id.tvAge);
        mBtnSend = findViewById(R.id.btnSend);
    }

    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null){
                String Name = intent.getStringExtra("Name");
                String Age = intent.getStringExtra("Age");
                mTvName.setText(Name);
                mTvAge.setText(Age);
            }
        }
    }

}