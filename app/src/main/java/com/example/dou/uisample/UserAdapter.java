package com.example.dou.uisample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dou on 2016/4/4.
 */
public class UserAdapter extends BaseAdapter {

    List<User> mUsers;
    Context mContext;

    public UserAdapter(Context context, List<User> users){
        mUsers = users;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, null);
        TextView textView1 = (TextView)convertView.findViewById(R.id.textView);
        TextView textView2 = (TextView)convertView.findViewById(R.id.textView2);

        Drawable drawable = mUsers.get(position).getDraable();
        drawable.setBounds(0,0,50,50);
        textView1.setCompoundDrawables(drawable,null,null,null);
        textView1.setText(mUsers.get(position).getUserName());
        textView2.setText(mUsers.get(position).getUserAddress());

        return convertView;
    }
}
