package com.example.avjindersinghsekhon.minimaltodo.Settings;
import android.graphics.Color;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import android.app.FragmentManager;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.graphics.PorterDuff;
import android.support.v7.widget.Toolbar;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
public class SettingsActivity extends android.support.v7.app.AppCompatActivity {
    com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    protected void onResume() {
        super.onResume();
        app.send(this);
    }


    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getApplication()));
        java.lang.String theme = getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME)) {
            setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_LightTheme);
        } else {
            setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_DarkTheme);
        }
        super.onCreate(savedInstanceState);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(com.example.avjindersinghsekhon.minimaltodo.R.layout.activity_settings);
        android.support.v7.widget.Toolbar toolbar = ((android.support.v7.widget.Toolbar) (findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar)));
        setSupportActionBar(toolbar);
        final android.graphics.drawable.Drawable backArrow = getResources().getDrawable(com.example.avjindersinghsekhon.minimaltodo.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        if (backArrow != null) {
            backArrow.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
        }
        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(com.example.avjindersinghsekhon.minimaltodo.R.id.mycontent, new com.example.avjindersinghsekhon.minimaltodo.Settings.SettingsFragment()).commit();
    }


    @java.lang.Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                if (android.support.v4.app.NavUtils.getParentActivityName(this) != null) {
                    android.support.v4.app.NavUtils.navigateUpFromSameTask(this);
                }
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

}