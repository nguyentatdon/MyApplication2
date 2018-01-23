package com.example.hanglake.laimotlannua;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by HangLake on 1/5/2018.
 */

public class Nhac extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Toi la nhac chuong","xin chao ban -------------------------");
        String nhankey = intent.getExtras().getString("extra");
        Log.e("Nhac nhan key",nhankey);
        if(nhankey.equals("on"))
        {
            id=1;
        }
        else if (nhankey.equals("off"))
        {
            id=0;
        }
       if(id==1)
       {
           mediaPlayer=MediaPlayer.create(this,R.raw.rain);
           mediaPlayer.start();
           id=0;
       }
       else if (id==0)
       {
           mediaPlayer.stop();
           mediaPlayer.reset();
       }
        mediaPlayer=MediaPlayer.create(this,R.raw.rain);
        mediaPlayer.start();

        return START_NOT_STICKY;
    }
}
