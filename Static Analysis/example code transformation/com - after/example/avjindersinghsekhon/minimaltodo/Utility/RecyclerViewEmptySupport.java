package com.example.avjindersinghsekhon.minimaltodo.Utility;
import android.util.AttributeSet;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.content.Context;
public class RecyclerViewEmptySupport extends android.support.v7.widget.RecyclerView {
    private android.view.View emptyView;

    private android.support.v7.widget.RecyclerView.AdapterDataObserver observer = new android.support.v7.widget.RecyclerView.AdapterDataObserver() {
        @java.lang.Override
        public void onChanged() {
            showEmptyView();
        }


        @java.lang.Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            showEmptyView();
        }


        @java.lang.Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            showEmptyView();
        }

    };

    public RecyclerViewEmptySupport(android.content.Context context) {
        super(context);
    }


    public void showEmptyView() {
        android.support.v7.widget.RecyclerView.Adapter<?> adapter = getAdapter();
        if ((adapter != null) && (emptyView != null)) {
            if (adapter.getItemCount() == 0) {
                emptyView.setVisibility(android.view.View.VISIBLE);
                this.setVisibility(android.view.View.GONE);
            } else {
                emptyView.setVisibility(android.view.View.GONE);
                this.setVisibility(android.view.View.VISIBLE);
            }
        }
    }


    public RecyclerViewEmptySupport(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }


    public RecyclerViewEmptySupport(android.content.Context context, android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @java.lang.Override
    public void setAdapter(android.support.v7.widget.RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
            observer.onChanged();
        }
    }


    public void setEmptyView(android.view.View v) {
        emptyView = v;
    }

}