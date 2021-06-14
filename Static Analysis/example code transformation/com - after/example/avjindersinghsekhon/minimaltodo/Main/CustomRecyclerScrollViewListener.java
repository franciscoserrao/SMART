package com.example.avjindersinghsekhon.minimaltodo.Main;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
public abstract class CustomRecyclerScrollViewListener extends android.support.v7.widget.RecyclerView.OnScrollListener {
    int scrollDist = 0;

    boolean isVisible = true;

    static final float MINIMUM = 20;

    @java.lang.Override
    public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        // Log.d("OskarSchindler", "Scroll Distance "+scrollDist);
        if (isVisible && (scrollDist > com.example.avjindersinghsekhon.minimaltodo.Main.CustomRecyclerScrollViewListener.MINIMUM)) {
            android.util.Log.d("OskarSchindler", "Hide " + scrollDist);
            hide();
            scrollDist = 0;
            isVisible = false;
        } else if ((!isVisible) && (scrollDist < (-com.example.avjindersinghsekhon.minimaltodo.Main.CustomRecyclerScrollViewListener.MINIMUM))) {
            android.util.Log.d("OskarSchindler", "Show " + scrollDist);
            show();
            scrollDist = 0;
            isVisible = true;
        }
        if ((isVisible && (dy > 0)) || ((!isVisible) && (dy < 0))) {
            android.util.Log.d("OskarSchindler", "Add Up " + scrollDist);
            scrollDist += dy;
        }
    }


    public abstract void show();


    public abstract void hide();

}