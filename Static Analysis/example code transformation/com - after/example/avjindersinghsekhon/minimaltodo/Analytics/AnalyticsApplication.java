package com.example.avjindersinghsekhon.minimaltodo.Analytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.google.android.gms.analytics.HitBuilders;
import android.content.pm.PackageManager;
import android.app.Application;
import java.util.Map;
public class AnalyticsApplication extends android.app.Application {
    private com.google.android.gms.analytics.Tracker mTracker;

    private static final boolean IS_ENABLED = true;

    private synchronized com.google.android.gms.analytics.Tracker getDefaultTracker() {
        if (mTracker == null) {
            com.google.android.gms.analytics.GoogleAnalytics analytics = com.google.android.gms.analytics.GoogleAnalytics.getInstance(this);
            /* R.xml.app_tracker contains my Analytics code
            To use this, go to Google Analytics, and get
            your code, create a file under res/xml , and save
            your code as <string name="ga_trackingId">UX-XXXXXXXX-Y</string>
             */
            // mTracker = analytics.newTracker(R.xml.app_tracker);
            mTracker = analytics.newTracker(com.example.avjindersinghsekhon.minimaltodo.R.xml.global_tracker);
            // 
            mTracker.setAppName("Minimal");
            mTracker.enableExceptionReporting(true);
            try {
                mTracker.setAppId(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
            } catch (android.content.pm.PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mTracker;
    }


    public void send(java.lang.Object screenName) {
        send(screenName, new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder().build());
    }


    private void send(java.lang.Object screenName, java.util.Map<java.lang.String, java.lang.String> params) {
        if (com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication.IS_ENABLED) {
            com.google.android.gms.analytics.Tracker tracker = getDefaultTracker();
            tracker.setScreenName(getClassName(screenName));
            tracker.send(params);
        }
    }


    private java.lang.String getClassName(java.lang.Object o) {
        java.lang.Class c = o.getClass();
        while (c.isAnonymousClass()) {
            c = c.getEnclosingClass();
        } 
        return c.getSimpleName();
    }


    public void send(java.lang.Object screenName, java.lang.String category, java.lang.String action) {
        send(screenName, new com.google.android.gms.analytics.HitBuilders.EventBuilder().setCategory(category).setAction(action).build());
    }


    public void send(java.lang.Object screenName, java.lang.String category, java.lang.String action, java.lang.String label) {
        send(screenName, new com.google.android.gms.analytics.HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
    }

}