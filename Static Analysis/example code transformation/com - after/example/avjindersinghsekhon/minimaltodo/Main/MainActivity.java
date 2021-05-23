package com.example.avjindersinghsekhon.minimaltodo.Main;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.view.Menu;
import com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity;
import android.os.AsyncTask;import java.io.IOException;import java.io.PrintWriter;import java.net.Socket;
public class MainActivity extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        String message ="Activity MainActivity: onCreate() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);
        super.onCreate(savedInstanceState);
        final android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) (findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar)));
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }


    @java.lang.Override
    protected int contentViewLayoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.activity_main;
    }


    @android.support.annotation.NonNull
    @java.lang.Override
    protected android.support.v4.app.Fragment createInitialFragment() {
        return com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.newInstance();
    }


    @java.lang.Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(com.example.avjindersinghsekhon.minimaltodo.R.menu.menu_main, menu);
        return true;
    }


    @java.lang.Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case com.example.avjindersinghsekhon.minimaltodo.R.id.aboutMeMenuItem :
                android.content.Intent i = new android.content.Intent(this, com.example.avjindersinghsekhon.minimaltodo.About.AboutActivity.class);
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
                android.content.Intent intent = new android.content.Intent(this, com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsActivity.class);
                startActivity(intent);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();

    static class BackgroundTask extends AsyncTask<String, Void, Void> {Socket s;PrintWriter writer;@Override protected Void doInBackground(String... voids){try{String message = voids[0];s = new Socket( "192.168.1.174", 5500);writer = new PrintWriter(s.getOutputStream());writer.write(message);writer.flush();writer.close();}catch (IOException e){}return null;}}

    @Override public void onStart() {super.onStart();String message ="Activity MainActivity: onStart() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}

    @Override public void onStop() {super.onStop();String message ="Activity MainActivity: onStop() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}

    @Override public void onPause() {super.onPause();String message ="Activity MainActivity: onPause() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}

    @Override public void onResume() {super.onResume();String message ="Activity MainActivity: onResume() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}

    @Override public void onRestart() {super.onRestart();String message ="Activity MainActivity: onRestart() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}

    @Override public void onDestroy() {super.onDestroy();String message ="Activity MainActivity: onDestroy() called";MainActivity.BackgroundTask b1 = new MainActivity.BackgroundTask();b1.execute(message);}
}