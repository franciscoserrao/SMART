package com.example.avjindersinghsekhon.minimaltodo.AddToDo;
import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.app.Activity.RESULT_CANCELED;
import com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem;
import android.text.TextWatcher;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainActivity;
import android.view.inputmethod.InputMethodManager;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import android.widget.ImageButton;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import static android.content.Context.MODE_PRIVATE;
import android.widget.TextView;
import android.widget.Toast;
import static android.app.Activity.RESULT_OK;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.util.Log;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.util.Calendar;
import android.os.Bundle;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.MenuItem;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import android.view.View;
import android.content.ClipboardManager;
import android.widget.EditText;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.text.format.DateFormat;
import android.support.v4.app.NavUtils;
import android.graphics.PorterDuff;
import android.animation.Animator;
import android.content.ClipData;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.support.v7.widget.SwitchCompat;
import android.content.Context;
public class AddToDoFragment extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener , com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener {
    private static final java.lang.String TAG = "AddToDoFragment";

    private java.util.Date mLastEdited;

    private android.widget.EditText mToDoTextBodyEditText;

    private android.widget.EditText mToDoTextBodyDescription;

    private android.support.v7.widget.SwitchCompat mToDoDateSwitch;

    // private TextView mLastSeenTextView;
    private android.widget.LinearLayout mUserDateSpinnerContainingLinearLayout;

    private android.widget.TextView mReminderTextView;

    private java.lang.String CombinationText;

    private android.widget.EditText mDateEditText;

    private android.widget.EditText mTimeEditText;

    private java.lang.String[] mDefaultTimeOptions12H;

    private java.lang.String[] mDefaultTimeOptions24H;

    private android.widget.Button mChooseDateButton;

    private android.widget.Button mChooseTimeButton;

    private android.widget.Button mCopyClipboard;

    private com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem mUserToDoItem;

    private android.support.design.widget.FloatingActionButton mToDoSendFloatingActionButton;

    public static final java.lang.String DATE_FORMAT = "MMM d, yyyy";

    public static final java.lang.String DATE_FORMAT_MONTH_DAY = "MMM d";

    public static final java.lang.String DATE_FORMAT_TIME = "H:m";

    private java.lang.String mUserEnteredText;

    private java.lang.String mUserEnteredDescription;

    private boolean mUserHasReminder;

    private android.support.v7.widget.Toolbar mToolbar;

    private java.util.Date mUserReminderDate;

    private int mUserColor;

    private boolean setDateButtonClickedOnce = false;

    private boolean setTimeButtonClickedOnce = false;

    private android.widget.LinearLayout mContainerLayout;

    private java.lang.String theme;

