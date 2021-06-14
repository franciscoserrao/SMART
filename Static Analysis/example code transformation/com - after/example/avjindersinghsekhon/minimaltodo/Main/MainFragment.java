package com.example.avjindersinghsekhon.minimaltodo.Main;
import android.view.animation.DecelerateInterpolator;
import com.amulyakhare.textdrawable.TextDrawable;
import java.util.ArrayList;
import android.support.v7.widget.DefaultItemAnimator;
import com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import android.support.v7.widget.LinearLayoutManager;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collections;
import android.graphics.Color;
import com.example.avjindersinghsekhon.minimaltodo.Utility.ItemTouchHelperClass;
import com.example.avjindersinghsekhon.minimaltodo.Utility.RecyclerViewEmptySupport;
import android.util.Log;
import android.view.Menu;
import android.graphics.Typeface;
import com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService;
import android.view.LayoutInflater;
import com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity;
import android.app.PendingIntent;
import android.support.design.widget.Snackbar;
import android.support.annotation.Nullable;
import com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity;
import static android.app.Activity.RESULT_CANCELED;
import com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem;
import static android.content.Context.ALARM_SERVICE;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.support.design.widget.FloatingActionButton;
import static android.content.Context.MODE_PRIVATE;
import com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment;
import android.widget.LinearLayout;
import android.content.SharedPreferences;
import android.view.animation.AccelerateInterpolator;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import org.json.JSONException;
import android.os.Bundle;
import android.view.ViewGroup;
import java.io.IOException;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import java.util.Date;
import android.support.design.widget.CoordinatorLayout;
import android.app.AlarmManager;
import com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoActivity;
import android.support.v7.widget.RecyclerView;
public class MainFragment extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment {
    private com.example.avjindersinghsekhon.minimaltodo.Utility.RecyclerViewEmptySupport mRecyclerView;

    private android.support.design.widget.FloatingActionButton mAddToDoItemFAB;

    private java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> mToDoItemsArrayList;

    private android.support.design.widget.CoordinatorLayout mCoordLayout;

    public static final java.lang.String TODOITEM = "com.avjindersinghsekhon.com.avjindersinghsekhon.minimaltodo.MainActivity";

    private com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter adapter;

    private static final int REQUEST_ID_TODO_ITEM = 100;

    private com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem mJustDeletedToDoItem;

    private int mIndexOfDeletedToDoItem;

    public static final java.lang.String DATE_TIME_FORMAT_12_HOUR = "MMM d, yyyy  h:mm a";

    public static final java.lang.String DATE_TIME_FORMAT_24_HOUR = "MMM d, yyyy  k:mm";

    public static final java.lang.String FILENAME = "todoitems.json";

    private com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData storeRetrieveData;

    public android.support.v7.widget.helper.ItemTouchHelper itemTouchHelper;

    private com.example.avjindersinghsekhon.minimaltodo.Main.CustomRecyclerScrollViewListener customRecyclerScrollViewListener;

    public static final java.lang.String SHARED_PREF_DATA_SET_CHANGED = "com.avjindersekhon.datasetchanged";

    public static final java.lang.String CHANGE_OCCURED = "com.avjinder.changeoccured";

    private int mTheme = -1;

    private java.lang.String theme = "name_of_the_theme";

    public static final java.lang.String THEME_PREFERENCES = "com.avjindersekhon.themepref";

    public static final java.lang.String RECREATE_ACTIVITY = "com.avjindersekhon.recreateactivity";

    public static final java.lang.String THEME_SAVED = "com.avjindersekhon.savedtheme";

    public static final java.lang.String DARKTHEME = "com.avjindersekon.darktheme";

    public static final java.lang.String LIGHTTHEME = "com.avjindersekon.lighttheme";

    private com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    private java.lang.String[] testStrings = new java.lang.String[]{ "Clean my room", "Water the plants", "Get car washed", "Get my dry cleaning" };

