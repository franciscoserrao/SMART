package com.example.avjindersinghsekhon.minimaltodo.AddToDo;
import com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.app.Fragment;
public class AddToDoActivity extends com.example.avjindersinghsekhon.minimaltodo.AppDefault.AppDefaultActivity {
    @java.lang.SuppressWarnings("deprecation")
    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @java.lang.Override
    protected int contentViewLayoutRes() {
        return com.example.avjindersinghsekhon.minimaltodo.R.layout.activity_add_to_do;
    }


    @android.support.annotation.NonNull
    @java.lang.Override
    protected android.support.v4.app.Fragment createInitialFragment() {
        return com.example.avjindersinghsekhon.minimaltodo.AddToDo.AddToDoFragment.newInstance();
    }


    @java.lang.Override
    protected void onResume() {
        super.onResume();
    }

}