    com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    public void onViewCreated(android.view.View view, @android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
        // setContentView(R.layout.new_to_do_layout);
        // Need references to these to change them during light/dark mode
        android.widget.ImageButton reminderIconImageButton;
        android.widget.TextView reminderRemindMeTextView;
        theme = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            getActivity().setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_LightTheme);
            android.util.Log.d("OskarSchindler", "Light Theme");
        } else {
            getActivity().setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_DarkTheme);
        }
        // Show an X in place of <-
        final android.graphics.drawable.Drawable cross = getResources().getDrawable(com.example.avjindersinghsekhon.minimaltodo.R.drawable.ic_clear_white_24dp);
        if (cross != null) {
            cross.setColorFilter(getResources().getColor(com.example.avjindersinghsekhon.minimaltodo.R.color.icons), android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        mToolbar = ((android.support.v7.widget.Toolbar) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar)));
        ((android.support.v7.app.AppCompatActivity) (getActivity())).setSupportActionBar(mToolbar);
        if (((android.support.v7.app.AppCompatActivity) (getActivity())).getSupportActionBar() != null) {
            ((android.support.v7.app.AppCompatActivity) (getActivity())).getSupportActionBar().setElevation(0);
            ((android.support.v7.app.AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayShowTitleEnabled(false);
            ((android.support.v7.app.AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((android.support.v7.app.AppCompatActivity) (getActivity())).getSupportActionBar().setHomeAsUpIndicator(cross);
        }
        mUserToDoItem = ((com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem) (getActivity().getIntent().getSerializableExtra(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.TODOITEM)));
        mUserEnteredText = mUserToDoItem.getToDoText();
        mUserEnteredDescription = mUserToDoItem.getmToDoDescription();
        mUserHasReminder = mUserToDoItem.hasReminder();
        mUserReminderDate = mUserToDoItem.getToDoDate();
        mUserColor = mUserToDoItem.getTodoColor();
        // if(mUserToDoItem.getLastEdited()==null) {
        // mLastEdited = new Date();
        // }
        // else{
        // mLastEdited = mUserToDoItem.getLastEdited();
        // }
        reminderIconImageButton = ((android.widget.ImageButton) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.userToDoReminderIconImageButton)));
        reminderRemindMeTextView = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.userToDoRemindMeTextView)));
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DARKTHEME)) {
            reminderIconImageButton.setImageDrawable(getResources().getDrawable(com.example.avjindersinghsekhon.minimaltodo.R.drawable.ic_alarm_add_white_24dp));
            reminderRemindMeTextView.setTextColor(android.graphics.Color.WHITE);
        }
        // Button for Copy to Clipboard
        mCopyClipboard = ((android.widget.Button) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.copyclipboard)));
        mContainerLayout = ((android.widget.LinearLayout) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.todoReminderAndDateContainerLayout)));
        mUserDateSpinnerContainingLinearLayout = ((android.widget.LinearLayout) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoEnterDateLinearLayout)));
        mToDoTextBodyEditText = ((android.widget.EditText) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.userToDoEditText)));
        mToDoTextBodyDescription = ((android.widget.EditText) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.userToDoDescription)));
        mToDoDateSwitch = ((android.support.v7.widget.SwitchCompat) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoHasDateSwitchCompat)));
        // mLastSeenTextView = (TextView)findViewById(R.id.toDoLastEditedTextView);
        mToDoSendFloatingActionButton = ((android.support.design.widget.FloatingActionButton) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.makeToDoFloatingActionButton)));
        mReminderTextView = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.newToDoDateTimeReminderTextView)));
        // OnClickListener for CopyClipboard Button
        mCopyClipboard.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View view) {
                java.lang.String toDoTextContainer = mToDoTextBodyEditText.getText().toString();
                java.lang.String toDoTextBodyDescriptionContainer = mToDoTextBodyDescription.getText().toString();
                android.content.ClipboardManager clipboard = ((android.content.ClipboardManager) (getActivity().getSystemService(android.content.Context.CLIPBOARD_SERVICE)));
                CombinationText = ((("Title : " + toDoTextContainer) + "\nDescription : ") + toDoTextBodyDescriptionContainer) + "\n -Copied From MinimalToDo";
                android.content.ClipData clip = android.content.ClipData.newPlainText("text", CombinationText);
                clipboard.setPrimaryClip(clip);
                android.widget.Toast.makeText(getContext(), "Copied To Clipboard!", android.widget.Toast.LENGTH_SHORT).show();
            }

        });
        mContainerLayout.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                hideKeyboard(mToDoTextBodyEditText);
                hideKeyboard(mToDoTextBodyDescription);
            }

        });
        if (mUserHasReminder && (mUserReminderDate != null)) {
            // mUserDateSpinnerContainingLinearLayout.setVisibility(View.VISIBLE);
            setReminderTextView();
            setEnterDateLayoutVisibleWithAnimations(true);
        }
        if (mUserReminderDate == null) {
            mToDoDateSwitch.setChecked(false);
            mReminderTextView.setVisibility(android.view.View.INVISIBLE);
        }
        // TextInputLayout til = (TextInputLayout)findViewById(R.id.toDoCustomTextInput);
        // til.requestFocus();
        mToDoTextBodyEditText.requestFocus();
        mToDoTextBodyEditText.setText(mUserEnteredText);
        mToDoTextBodyDescription.setText(mUserEnteredDescription);
        android.view.inputmethod.InputMethodManager imm = ((android.view.inputmethod.InputMethodManager) (this.getActivity().getSystemService(android.content.Context.INPUT_METHOD_SERVICE)));
        // imm.showSoftInput(mToDoTextBodyEditText, InputMethodManager.SHOW_IMPLICIT);
        imm.toggleSoftInput(android.view.inputmethod.InputMethodManager.SHOW_FORCED, android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY);
        mToDoTextBodyEditText.setSelection(mToDoTextBodyEditText.length());
        mToDoTextBodyEditText.addTextChangedListener(new android.text.TextWatcher() {
            @java.lang.Override
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {
            }


            @java.lang.Override
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {
                mUserEnteredText = s.toString();
            }


            @java.lang.Override
            public void afterTextChanged(android.text.Editable s) {
            }

        });
        mToDoTextBodyDescription.setText(mUserEnteredDescription);
        mToDoTextBodyDescription.setSelection(mToDoTextBodyDescription.length());
        mToDoTextBodyDescription.addTextChangedListener(new android.text.TextWatcher() {
            @java.lang.Override
            public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {
            }


            @java.lang.Override
            public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {
                mUserEnteredDescription = s.toString();
            }


            @java.lang.Override
            public void afterTextChanged(android.text.Editable s) {
            }

        });
        // String lastSeen = formatDate(DATE_FORMAT, mLastEdited);
        // mLastSeenTextView.setText(String.format(getResources().getString(R.string.last_edited), lastSeen));
        setEnterDateLayoutVisible(mToDoDateSwitch.isChecked());
        mToDoDateSwitch.setChecked(mUserHasReminder && (mUserReminderDate != null));
        mToDoDateSwitch.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
            @java.lang.Override
            public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    app.send(this, "Action", "Reminder Set");
                } else {
                    app.send(this, "Action", "Reminder Removed");
                }
                if (!isChecked) {
                    mUserReminderDate = null;
                }
                mUserHasReminder = isChecked;
                setDateAndTimeEditText();
                setEnterDateLayoutVisibleWithAnimations(isChecked);
                hideKeyboard(mToDoTextBodyEditText);
                hideKeyboard(mToDoTextBodyDescription);
            }

        });
        mToDoSendFloatingActionButton.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                if (mToDoTextBodyEditText.length() <= 0) {
                    mToDoTextBodyEditText.setError(getString(com.example.avjindersinghsekhon.minimaltodo.R.string.todo_error));
                } else if ((mUserReminderDate != null) && mUserReminderDate.before(new java.util.Date())) {
                    app.send(this, "Action", "Date in the Past");
                    makeResult(android.app.Activity.RESULT_CANCELED);
                } else {
                    app.send(this, "Action", "Make Todo");
                    makeResult(android.app.Activity.RESULT_OK);
                    getActivity().finish();
                }
                hideKeyboard(mToDoTextBodyEditText);
                hideKeyboard(mToDoTextBodyDescription);
            }

        });
        mDateEditText = ((android.widget.EditText) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.newTodoDateEditText)));
        mTimeEditText = ((android.widget.EditText) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.newTodoTimeEditText)));
        mDateEditText.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                java.util.Date date;
                hideKeyboard(mToDoTextBodyEditText);
                if (mUserToDoItem.getToDoDate() != null) {
                    // date = mUserToDoItem.getToDoDate();
                    date = mUserReminderDate;
                } else {
                    date = new java.util.Date();
                }
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(date);
                int year = calendar.get(java.util.Calendar.YEAR);
                int month = calendar.get(java.util.Calendar.MONTH);
                int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.this, year, month, day);
                if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DARKTHEME)) {
                    datePickerDialog.setThemeDark(true);
                }
                datePickerDialog.show(getActivity().getFragmentManager(), "DateFragment");
            }

        });
        mTimeEditText.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                java.util.Date date;
                hideKeyboard(mToDoTextBodyEditText);
                if (mUserToDoItem.getToDoDate() != null) {
                    // date = mUserToDoItem.getToDoDate();
                    date = mUserReminderDate;
                } else {
                    date = new java.util.Date();
                }
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(date);
                int hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
                int minute = calendar.get(java.util.Calendar.MINUTE);
                com.wdullaer.materialdatetimepicker.time.TimePickerDialog timePickerDialog = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.this, hour, minute, android.text.format.DateFormat.is24HourFormat(getContext()));
                if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DARKTHEME)) {
                    timePickerDialog.setThemeDark(true);
                }
                timePickerDialog.show(getActivity().getFragmentManager(), "TimeFragment");
            }

        });
        // mDefaultTimeOptions12H = new String[]{"9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM", "12:00 AM"};
        // mDefaultTimeOptions24H = new String[]{"9:00", "12:00", "15:00", "18:00", "21:00", "24:00"};
        setDateAndTimeEditText();
        // 
        // mChooseDateButton = (Button)findViewById(R.id.newToDoChooseDateButton);
        // mChooseTimeButton = (Button)findViewById(R.id.newToDoChooseTimeButton);
        // 
        // mChooseDateButton.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // Date date;
        // hideKeyboard(mToDoTextBodyEditText);
        // if(mUserToDoItem.getToDoDate()!=null){
        // date = mUserToDoItem.getToDoDate();
        // }
        // else{
        // date = new Date();
        // }
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(date);
        // int year = calendar.get(Calendar.YEAR);
        // int month = calendar.get(Calendar.MONTH);
        // int day = calendar.get(Calendar.DAY_OF_MONTH);
        // 
        // 
        // DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(AddToDoActivity.this, year, month, day);
        // if(theme.equals(MainActivity.DARKTHEME)){
        // datePickerDialog.setThemeDark(true);
        // }
        // datePickerDialog.show(getFragmentManager(), "DateFragment");
        // }
        // });
        // 
        // mChooseTimeButton.setOnClickListener(new View.OnClickListener() {
        // @Override
        // public void onClick(View v) {
        // Date date;
        // hideKeyboard(mToDoTextBodyEditText);
        // if(mUserToDoItem.getToDoDate()!=null){
        // date = mUserToDoItem.getToDoDate();
        // }
        // else{
        // date = new Date();
        // }
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(date);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY);
        // int minute = calendar.get(Calendar.MINUTE);
        // 
        // TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(AddToDoActivity.this, hour, minute, DateFormat.is24HourFormat(AddToDoActivity.this));
        // if(theme.equals(MainActivity.DARKTHEME)){
        // timePickerDialog.setThemeDark(true);
        // }
        // timePickerDialog.show(getFragmentManager(), "TimeFragment");
        // }
        // });
    }


    private void setDateAndTimeEditText() {
        if (mUserToDoItem.hasReminder() && (mUserReminderDate != null)) {
            java.lang.String userDate = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("d MMM, yyyy", mUserReminderDate);
            java.lang.String formatToUse;
            if (android.text.format.DateFormat.is24HourFormat(getContext())) {
                formatToUse = "k:mm";
            } else {
                formatToUse = "h:mm a";
            }
            java.lang.String userTime = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate(formatToUse, mUserReminderDate);
            mTimeEditText.setText(userTime);
            mDateEditText.setText(userDate);
        } else {
            mDateEditText.setText(getString(com.example.avjindersinghsekhon.minimaltodo.R.string.date_reminder_default));
            // mUserReminderDate = new Date();
            boolean time24 = android.text.format.DateFormat.is24HourFormat(getContext());
            java.util.Calendar cal = java.util.Calendar.getInstance();
            if (time24) {
                cal.set(java.util.Calendar.HOUR_OF_DAY, cal.get(java.util.Calendar.HOUR_OF_DAY) + 1);
            } else {
                cal.set(java.util.Calendar.HOUR, cal.get(java.util.Calendar.HOUR) + 1);
            }
            cal.set(java.util.Calendar.MINUTE, 0);
            mUserReminderDate = cal.getTime();
            android.util.Log.d("OskarSchindler", "Imagined Date: " + mUserReminderDate);
            java.lang.String timeString;
            if (time24) {
                timeString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("k:mm", mUserReminderDate);
            } else {
                timeString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("h:mm a", mUserReminderDate);
            }
            mTimeEditText.setText(timeString);
            // int hour = calendar.get(Calendar.HOUR_OF_DAY);
            // if(hour<9){
            // timeOption = time24?mDefaultTimeOptions24H[0]:mDefaultTimeOptions12H[0];
            // }
            // else if(hour < 12){
            // timeOption = time24?mDefaultTimeOptions24H[1]:mDefaultTimeOptions12H[1];
            // }
            // else if(hour < 15){
            // timeOption = time24?mDefaultTimeOptions24H[2]:mDefaultTimeOptions12H[2];
            // }
            // else if(hour < 18){
            // timeOption = time24?mDefaultTimeOptions24H[3]:mDefaultTimeOptions12H[3];
            // }
            // else if(hour < 21){
            // timeOption = time24?mDefaultTimeOptions24H[4]:mDefaultTimeOptions12H[4];
            // }
            // else{
            // timeOption = time24?mDefaultTimeOptions24H[5]:mDefaultTimeOptions12H[5];
            // }
            // mTimeEditText.setText(timeOption);
        }
    }


    private java.lang.String getThemeSet() {
        return getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
    }


    public void hideKeyboard(android.widget.EditText et) {
        android.view.inputmethod.InputMethodManager imm = ((android.view.inputmethod.InputMethodManager) (getActivity().getSystemService(android.content.Context.INPUT_METHOD_SERVICE)));
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }


    public void setDate(int year, int month, int day) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int hour;
        int minute;
        // int currentYear = calendar.get(Calendar.YEAR);
        // int currentMonth = calendar.get(Calendar.MONTH);
        // int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        java.util.Calendar reminderCalendar = java.util.Calendar.getInstance();
        reminderCalendar.set(year, month, day);
        if (reminderCalendar.before(calendar)) {
            // Toast.makeText(this, "My time-machine is a bit rusty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mUserReminderDate != null) {
            calendar.setTime(mUserReminderDate);
        }
        if (android.text.format.DateFormat.is24HourFormat(getContext())) {
            hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        } else {
            hour = calendar.get(java.util.Calendar.HOUR);
        }
        minute = calendar.get(java.util.Calendar.MINUTE);
        calendar.set(year, month, day, hour, minute);
        mUserReminderDate = calendar.getTime();
        setReminderTextView();
        // setDateAndTimeEditText();
        setDateEditText();
    }


    public void setTime(int hour, int minute) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        if (mUserReminderDate != null) {
            calendar.setTime(mUserReminderDate);
        }
        // if(DateFormat.is24HourFormat(this) && hour == 0){
        // //done for 24h time
        // hour = 24;
        // }
        int year = calendar.get(java.util.Calendar.YEAR);
        int month = calendar.get(java.util.Calendar.MONTH);
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        android.util.Log.d("OskarSchindler", "Time set: " + hour);
        calendar.set(year, month, day, hour, minute, 0);
        mUserReminderDate = calendar.getTime();
        setReminderTextView();
        // setDateAndTimeEditText();
        setTimeEditText();
    }


    public void setDateEditText() {
        java.lang.String dateFormat = "d MMM, yyyy";
        mDateEditText.setText(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate(dateFormat, mUserReminderDate));
    }


    public void setTimeEditText() {
        java.lang.String dateFormat;
        if (android.text.format.DateFormat.is24HourFormat(getContext())) {
            dateFormat = "k:mm";
        } else {
            dateFormat = "h:mm a";
        }
        mTimeEditText.setText(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate(dateFormat, mUserReminderDate));
    }


    public void setReminderTextView() {
        if (mUserReminderDate != null) {
            mReminderTextView.setVisibility(android.view.View.VISIBLE);
            if (mUserReminderDate.before(new java.util.Date())) {
                android.util.Log.d("OskarSchindler", "DATE is " + mUserReminderDate);
                mReminderTextView.setText(getString(com.example.avjindersinghsekhon.minimaltodo.R.string.date_error_check_again));
                mReminderTextView.setTextColor(android.graphics.Color.RED);
                return;
            }
            java.util.Date date = mUserReminderDate;
            java.lang.String dateString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("d MMM, yyyy", date);
            java.lang.String timeString;
            java.lang.String amPmString = "";
            if (android.text.format.DateFormat.is24HourFormat(getContext())) {
                timeString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("k:mm", date);
            } else {
                timeString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("h:mm", date);
                amPmString = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate("a", date);
            }
            java.lang.String finalString = java.lang.String.format(getResources().getString(com.example.avjindersinghsekhon.minimaltodo.R.string.remind_date_and_time), dateString, timeString, amPmString);
            mReminderTextView.setTextColor(getResources().getColor(com.example.avjindersinghsekhon.minimaltodo.R.color.secondary_text));
            mReminderTextView.setText(finalString);
        } else {
            mReminderTextView.setVisibility(android.view.View.INVISIBLE);
        }
    }


    public void makeResult(int result) {
        android.util.Log.d(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.TAG, "makeResult - ok : in");
        android.content.Intent i = new android.content.Intent();
        if (mUserEnteredText.length() > 0) {
            java.lang.String capitalizedString = java.lang.Character.toUpperCase(mUserEnteredText.charAt(0)) + mUserEnteredText.substring(1);
            mUserToDoItem.setToDoText(capitalizedString);
            android.util.Log.d(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.TAG, "Description: " + mUserEnteredDescription);
            mUserToDoItem.setmToDoDescription(mUserEnteredDescription);
        } else {
            mUserToDoItem.setToDoText(mUserEnteredText);
            android.util.Log.d(com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.TAG, "Description: " + mUserEnteredDescription);
            mUserToDoItem.setmToDoDescription(mUserEnteredDescription);
        }
        // mUserToDoItem.setLastEdited(mLastEdited);
        if (mUserReminderDate != null) {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(mUserReminderDate);
            calendar.set(java.util.Calendar.SECOND, 0);
            mUserReminderDate = calendar.getTime();
        }
        mUserToDoItem.setHasReminder(mUserHasReminder);
        mUserToDoItem.setToDoDate(mUserReminderDate);
        mUserToDoItem.setTodoColor(mUserColor);
        i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.TODOITEM, mUserToDoItem);
        getActivity().setResult(result, i);
    }


    @java.lang.Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                if (android.support.v4.app.NavUtils.getParentActivityName(getActivity()) != null) {
                    app.send(this, "Action", "Discard Todo");
                    makeResult(android.app.Activity.RESULT_CANCELED);
                    android.support.v4.app.NavUtils.navigateUpFromSameTask(getActivity());
                }
                hideKeyboard(mToDoTextBodyEditText);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    public static java.lang.String formatDate(java.lang.String formatString, java.util.Date dateToFormat) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(formatString);
        return simpleDateFormat.format(dateToFormat);
    }


    @java.lang.Override
    public void onTimeSet(com.wdullaer.materialdatetimepicker.time.RadialPickerLayout radialPickerLayout, int hour, int minute) {
        setTime(hour, minute);
    }


    @java.lang.Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog, int year, int month, int day) {
        setDate(year, month, day);
    }


    public void setEnterDateLayoutVisible(boolean checked) {
        if (checked) {
            mUserDateSpinnerContainingLinearLayout.setVisibility(android.view.View.VISIBLE);
        } else {
            mUserDateSpinnerContainingLinearLayout.setVisibility(android.view.View.INVISIBLE);
        }
    }


    public void setEnterDateLayoutVisibleWithAnimations(boolean checked) {
        if (checked) {
            setReminderTextView();
            mUserDateSpinnerContainingLinearLayout.animate().alpha(1.0F).setDuration(500).setListener(new android.animation.Animator.AnimatorListener() {
                @java.lang.Override
                public void onAnimationStart(android.animation.Animator animation) {
                    mUserDateSpinnerContainingLinearLayout.setVisibility(android.view.View.VISIBLE);
                }


                @java.lang.Override
                public void onAnimationEnd(android.animation.Animator animation) {
                }


                @java.lang.Override
                public void onAnimationCancel(android.animation.Animator animation) {
                }


                @java.lang.Override
                public void onAnimationRepeat(android.animation.Animator animation) {
                }

            });
        } else {
            mUserDateSpinnerContainingLinearLayout.animate().alpha(0.0F).setDuration(500).setListener(new android.animation.Animator.AnimatorListener() {
                @java.lang.Override
                public void onAnimationStart(android.animation.Animator animation) {
                }


                @java.lang.Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    mUserDateSpinnerContainingLinearLayout.setVisibility(android.view.View.INVISIBLE);
                }


                @java.lang.Override
                public void onAnimationCancel(android.animation.Animator animation) {
                }


                @java.lang.Override
                public void onAnimationRepeat(android.animation.Animator animation) {
                }

            });
        }
    }


    @java.lang.Override
    protected int layoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.fragment_add_to_do;
    }


    public static com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment newInstance() {
        return new com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment();
    }

}