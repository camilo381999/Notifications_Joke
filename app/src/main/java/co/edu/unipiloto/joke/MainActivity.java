package co.edu.unipiloto.joke;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
    Button btNotification;
    private NotificationCompat notificationCompat;
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNotification=findViewById(R.id.bt_notification);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,DelayedMessageService.class);
                intent.putExtra(DelayedMessageService.EXTRA_MESSAGE,
                        getResources().getString(R.string.response));
                startService(intent);
            }
        });
    }
/*
    public void onClick(View view){
        Intent intent =new Intent(this,DelayedMessageService.class);
        intent.putExtra(DelayedMessageService.EXTRA_MESSAGE,
                getResources().getString(R.string.response));
        startService(intent);

        String message = "timing";
        NotificationCompat.Builder builder= new NotificationCompat.Builder(
                MainActivity.this)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle("What is the secret od comedy?")
                .setContentText(message)
                .setAutoCancel(true);
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{0,1000})

        Intent intent =new Intent(MainActivity.this,
                NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("message",message);

        PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,
                0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(
                Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());
    }*/
}