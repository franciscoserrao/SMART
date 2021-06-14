package com.example.avjindersinghsekhon.minimaltodo.Utility;
import com.example.avjindersinghsekhon.minimaltodo.R;
import android.content.res.TypedArray;
import android.content.Context;
public class Utils {
    public static int getToolbarHeight(android.content.Context context) {
        final android.content.res.TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(new int[]{ com.example.avjindersinghsekhon.minimaltodo.R.attr.actionBarSize });
        int toolbarHeight = ((int) (styledAttributes.getDimension(0, 0)));
        styledAttributes.recycle();
        return toolbarHeight;
    }

}