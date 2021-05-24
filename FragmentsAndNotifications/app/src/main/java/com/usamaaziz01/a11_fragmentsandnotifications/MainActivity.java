package com.usamaaziz01.a11_fragmentsandnotifications;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Button chats, status, settings;
    FrameLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chats = findViewById(R.id.btnChats);
        status = findViewById(R.id.btnStatus);
        settings = findViewById(R.id.btnSettings);
        layout = findViewById(R.id.frameLayout);
        
        chats.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Chat chatFragment = new Chat();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, chatFragment);
                transaction.commit();
                showNotification("Chats", "Someone opened chats tab.");
            };
        });

        status.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Status chatFragment = new Status();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, chatFragment);
                transaction.commit();
            };
        });

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Settings chatFragment = new Settings();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, chatFragment);
                transaction.commit();
            };
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showNotification(String title, String message) {
        NotificationChannel channel = new NotificationChannel("1", "1", NotificationManager.IMPORTANCE_HIGH);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle(title)
                .setContentText(message)
                .setChannelId("1")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .build();
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, notification);
    }
}