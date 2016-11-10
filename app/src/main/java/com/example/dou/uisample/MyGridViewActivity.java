package com.example.dou.uisample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Dou on 2016/4/10.
 */
public class MyGridViewActivity extends Activity {
    private int[] mImages = new int[]{
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        //
        //
        //
        gridView.setAdapter(new ImageAdapter());
    }
    class ImageAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public Object getItem(int position) {
            return mImages[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(MyGridViewActivity.this);
            imageView.setImageResource(mImages[position]);
            return imageView;
        }
    }
}
