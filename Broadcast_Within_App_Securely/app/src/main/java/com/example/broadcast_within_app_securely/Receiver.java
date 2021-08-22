package com.example.broadcast_within_app_securely;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent activityIntent = new Intent(context, SecondActivity.class);
        activityIntent.putExtra("key", intent.getStringExtra("Message"));
        context.startActivity(activityIntent);
    }
}
