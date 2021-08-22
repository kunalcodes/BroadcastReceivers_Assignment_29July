package com.example.second_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BroadcastReceiveActivity extends AppCompatActivity {

    private TextView mTvMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receive);
        mTvMessage = findViewById(R.id.tvMessage);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mTvMessage.setText(getIntent().getStringExtra("key"));
        }


    }

}