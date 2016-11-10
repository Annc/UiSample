package com.example.dou.uisample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by Dou on 2016/4/12.
 */
public class GalleryActivity extends Activity implements ViewSwitcher.ViewFactory {
    private ImageSwitcher imageSwitcher;
    private int mIndex = 0;
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
        setContentView(R.layout.gallerylayout);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswtich1);
        imageSwitcher.setFactory(this);
        imageSwitcher.setImageResource(mImages[mIndex]);

        Gallery gallery1 = (Gallery)findViewById(R.id.gallery1);
        gallery1.setAdapter(new ImageAdapter());

        gallery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GalleryActivity.this, "Gallery" + position, 3000).show();
                imageSwitcher.setImageResource(mImages[position]);
            }
        });
    }

    @Override
    public View makeView() {
        return new ImageView(this);
    }

    class ImageAdapter extends BaseAdapter {

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
            ImageView imageView = new ImageView(GalleryActivity.this);
            imageView.setImageResource(mImages[position]);
            return imageView;
        }
    }
}
