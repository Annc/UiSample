package com.example.dou.uisample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Notification.Builder;
import android.widget.RemoteViews;

/**
 * Created by Dou on 2016/4/21.
 */
public class NotificationActivity extends Activity {
    private NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        //设置NotificationManager实例
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);



        Button commonButton = (Button)findViewById(R.id.common);
        commonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //建立Notification实例
                long[] dong = {0,100,200,300};
                RemoteViews reView = new RemoteViews(getPackageName(),R.layout.user_item);
                //Notification notification = new Notification(R.drawable.tou,"You have an email",System.currentTimeMillis());
                PendingIntent contentIndent = PendingIntent.getActivity(NotificationActivity.this, 0, new Intent(NotificationActivity.this, NotificationActivity.class), 0);
                Notification notification = new Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.tou)
                        .setContentText("You have an email")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(contentIndent)
                        .setAutoCancel(true)
                        .setContentTitle("This is ContentTitle")
                        .setDefaults(Notification.DEFAULT_SOUND)
                        .setVibrate(dong)
                        .setContent(reView)
                        .build();
                //触发提醒
                mNotificationManager.notify(1,notification);
            }
        });
    }

    @Override
    protected void onStop() {
        //退出程序清掉通知
        mNotificationManager.cancel(1);
        super.onStop();

    }
}
