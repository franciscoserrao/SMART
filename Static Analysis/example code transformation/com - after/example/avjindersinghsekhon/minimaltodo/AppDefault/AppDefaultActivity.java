package com.example.avjindersinghsekhon.minimaltodo.AppDefault;
import android.support.annotation.LayoutRes;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
public abstract class AppDefaultActivity extends android.support.v7.app.AppCompatActivity {
    @java.lang.Override
    protected void onCreate(@android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(contentViewLayoutRes());
        setUpInitialFragment(savedInstanceState);
    }


    private void setUpInitialFragment(@android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(com.example.avjindersinghsekhon.minimaltodo.R.id.fragment_container, createInitialFragment()).commit();
        }
    }


    @android.support.annotation.LayoutRes
    protected abstract int contentViewLayoutRes();


    @android.support.annotation.NonNull
    protected abstract android.support.v4.app.Fragment createInitialFragment();

}