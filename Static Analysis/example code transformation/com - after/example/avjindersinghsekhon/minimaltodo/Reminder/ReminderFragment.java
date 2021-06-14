package com.example.avjindersinghsekhon.minimaltodo.Reminder;
import com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem;
import java.util.ArrayList;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import static android.content.Context.MODE_PRIVATE;
import android.widget.TextView;
import java.util.UUID;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import org.json.JSONException;
import java.util.Calendar;
import android.os.Bundle;
import java.io.IOException;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.MenuItem;
import com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService;
import android.view.View;
import java.util.Date;
import fr.ganfra.materialspinner.MaterialSpinner;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
public class ReminderFragment extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment {
    private android.widget.TextView mtoDoTextTextView;

    private android.widget.Button mRemoveToDoButton;

    private fr.ganfra.materialspinner.MaterialSpinner mSnoozeSpinner;

    private java.lang.String[] snoozeOptionsArray;

    private com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData storeRetrieveData;

    private java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> mToDoItems;

    private com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem mItem;

    public static final java.lang.String EXIT = "com.avjindersekhon.exit";

    private android.widget.TextView mSnoozeTextView;

    java.lang.String theme;

    com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    public void onViewCreated(android.view.View view, @android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
        app.send(this);
        theme = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            getActivity().setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_LightTheme);
        } else {
            getActivity().setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_DarkTheme);
        }
        storeRetrieveData = new com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData(getContext(), com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.FILENAME);
        mToDoItems = com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.getLocallyStoredData(storeRetrieveData);
        ((android.support.v7.app.AppCompatActivity) (getActivity())).setSupportActionBar(((android.support.v7.widget.Toolbar) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar))));
        android.content.Intent i = getActivity().getIntent();
        java.util.UUID id = ((java.util.UUID) (i.getSerializableExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID)));
        mItem = null;
        for (com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem toDoItem : mToDoItems) {
            if (toDoItem.getIdentifier().equals(id)) {
                mItem = toDoItem;
                break;
            }
        }
        snoozeOptionsArray = getResources().getStringArray(com.example.avjindersinghsekhon.minimaltodo.R.array.snooze_options);
        mRemoveToDoButton = ((android.widget.Button) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoReminderRemoveButton)));
        mtoDoTextTextView = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoReminderTextViewBody)));
        mSnoozeTextView = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.reminderViewSnoozeTextView)));
        mSnoozeSpinner = ((fr.ganfra.materialspinner.MaterialSpinner) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.todoReminderSnoozeSpinner)));
        // mtoDoTextTextView.setBackgroundColor(item.getTodoColor());
        mtoDoTextTextView.setText(mItem.getToDoText());
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            mSnoozeTextView.setTextColor(getResources().getColor(com.example.avjindersinghsekhon.minimaltodo.R.color.secondary_text));
        } else {
            mSnoozeTextView.setTextColor(android.graphics.Color.WHITE);
            mSnoozeTextView.setCompoundDrawablesWithIntrinsicBounds(com.example.avjindersinghsekhon.minimaltodo.R.drawable.ic_snooze_white_24dp, 0, 0, 0);
        }
        mRemoveToDoButton.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                app.send(this, "Action", "Todo Removed from Reminder Activity");
                mToDoItems.remove(mItem);
                changeOccurred();
                saveData();
                closeApp();
                // finish();
            }

        });
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, snoozeOptionsArray);
        android.widget.ArrayAdapter<java.lang.String> adapter = new android.widget.ArrayAdapter<>(getContext(), com.example.avjindersinghsekhon.minimaltodo.R.layout.spinner_text_view, snoozeOptionsArray);
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(com.example.avjindersinghsekhon.minimaltodo.R.layout.spinner_dropdown_item);
        mSnoozeSpinner.setAdapter(adapter);
        // mSnoozeSpinner.setSelection(0);
    }


    @java.lang.Override
    protected int layoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.fragment_reminder;
    }


    private void closeApp() {
        android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity.class);
        i.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // i.putExtra(EXIT, true);
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment.EXIT, true);
        editor.apply();
        startActivity(i);
    }


    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getActivity().getMenuInflater().inflate(com.example.avjindersinghsekhon.minimaltodo.R.menu.menu_reminder, menu);
        return true;
    }


    private void changeOccurred() {
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.CHANGE_OCCURED, true);
        // editor.commit();
        editor.apply();
    }


    private java.util.Date addTimeToDate(int mins) {
        app.send(this, "Action", "Snoozed", ("For " + mins) + " minutes");
        java.util.Date date = new java.util.Date();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(java.util.Calendar.MINUTE, mins);
        return calendar.getTime();
    }


    private int valueFromSpinner() {
        switch (mSnoozeSpinner.getSelectedItemPosition()) {
            case 0 :
                return 10;
            case 1 :
                return 30;
            case 2 :
                return 60;
            default :
                return 0;
        }
    }


    @java.lang.Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case com.example.avjindersinghsekhon.minimaltodo.R.id.toDoReminderDoneMenuItem :
                java.util.Date date = addTimeToDate(valueFromSpinner());
                mItem.setToDoDate(date);
                mItem.setHasReminder(true);
                android.util.Log.d("OskarSchindler", "Date Changed to: " + date);
                changeOccurred();
                saveData();
                closeApp();
                // foo
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    private void saveData() {
        try {
            storeRetrieveData.saveToFile(mToDoItems);
        } catch (org.json.JSONException | java.io.IOException e) {
            e.printStackTrace();
        }
    }


    public static com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment newInstance() {
        return new com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment();
    }

}