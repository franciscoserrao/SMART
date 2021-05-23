package com.example.avjindersinghsekhon.minimaltodo.About;
import android.graphics.Color;
import android.util.Log;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.graphics.PorterDuff;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
public class AboutActivity extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity {
    private android.widget.TextView mVersionTextView;

    private java.lang.String appVersion = "0.1";

    private android.support.v7.widget.Toolbar toolbar;

    private android.widget.TextView contactMe;

    java.lang.String theme;

    // private UUID mId;
    private com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        theme = getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE).getString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
        if (theme.equals(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DARKTHEME)) {
            android.util.Log.d("OskarSchindler", "One");
            setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_DarkTheme);
        } else {
            android.util.Log.d("OskarSchindler", "One");
            setTheme(com.example.avjindersinghsekhon.minimaltodo.R.style.CustomStyle_LightTheme);
        }
        super.onCreate(savedInstanceState);
        // mId = (UUID)i.getSerializableExtra(TodoNotificationService.TODOUUID);
        final android.graphics.drawable.Drawable backArrow = getResources().getDrawable(com.example.avjindersinghsekhon.minimaltodo.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        if (backArrow != null) {
            backArrow.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        try {
            android.content.pm.PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = info.versionName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        toolbar = ((android.support.v7.widget.Toolbar) (findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar)));
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(backArrow);
        }
    }


    @java.lang.Override
    protected int contentViewLayoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.about_layout;
    }


    @android.support.annotation.NonNull
    protected android.support.v4.app.Fragment createInitialFragment() {
        return com.example.avjindersinghsekhon.minimaltodo.About.AboutFragment.newInstance();
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