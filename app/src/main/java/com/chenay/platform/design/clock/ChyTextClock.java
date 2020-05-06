package com.chenay.platform.design.clock;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextClock;

public class ChyTextClock extends TextClock {
    public ChyTextClock(Context context) {
        super(context);
    }

    public ChyTextClock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChyTextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void onDetached() {
        onDetachedFromWindow();
    }

}
