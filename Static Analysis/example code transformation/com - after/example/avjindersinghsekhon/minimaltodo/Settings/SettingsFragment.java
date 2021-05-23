package com.example.avjindersinghsekhon.minimaltodo.Settings;
import android.preference.PreferenceFragment;
import com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment;
import android.content.SharedPreferences;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.preference.CheckBoxPreference;
import android.os.Bundle;
import com.example.avjindersinghsekhon.minimaltodo.Utility.PreferenceKeys;
import android.content.Context;
public class SettingsFragment extends android.preference.PreferenceFragment implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(com.example.avjindersinghsekhon.minimaltodo.R.xml.preferences_layout);
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
    }


    @java.lang.Override
    public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String key) {
        com.example.avjindersinghsekhon.minimaltodo.Utility.PreferenceKeys preferenceKeys = new com.example.avjindersinghsekhon.minimaltodo.Utility.PreferenceKeys(getResources());
        if (key.equals(preferenceKeys.night_mode_pref_key)) {
            android.content.SharedPreferences themePreferences = getActivity().getSharedPreferences(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_PREFERENCES, android.content.Context.MODE_PRIVATE);
            android.content.SharedPreferences.Editor themeEditor = themePreferences.edit();
            // We tell our MainLayout to recreate itself because mode has changed
            themeEditor.putBoolean(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.RECREATE_ACTIVITY, true);
            android.preference.CheckBoxPreference checkBoxPreference = ((android.preference.CheckBoxPreference) (findPreference(preferenceKeys.night_mode_pref_key)));
            if (checkBoxPreference.isChecked()) {
                // Comment out this line if not using Google Analytics
                app.send(this, "Settings", "Night Mode used");
                themeEditor.putString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.DARKTHEME);
            } else {
                themeEditor.putString(com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.THEME_SAVED, com.example.avjindersinghsekhon.minimaltodo.Main.MainFragment.LIGHTTHEME);
            }
            themeEditor.apply();
            getActivity().recreate();
        }
    }


    @java.lang.Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }


    @java.lang.Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

}