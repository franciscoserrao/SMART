package com.example.avjindersinghsekhon.minimaltodo.AppDefault;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.View;
public abstract class AppDefaultFragment extends android.support.v4.app.Fragment {
    @android.support.annotation.Nullable
    @java.lang.Override
    public android.view.View onCreateView(android.view.LayoutInflater inflater, @android.support.annotation.Nullable
    android.view.ViewGroup container, @android.support.annotation.Nullable
    android.os.Bundle savedInstanceState) {
        return inflater.inflate(layoutRes(), container, false);
    }


    @java.lang.Override
    public void onDestroy() {
        super.onDestroy();
    }


    @android.support.annotation.LayoutRes
    protected abstract int layoutRes();

}