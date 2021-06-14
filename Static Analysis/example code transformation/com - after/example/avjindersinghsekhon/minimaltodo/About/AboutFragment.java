package com.example.avjindersinghsekhon.minimaltodo.About;
import android.support.annotation.LayoutRes;
import com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment;
import android.support.annotation.Nullable;
import android.view.View;
public class AboutFragment extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultFragment {
    private android.widget.TextView mVersionTextView;

    private java.lang.String appVersion = "0.1";

    private android.support.v7.widget.Toolbar toolbar;

    private android.widget.TextView contactMe;

    private com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication app;

    @java.lang.Override
    public void onCreate(@android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @java.lang.Override
    public void onViewCreated(android.view.View view, @android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        app = ((com.example.avjindersinghsekhon.minimaltodo.Analytics.AnalyticsApplication) (getActivity().getApplication()));
        app.send(this);
        mVersionTextView = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.aboutVersionTextView)));
        mVersionTextView.setText(java.lang.String.format(getResources().getString(com.example.avjindersinghsekhon.minimaltodo.R.string.app_version), appVersion));
        toolbar = ((android.support.v7.widget.Toolbar) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.toolbar)));
        contactMe = ((android.widget.TextView) (view.findViewById(com.example.avjindersinghsekhon.minimaltodo.R.id.aboutContactMe)));
        contactMe.setOnClickListener(new android.view.View.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View v) {
                app.send(this, "Action", "Feedback");
            }

        });
    }


    @android.support.annotation.LayoutRes
    protected int layoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.fragment_about;
    }


    public static com.example.avjindersinghsekhon.minimaltodo.About.AboutFragment newInstance() {
        return new com.example.avjindersinghsekhon.minimaltodo.About.AboutFragment();
    }

}