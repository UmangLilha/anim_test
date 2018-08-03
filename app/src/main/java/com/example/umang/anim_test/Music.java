package com.example.umang.anim_test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }
  public int onStartCommand(Intent intent, int flags, int startId){
      String ringtone_state=intent.getExtras().getString("extra");
      if(ringtone_state.equals("start"))
      {
          mediaPlayer=MediaPlayer.create(this,R.raw.nightcore);
          mediaPlayer.start();

      }
      else
      {
          mediaPlayer.stop();
          mediaPlayer.reset();
      }
return START_NOT_STICKY;

  }
}
