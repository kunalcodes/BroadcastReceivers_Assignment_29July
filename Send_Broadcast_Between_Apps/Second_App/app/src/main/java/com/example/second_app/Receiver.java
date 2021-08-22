package com.example.second_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent activityIntent = new Intent(context, BroadcastReceiveActivity.class);
        activityIntent.putExtra("key", intent.getStringExtra("Message"));
        context.startActivity(activityIntent);
    }
}