    @java.lang.Override
    public void onViewCreated(android.view.View view, @android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
        // CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        // .setDefaultFontPath("fonts/Aller_Regular.tff").setFontAttrId(R.attr.fontPath).build());
        // We recover the theme we've set and setTheme accordingly
        theme = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            mTheme = com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_LightTheme;
        } else {
            mTheme = com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_DarkTheme;
        }
        this.getActivity().setTheme(mTheme);
        super.onCreate(savedInstanceState);
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.CHANGE_OCCURED, false);
        editor.apply();
        storeRetrieveData = new com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData(getContext(), com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.FILENAME);
        mToDoItemsArrayList = com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.getLocallyStoredData(storeRetrieveData);
        adapter = new com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter(mToDoItemsArrayList);
        setAlarms();
        // adapter.notifyDataSetChanged();
        // storeRetrieveData = new StoreRetrieveData(this, FILENAME);
        // 
        // try {
        // mToDoItemsArrayList = storeRetrieveData.loadFromFile();
        // //            Log.d("OskarSchindler", "Arraylist Length: "+mToDoItemsArrayList.size());
        // } catch (IOException | JSONException e) {
        // //            Log.d("OskarSchindler", "IOException received");
        // e.printStackTrace();
        // }
        // 
        // if(mToDoItemsArrayList==null){
        // mToDoItemsArrayList = new ArrayList<>();
        // }
        // 
        // mToDoItemsArrayList = new ArrayList<>();
        // makeUpItems(mToDoItemsArrayList, testStrings.length);
        mCoordLayout = ((android.support.design.widget.CoordinatorLayout) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.myCoordinatorLayout)));
        mAddToDoItemFAB = ((android.support.design.widget.FloatingActionButton) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.addToDoItemFAB)));
        mAddToDoItemFAB.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.SuppressWarnings("deprecation")
            @java.lang.Override
            public void onClick(android.view.View v) {
                app.send(this, "Action", "FAB pressed");
                android.content.Intent newTodo = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoActivity.class);
                com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = new com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem("", "", false, null);
                int color = com.amulyakhare.textdrawable.util.ColorGenerator.MATERIAL.getRandomColor();
                item.setTodoColor(color);
                // noinspection ResourceType
                // String color = getResources().getString(R.color.primary_ligher);
                newTodo.putExtra(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.TODOITEM, item);
                // View decorView = getWindow().getDecorView();
                // View navView= decorView.findViewById(android.R.id.navigationBarBackground);
                // View statusView = decorView.findViewById(android.R.id.statusBarBackground);
                // Pair<View, String> navBar ;
                // if(navView!=null){
                // navBar = Pair.create(navView, navView.getTransitionName());
                // }
                // else{
                // navBar = null;
                // }
                // Pair<View, String> statusBar= Pair.create(statusView, statusView.getTransitionName());
                // ActivityOptions options;
                // if(navBar!=null){
                // options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, navBar, statusBar);
                // }
                // else{
                // options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, statusBar);
                // }
                // startActivity(new Intent(MainActivity.this, TestLayout.class), options.toBundle());
                // startActivityForResult(newTodo, REQUEST_ID_TODO_ITEM, options.toBundle());
                startActivityForResult(newTodo, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.REQUEST_ID_TODO_ITEM);
            }

        });
        // mRecyclerView = (RecyclerView)findViewById(R.id.toDoRecyclerView);
        mRecyclerView = ((com.example.avjindersinghsekhon.minimaltodo.Utility.RecyclerViewEmptySupport) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoRecyclerView)));
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            mRecyclerView.setBackgroundColor(getResources().getColor(com.example.avjindersinghsekhon.minimaltodo.R.color.primary_lightest));
        }
        mRecyclerView.setEmptyView(view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoEmptyView));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new android.support.v7.widget.DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(getContext()));
        customRecyclerScrollViewListener = new com.example.avjindersinghsekhon.minimaltodo.Main.CustomRecyclerScrollViewListener() {
            @java.lang.Override
            public void show() {
                mAddToDoItemFAB.animate().translationY(0).setInterpolator(new android.view.animation.DecelerateInterpolator(2)).start();
                // mAddToDoItemFAB.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2.0f)).start();
            }


            @java.lang.Override
            public void hide() {
                android.support.design.widget.CoordinatorLayout.LayoutParams lp = ((android.support.design.widget.CoordinatorLayout.LayoutParams) (mAddToDoItemFAB.getLayoutParams()));
                int fabMargin = lp.bottomMargin;
                mAddToDoItemFAB.animate().translationY(mAddToDoItemFAB.getHeight() + fabMargin).setInterpolator(new android.view.animation.AccelerateInterpolator(2.0F)).start();
            }

        };
        mRecyclerView.addOnScrollListener(customRecyclerScrollViewListener);
        android.support.v7.widget.helper.ItemTouchHelper.Callback callback = new com.example.avjindersinghsekhon.minimaltodo.Utility.ItemTouchHelperClass(adapter);
        itemTouchHelper = new android.support.v7.widget.helper.ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(adapter);
        // setUpTransitions();
    }


    public static java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> getLocallyStoredData(com.example.avjindersinghsekhon.minimaltodo.Utility.StoreRetrieveData storeRetrieveData) {
        java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items = null;
        try {
            items = storeRetrieveData.loadFromFile();
        } catch (java.io.IOException | org.json.JSONException e) {
            e.printStackTrace();
        }
        if (items == null) {
            items = new java.util.ArrayList<>();
        }
        return items;
    }


    @java.lang.Override
    public void onResume() {
        super.onResume();
        app.send(this);
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean(com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment.EXIT, false)) {
            android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Reminder.ReminderFragment.EXIT, false);
            editor.apply();
            getActivity().finish();
        }
        /* We need to do this, as this activity's onCreate won't be called when coming back from SettingsActivity,
        thus our changes to dark/light mode won't take place, as the setContentView() is not called again.
        So, inside our SettingsFragment, whenever the checkbox's value is changed, in our shared preferences,
        we mark our recreate_activity key as true.

        Note: the recreate_key's value is changed to false before calling recreate(), or we woudl have ended up in an infinite loop,
        as onResume() will be called on recreation, which will again call recreate() and so on....
        and get an ANR
         */
        if (getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.RECREATE_ACTIVITY, false)) {
            android.content.SharedPreferences.Editor editor = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).edit();
            editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.RECREATE_ACTIVITY, false);
            editor.apply();
            getActivity().recreate();
        }
    }


    @java.lang.Override
    public void onStart() {
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
        super.onStart();
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.SHARED_PREF_DATA_SET_CHANGED, android.content.Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.CHANGE_OCCURED, false)) {
            mToDoItemsArrayList = com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.getLocallyStoredData(storeRetrieveData);
            adapter = new com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter(mToDoItemsArrayList);
            mRecyclerView.setAdapter(adapter);
            setAlarms();
            android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.CHANGE_OCCURED, false);
            // editor.commit();
            editor.apply();
        }
    }


    private void setAlarms() {
        if (mToDoItemsArrayList != null) {
            for (com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item : mToDoItemsArrayList) {
                if (item.hasReminder() && (item.getToDoDate() != null)) {
                    if (item.getToDoDate().before(new java.util.Date())) {
                        item.setToDoDate(null);
                        continue;
                    }
                    android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.class);
                    i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID, item.getIdentifier());
                    i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOTEXT, item.getToDoText());
                    createAlarm(i, item.getIdentifier().hashCode(), item.getToDoDate().getTime());
                }
            }
        }
    }


    public void addThemeToSharedPreferences(java.lang.String theme) {
        android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, theme);
        editor.apply();
    }


    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getActivity().getMenuInflater().inflate(com.example.avjindersinghsekhon.minimaltodo.R.menu.menu_main, menu);
        return true;
    }


    @java.lang.Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case com.example.avjindersinghsekhon.minimaltodo.R.id.aboutMeMenuItem :
                android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity.class);
                startActivity(i);
                return true;
                // case R.id.switch_themes:
                // if(mTheme == R.style.CustomStyle_DarkTheme){
                // addThemeToSharedPreferences(LIGHTTHEME);
                // }
                // else{
                // addThemeToSharedPreferences(DARKTHEME);
                // }
                // 
                // //                if(mTheme == R.style.CustomStyle_DarkTheme){
                // //                    mTheme = R.style.CustomStyle_LightTheme;
                // //                }
                // //                else{
                // //                    mTheme = R.style.CustomStyle_DarkTheme;
                // //                }
                // this.recreate();
                // return true;
            case com.example.avjindersinghsekhon.minimaltodo.R.id.preferences :
                android.content.Intent intent = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity.class);
                startActivity(intent);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    @java.lang.Override
    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        if ((resultCode != android.app.Activity.RESULT_CANCELED) && (requestCode == com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.REQUEST_ID_TODO_ITEM)) {
            com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = ((com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem) (data.getSerializableExtra(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.TODOITEM)));
            if (item.getToDoText().length() <= 0) {
                return;
            }
            boolean existed = false;
            if (item.hasReminder() && (item.getToDoDate() != null)) {
                android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.class);
                i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOTEXT, item.getToDoText());
                i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID, item.getIdentifier());
                createAlarm(i, item.getIdentifier().hashCode(), item.getToDoDate().getTime());
                // Log.d("OskarSchindler", "Alarm Created: "+item.getToDoText()+" at "+item.getToDoDate());
            }
            for (int i = 0; i < mToDoItemsArrayList.size(); i++) {
                if (item.getIdentifier().equals(mToDoItemsArrayList.get(i).getIdentifier())) {
                    mToDoItemsArrayList.set(i, item);
                    existed = true;
                    adapter.notifyDataSetChanged();
                    break;
                }
            }
            if (!existed) {
                addToDataStore(item);
            }
        }
    }


    private android.app.AlarmManager getAlarmManager() {
        return ((android.app.AlarmManager) (getActivity().getSystemService(android.content.Context.ALARM_SERVICE)));
    }


    private boolean doesPendingIntentExist(android.content.Intent i, int requestCode) {
        android.app.PendingIntent pi = android.app.PendingIntent.getService(getContext(), requestCode, i, android.app.PendingIntent.FLAG_NO_CREATE);
        return pi != null;
    }


    private void createAlarm(android.content.Intent i, int requestCode, long timeInMillis) {
        android.app.AlarmManager am = getAlarmManager();
        android.app.PendingIntent pi = android.app.PendingIntent.getService(getContext(), requestCode, i, android.app.PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(android.app.AlarmManager.RTC_WAKEUP, timeInMillis, pi);
        // Log.d("OskarSchindler", "createAlarm "+requestCode+" time: "+timeInMillis+" PI "+pi.toString());
    }


    private void deleteAlarm(android.content.Intent i, int requestCode) {
        if (doesPendingIntentExist(i, requestCode)) {
            android.app.PendingIntent pi = android.app.PendingIntent.getService(getContext(), requestCode, i, android.app.PendingIntent.FLAG_NO_CREATE);
            pi.cancel();
            getAlarmManager().cancel(pi);
            android.util.Log.d("OskarSchindler", "PI Cancelled " + doesPendingIntentExist(i, requestCode));
        }
    }


    private void addToDataStore(com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item) {
        mToDoItemsArrayList.add(item);
        adapter.notifyItemInserted(mToDoItemsArrayList.size() - 1);
    }


    public void makeUpItems(java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items, int len) {
        for (java.lang.String testString : testStrings) {
            com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = new com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem(testString, testString, false, new java.util.Date());
            // noinspection ResourceType
            // item.setTodoColor(getResources().getString(R.color.red_secondary));
            items.add(item);
        }
    }


    public class BasicListAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter.ViewHolder> implements com.example.avjindersinghsekhon.minimaltodo.Utility.ItemTouchHelperClass.ItemTouchHelperAdapter {
        private java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items;

        @java.lang.Override
        public void onItemMoved(int fromPosition, int toPosition) {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    java.util.Collections.swap(items, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    java.util.Collections.swap(items, i, i - 1);
                }
            }
            notifyItemMoved(fromPosition, toPosition);
        }


        @java.lang.Override
        public void onItemRemoved(final int position) {
            // Remove this line if not using Google Analytics
            app.send(this, "Action", "Swiped Todo Away");
            mJustDeletedToDoItem = items.remove(position);
            mIndexOfDeletedToDoItem = position;
            android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.class);
            deleteAlarm(i, mJustDeletedToDoItem.getIdentifier().hashCode());
            notifyItemRemoved(position);
            // String toShow = (mJustDeletedToDoItem.getToDoText().length()>20)?mJustDeletedToDoItem.getToDoText().substring(0, 20)+"...":mJustDeletedToDoItem.getToDoText();
            java.lang.String toShow = "Todo";
            android.support.design.widget.Snackbar.make(mCoordLayout, "Deleted " + toShow, android.support.design.widget.Snackbar.LENGTH_LONG).setAction("UNDO", new android.view.View.OnClickListener() {
                @java.lang.Override
                public void onClick(android.view.View v) {
                    // Comment the line below if not using Google Analytics
                    app.send(this, "Action", "UNDO Pressed");
                    items.add(mIndexOfDeletedToDoItem, mJustDeletedToDoItem);
                    if ((mJustDeletedToDoItem.getToDoDate() != null) && mJustDeletedToDoItem.hasReminder()) {
                        android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.class);
                        i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOTEXT, mJustDeletedToDoItem.getToDoText());
                        i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Utility.TodoNotificationService.TODOUUID, mJustDeletedToDoItem.getIdentifier());
                        createAlarm(i, mJustDeletedToDoItem.getIdentifier().hashCode(), mJustDeletedToDoItem.getToDoDate().getTime());
                    }
                    notifyItemInserted(mIndexOfDeletedToDoItem);
                }

            }).show();
        }


        @java.lang.Override
        public com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
            android.view.View v = android.view.LayoutInflater.from(parent.getContext()).inflate(com.example.avjindersinghsekhon.minimaltodo.R.layout.list_circle_try, parent, false);
            return new com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter.ViewHolder(v);
        }


        @java.lang.Override
        public void onBindViewHolder(final com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter.ViewHolder holder, final int position) {
            com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = items.get(position);
            // if(item.getToDoDate()!=null && item.getToDoDate().before(new Date())){
            // item.setToDoDate(null);
            // }
            android.content.SharedPreferences sharedPreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE);
            // Background color for each to-do item. Necessary for night/day mode
            int bgColor;
            // color of title text in our to-do item. White for night mode, dark gray for day mode
            int todoTextColor;
            if (sharedPreferences.getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME).equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
                bgColor = android.graphics.Color.WHITE;
                todoTextColor = getResources().getColor(com.example.avjindersinghsekhon.minimaltodo.R.color.secondary_text);
            } else {
                bgColor = android.graphics.Color.DKGRAY;
                todoTextColor = android.graphics.Color.WHITE;
            }
            holder.linearLayout.setBackgroundColor(bgColor);
            if (item.hasReminder() && (item.getToDoDate() != null)) {
                holder.mToDoTextview.setMaxLines(1);
                holder.mTimeTextView.setVisibility(android.view.View.VISIBLE);
                // holder.mToDoTextview.setVisibility(View.GONE);
            } else {
                holder.mTimeTextView.setVisibility(android.view.View.GONE);
                holder.mToDoTextview.setMaxLines(2);
            }
            holder.mToDoTextview.setText(item.getToDoText());
            holder.mToDoTextview.setTextColor(todoTextColor);
            // holder.mColorTextView.setBackgroundColor(Color.parseColor(item.getTodoColor()));
            // TextDrawable myDrawable = TextDrawable.builder().buildRoundRect(item.getToDoText().substring(0,1),Color.RED, 10);
            // We check if holder.color is set or not
            // if(item.getTodoColor() == null){
            // ColorGenerator generator = ColorGenerator.MATERIAL;
            // int color = generator.getRandomColor();
            // item.setTodoColor(color+"");
            // }
            // Log.d("OskarSchindler", "Color: "+item.getTodoColor());
            com.amulyakhare.textdrawable.TextDrawable myDrawable = com.amulyakhare.textdrawable.TextDrawable.builder().beginConfig().textColor(android.graphics.Color.WHITE).useFont(android.graphics.Typeface.DEFAULT).toUpperCase().endConfig().buildRound(item.getToDoText().substring(0, 1), item.getTodoColor());
            // TextDrawable myDrawable = TextDrawable.builder().buildRound(item.getToDoText().substring(0,1),holder.color);
            holder.mColorImageView.setImageDrawable(myDrawable);
            if (item.getToDoDate() != null) {
                java.lang.String timeToShow;
                if (android.text.format.DateFormat.is24HourFormat(getContext())) {
                    timeToShow = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DATE_TIME_FORMAT_24_HOUR, item.getToDoDate());
                } else {
                    timeToShow = com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.formatDate(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DATE_TIME_FORMAT_12_HOUR, item.getToDoDate());
                }
                holder.mTimeTextView.setText(timeToShow);
            }
        }


        @java.lang.Override
        public int getItemCount() {
            return items.size();
        }


        BasicListAdapter(java.util.ArrayList<com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem> items) {
            this.items = items;
        }


        @java.lang.SuppressWarnings("deprecation")
        public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
            android.view.View mView;

            android.widget.LinearLayout linearLayout;

            android.widget.TextView mToDoTextview;

            // TextView mColorTextView;
            android.widget.ImageView mColorImageView;

            android.widget.TextView mTimeTextView;

            // int color = -1;
            public ViewHolder(android.view.View v) {
                super(v);
                mView = v;
                v.setOnClickListener(new android.view.View.OnClickListener() {
                    @java.lang.Override
                    public void onClick(android.view.View v) {
                        com.example.avjindersinghsekhon.minimaltodo.Utility.ToDoItem item = items.get(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.BasicListAdapter.ViewHolder.this.getAdapterPosition());
                        android.content.Intent i = new android.content.Intent(getContext(), com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoActivity.class);
                        i.putExtra(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.TODOITEM, item);
                        startActivityForResult(i, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.REQUEST_ID_TODO_ITEM);
                    }

                });
                mToDoTextview = ((android.widget.TextView) (v.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoListItemTextview)));
                mTimeTextView = ((android.widget.TextView) (v.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.todoListItemTimeTextView)));
                // mColorTextView = (TextView)v.findViewById(R.id.toDoColorTextView);
                mColorImageView = ((android.widget.ImageView) (v.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toDoListItemColorImageView)));
                linearLayout = ((android.widget.LinearLayout) (v.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.listItemLinearLayout)));
            }

        }
    }

    // Used when using custom fonts
    // @Override
    // protected void attachBaseContext(Context newBase) {
    // super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    // }
    private void saveDate() {
        try {
            storeRetrieveData.saveToFile(mToDoItemsArrayList);
        } catch (org.json.JSONException | java.io.IOException e) {
            e.printStackTrace();
        }
    }


    @java.lang.Override
    public void onPause() {
        super.onPause();
        try {
            storeRetrieveData.saveToFile(mToDoItemsArrayList);
        } catch (org.json.JSONException | java.io.IOException e) {
            e.printStackTrace();
        }
    }


    @java.lang.Override
    public void onDestroy() {
        super.onDestroy();
        mRecyclerView.removeOnScrollListener(customRecyclerScrollViewListener);
    }


    // public void setUpTransitions(){
    // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
    // Transition enterT = new Slide(Gravity.RIGHT);
    // enterT.setDuration(500);
    // 
    // Transition exitT = new Slide(Gravity.LEFT);
    // exitT.setDuration(300);
    // 
    // Fade fade = new Fade();
    // fade.setDuration(500);
    // 
    // getWindow().setExitTransition(fade);
    // getWindow().setReenterTransition(fade);
    // 
    // }
    // }
    @java.lang.Override
    protected int layoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.fragment_main;
    }


    public static com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment newInstance() {
        return new com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment();
    }

}