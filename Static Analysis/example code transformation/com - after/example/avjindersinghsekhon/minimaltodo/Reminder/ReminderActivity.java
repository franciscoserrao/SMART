package com.example.avjindersinghsekhon.minimaltodo.Reminder;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.support.annotation.NonNull;
import android.os.Bundle;
public class ReminderActivity extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity {
    @java.lang.Override
    protected void onCreate(final android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @java.lang.Override
    protected int contentViewLayoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.reminder_layout;
    }


    @android.support.annotation.NonNull
    @java.lang.Override
    protected com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment createInitialFragment() {
        return com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment.newInstance();
    }

}