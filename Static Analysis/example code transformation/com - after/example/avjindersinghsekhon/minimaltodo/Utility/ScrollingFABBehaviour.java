package com.example.avjindersinghsekhon.minimaltodo.Utility;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.content.Context;
public class ScrollingFABBehaviour extends android.support.design.widget.CoordinatorLayout.Behavior<android.support.design.widget.FloatingActionButton> {
    private int toolbarHeight;

    private static boolean scrolledUp = false;

    private static boolean scrolledDown = false;

    public ScrollingFABBehaviour(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.toolbarHeight = com.example.avjindersinghsekhon.minimaltodo.Utility.Utils.getToolbarHeight(context);
    }


    @java.lang.Override
    public boolean layoutDependsOn(android.support.design.widget.CoordinatorLayout parent, android.support.design.widget.FloatingActionButton child, android.view.View dependency) {
        return (dependency instanceof android.support.design.widget.Snackbar.SnackbarLayout) || (dependency instanceof android.support.v7.widget.Toolbar);
        // return (dependency instanceof Snackbar.SnackbarLayout);
    }


    @java.lang.Override
    public boolean onDependentViewChanged(android.support.design.widget.CoordinatorLayout parent, final android.support.design.widget.FloatingActionButton child, android.view.View dependency) {
        if (dependency instanceof android.support.design.widget.Snackbar.SnackbarLayout) {
            float finalVal = ((float) (parent.getHeight())) - dependency.getY();
            child.setTranslationY(-finalVal);
        }
        // 
        // if(dependency instanceof RecyclerView){
        // RecyclerView view = (RecyclerView)dependency;
        // CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)child.getLayoutParams();
        // int fabBottomMargin = lp.bottomMargin;
        // final int distanceToScroll = child.getHeight() + fabBottomMargin;
        // 
        // final RecyclerView.LayoutManager rlp = (RecyclerView.LayoutManager)view.getLayoutManager();
        // Log.d("OskarSchindler", "Height: "+rlp.getHeight());
        // 
        // 
        // 
        // }
        if (dependency instanceof android.support.v7.widget.Toolbar) {
            android.support.design.widget.CoordinatorLayout.LayoutParams lp = ((android.support.design.widget.CoordinatorLayout.LayoutParams) (child.getLayoutParams()));
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = child.getHeight() + fabBottomMargin;
            float finalVal = dependency.getY() / ((float) (toolbarHeight));
            float distFinal = (-distanceToScroll) * finalVal;
            child.setTranslationY(distFinal);
        }
        return true;
    }

}