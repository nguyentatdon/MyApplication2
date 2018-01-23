package com.example.hanglake.laimotlannua;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.icu.util.Calendar.HOUR_OF_DAY;

public class MainActivity extends AppCompatActivity {
Button btnHengio,btndunglai;
    TimePicker timePicker;
    TextView txthienthi;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHengio= (Button) findViewById(R.id.btnHengio);
        btndunglai= (Button) findViewById(R.id.btndunglai);
        timePicker= (TimePicker) findViewById(R.id.timePicker);
        txthienthi= (TextView) findViewById(R.id.textView);
        calendar= Calendar.getInstance();
        alarmManager= (AlarmManager)getSystemService(ALARM_SERVICE);

        final Intent intent= new Intent(MainActivity.this,thucday.class);
        btnHengio.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();
                String string_gio = String.valueOf(gio);
                String string_phut = String.valueOf(phut);
                if(gio>12){
                    string_gio = String.valueOf(gio-12);

                }
                if(phut<10){
                    string_phut ="0" + String.valueOf(phut);
                }
                intent.putExtra("extra","on");
                pendingIntent=PendingIntent.getBroadcast(
                        MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT
                );
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                txthienthi.setText("Giờ bạn đặt là :" + string_gio + ":" + string_phut);
            }
        });
        btndunglai.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                txthienthi.setText("Stop");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra","off");
                sendBroadcast(intent);
            }
        });
    }
}
