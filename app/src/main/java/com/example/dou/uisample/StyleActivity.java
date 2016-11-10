package com.example.dou.uisample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dou on 2016/4/21.
 */
public class StyleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SundyButton sundyButton = new SundyButton(this);
        setContentView(sundyButton);
        sundyButton.setOnIconKeyDownListener(new SundyButton.OnIconKeyDownListener() {
            @Override
            public void onKeyDown(String KeyObject) {
                Toast.makeText(StyleActivity.this,"sunndyButton" + KeyObject, 3000).show();
            }
        });
        /*setContentView(R.layout.style);

        TextView textView = (TextView)findViewById(R.id.textView3);*/

    }
}
