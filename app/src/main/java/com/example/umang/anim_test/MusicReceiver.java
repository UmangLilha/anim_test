package com.example.umang.anim_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MusicReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Receiver Class","Yayyyy!!");
        String intent_string= intent.getExtras().getString("extra");
        Log.e("Receiver message",intent_string);
        Intent service_intent=new Intent(context,Music.class);
        service_intent.putExtra("extra",intent_string);
        context.startService(service_intent);

    }
}
