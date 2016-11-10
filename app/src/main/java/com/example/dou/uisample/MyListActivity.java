package com.example.dou.uisample;


import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dou on 2016/4/8.
 */
public class MyListActivity extends ListActivity {
    private EditText mEditText;
    private List listItem;
    private ArrayAdapter<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylist);
        disPlay();
        //showCursorAdapter();
    }

    private void disPlay(){
        listItem = new ArrayList<String>();
        //建立adapter,并且绑定数据源
        list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listItem);
        //绑定UI
        setListAdapter(list);

        mEditText = (EditText)findViewById(R.id.editTextgt);
        mEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //listItem.add(mEditText.getText().toString());
                    //setListAdapter(list);
                    //list.notifyDataSetChanged();
                    list.add(mEditText.getText().toString());
                    mEditText.setText(null);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
                }
                return false;
            }
        });
    }
    private void showCursorAdapter(){
        Cursor cursor = getContentResolver().query(Contacts.Phones.CONTENT_URI, null, null, null, null);
        SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(this,R.layout.user_item, cursor, new String[]{Contacts.Phones.NAME, Contacts.Phones.NUMBER},new int[]{R.id.textView,R.id.textView2});
        setListAdapter(simpleAdapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listItem.remove(position);
        list.notifyDataSetChanged();

    }
}
