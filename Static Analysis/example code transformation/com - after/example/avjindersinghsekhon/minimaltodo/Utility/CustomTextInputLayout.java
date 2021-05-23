package com.example.avjindersinghsekhon.minimaltodo.Utility;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.support.v4.view.ViewCompat;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.EditText;
public class CustomTextInputLayout extends android.support.design.widget.TextInputLayout {
    private boolean mIsHintSet;

    private java.lang.CharSequence mHint;

    public CustomTextInputLayout(android.content.Context context) {
        super(context);
    }


    public CustomTextInputLayout(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }


    @java.lang.Override
    public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) {
        if (child instanceof android.widget.EditText) {
            // Since hint will be nullify on EditText once on parent addView, store hint value locally
            mHint = ((android.widget.EditText) (child)).getHint();
        }
        super.addView(child, index, params);
    }


    @java.lang.Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if ((!mIsHintSet) && android.support.v4.view.ViewCompat.isLaidOut(this)) {
            // We have to reset the previous hint so that equals check pass
            setHint(null);
            // In case that hint is changed programatically
            java.lang.CharSequence currentEditTextHint = getEditText().getHint();
            if ((currentEditTextHint != null) && (currentEditTextHint.length() > 0)) {
                mHint = currentEditTextHint;
            }
            setHint(mHint);
            mIsHintSet = true;
        }
    }

}