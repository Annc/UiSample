package com.example.dou.uisample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * Created by Dou on 2016/4/21.
 */
public class SundyButton extends Button {
    private OnIconKeyDownListener mOnIconKeyDownListener;

    interface OnIconKeyDownListener{
        public void onKeyDown(String KeyObject);
    }
    public SundyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public SundyButton(Context context) {
        super(context);
    }
    public void setOnIconKeyDownListener(OnIconKeyDownListener onIconKeyDownListener){
        mOnIconKeyDownListener = onIconKeyDownListener;

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(mOnIconKeyDownListener != null){
           mOnIconKeyDownListener.onKeyDown("hello sunndy");
            onIconKeyDown("hello");
        }
        return super.onKeyDown(keyCode, event);
    }
    protected void onIconKeyDown(String KeyObject){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(5,5,25,25,paint);
    }
}
