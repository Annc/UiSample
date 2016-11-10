package com.example.dou.uisample;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Dou on 2016/4/4.
 */
public class User {
    private String mUserName;
    private String mUserAddress;
    private Drawable mDraable;

    public User(Drawable drawable,String UserName, String UserAddress){
        mDraable = drawable;
        mUserName = UserName;
        mUserAddress = UserAddress;
    }

    public Drawable getDraable() {
        return mDraable;
    }

    public void setDraable(Drawable mDraable) {
        this.mDraable = mDraable;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getUserAddress() {
        return mUserAddress;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public void setUserAdress(String mUserAddress) {
        this.mUserAddress = mUserAddress;
    }
}
