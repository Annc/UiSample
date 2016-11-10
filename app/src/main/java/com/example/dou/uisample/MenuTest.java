package com.example.dou.uisample;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Dou on 2016/4/20.
 */
public class MenuTest extends ListActivity {
    private String[] strs = new String[]{"AlterDialog","CustomDialog","QitaDialog"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,strs);
        setListAdapter(adapter);

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position == 0) {

            AlertDialog dialog = new AlertDialog.Builder(MenuTest.this)
                                    .setTitle("hello Dialog")
                                    //.setIcon(R.drawable.tou)
                                    //.setMessage("Do you want to exit?")
                                    .setSingleChoiceItems(strs,-1, new OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(MenuTest.this,""+which,3000).show();
                                        }
                                    })
                                    .setPositiveButton("YES", new OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            MenuTest.this.finish();
                                        }
                                    })
                                    .setNegativeButton("NO", new OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    }).show();
            //dialog.show();
        }
        else if(position == 1){
            Dialog dialogFree = new Dialog(this);
            dialogFree.setContentView(R.layout.user_item);
            dialogFree.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        /*menu.add(1,1,1,"hello");
        menu.add(1,2,2,"world");
        menu.add(1,3,3,"!");
        menu.addSubMenu("Sunndy");
        menu.addSubMenu("you");
        */
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
