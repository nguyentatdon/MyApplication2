package com.example.hanglake.laimotlannua;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by HangLake on 1/5/2018.
 */

public class thucday  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Toi tron", "xin chao");
        String chuoi_string=intent.getExtras().getString("extra");
        Log.e("truyen key",chuoi_string);
        Intent myIntent = new Intent(context, Nhac.class);
        myIntent.putExtra("extra",chuoi_string);
        context.startService(myIntent);
    }
}
