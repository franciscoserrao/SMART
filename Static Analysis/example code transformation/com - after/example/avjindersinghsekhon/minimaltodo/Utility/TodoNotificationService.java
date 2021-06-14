package com.example.avjindersinghsekhon.minimaltodo.Utility;
import android.app.IntentService;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.util.Log;
import android.app.NotificationManager;
import com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderActivity;
import android.app.Notification;
import android.content.Intent;
import java.util.UUID;
import android.app.PendingIntent;
import android.content.Context;
public class TodoNotificationService extends android.app.IntentService {
    public static final java.lang.String TODOTEXT = "com.avjindersekhon.todonotificationservicetext";

    public static final java.lang.String TODOUUID = "com.avjindersekhon.todonotificationserviceuuid";

    private java.lang.String mTodoText;

    private java.util.UUID mTodoUUID;

    private android.content.Context mContext;

    public TodoNotificationService() {
        super("TodoNotificationService");
    }


    @java.lang.Override
    protected void onHandleIntent(android.content.Intent intent) {
        mTodoText = intent.getStringExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOTEXT);
        mTodoUUID = ((java.util.UUID) (intent.getSerializableExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID)));
        android.util.Log.d("OskarSchindler", "onHandleIntent called");
        android.app.NotificationManager manager = ((android.app.NotificationManager) (getSystemService(android.content.Context.NOTIFICATION_SERVICE)));
        android.content.Intent i = new android.content.Intent(this, com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderActivity.class);
        i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID, mTodoUUID);
        android.content.Intent deleteIntent = new android.content.Intent(this, com.example.avjindersinghsekhon.minimaltodo.Utility.DeleteNotificationService.class);
        deleteIntent.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID, mTodoUUID);
        android.app.Notification notification = new android.app.Notification.Builder(this).setContentTitle(mTodoText).setSmallIcon(com.example.avjindersinghsekhon.minimaltodo.R.drawable.ic_done_white_24dp).setAutoCancel(true).setDefaults(android.app.Notification.DEFAULT_SOUND).setDeleteIntent(android.app.PendingIntent.getService(this, mTodoUUID.hashCode(), deleteIntent, android.app.PendingIntent.FLAG_UPDATE_CURRENT)).setContentIntent(android.app.PendingIntent.getActivity(this, mTodoUUID.hashCode(), i, android.app.PendingIntent.FLAG_UPDATE_CURRENT)).build();
        manager.notify(100, notification);
        // Uri defaultRingone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        // MediaPlayer mp = new MediaPlayer();
        // try{
        // mp.setDataSource(this, defaultRingone);
        // mp.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
        // mp.prepare();
        // mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        // @Override
        // public void onCompletion(MediaPlayer mp) {
        // mp.release();
        // }
        // });
        // mp.start();
        // 
        // }
        // catch (Exception e){
        // e.printStackTrace();
        // }
    }

}