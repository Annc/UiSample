package com.example.dou.uisample;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dou on 2016/4/10.
 */
public class MyExpanableListView extends ExpandableListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        List<HashMap<String,String>> groupData = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> group1 = new HashMap<String,String>();
        group1.put("china", "四川省");
        groupData.add(group1);
        HashMap<String, String> group2 = new HashMap<String,String>();
        group2.put("china", "广东省");
        groupData.add(group2);
        /*
        _map = new HashMap<String,String>();
        _map.put("Adress","Sunndy's Adress");
        groupData.add(_map);
        _map = new HashMap<String,String>();
        _map.put("Adress","Skeu's Adress");
        groupData.add(_map);
        */



        List<List<HashMap<String,String>>> childData = new ArrayList<List<HashMap<String,String>>>();
        List<HashMap<String,String>> childItem1 = new ArrayList<HashMap<String,String>>();
        HashMap<String, String>  child1 = new HashMap<String,String>();
        child1.put("city", "成都");
        HashMap<String, String>  child2 = new HashMap<String,String>();
        child2.put("city", "眉山");
        childItem1.add(child1);
        childItem1.add(child2);
        List<HashMap<String,String>> childItem2 = new ArrayList<HashMap<String,String>>();
        HashMap<String, String>  child3 = new HashMap<String,String>();
        child3.put("city", "广州");
        HashMap<String, String>  child4 = new HashMap<String,String>();
        child4.put("city", "深圳");
        childItem2.add(child3);
        childItem2.add(child4);
        childData.add(childItem1);
        childData.add(childItem2);

        ExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(this,groupData,android.R.layout.simple_expandable_list_item_1,android.R.layout.simple_expandable_list_item_1,new String[]{"china"},new int[]{android.R.id.text1},childData,
                android.R.layout.simple_expandable_list_item_2,android.R.layout.simple_expandable_list_item_2,new String[]{"city"},new int[]{android.R.id.text1});
        //
        setListAdapter(simpleExpandableListAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }

    @Override
    public void onGroupCollapse(int groupPosition) {
        super.onGroupCollapse(groupPosition);
    }

    @Override
    public void onGroupExpand(int groupPosition) {
        super.onGroupExpand(groupPosition);
        Toast.makeText(this,"expand" + groupPosition, 3000).show();
    }
}
