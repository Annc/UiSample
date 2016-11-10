package com.example.dou.uisample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.QuickContactBadge;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity {
    private ProgressBar mProgressBar;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        //showTextView();
        showButton();
        showTogButton();
        showCheckBox();
        showRadioGroup();
        //showSpinner();
        showSpinner2();
        showProgressBar();
        showSeekBar();
        showQuickContactBadge();
        showRatingBar();
        showAutoCompleteTextView();
        showDatePicker();
        EditText editText = (EditText)findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i("SundyLog", "edit" + actionId);
                return false;
            }
        });
        showDatePicker();
    }
    private void showDatePicker(){
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),new DatePicker.OnDateChangedListener(){


                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                        Toast.makeText(MainActivity.this,"Year:" + year +" month:" + monthOfYear + " day" + dayOfMonth, 3000).show();
                    }
                });

    }
    private void showAutoCompleteTextView(){
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        //建立数据源
        String[] counties = new String[]{"China","Congo","Chad","Ecuador","Honduras","Hungary","Ethiopia"};
        //建立adapter,并且绑定数据源
        ArrayAdapter<String> auto = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, counties);
        //绑定UI
        autoCompleteTextView.setAdapter(auto);
    }
    private void showRatingBar(){
        RatingBar rb = (RatingBar)findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Rating" + rating, 3000).show();
            }
        });

    }
    private void showQuickContactBadge(){
        QuickContactBadge qct = (QuickContactBadge)findViewById(R.id.quickContactBadge);
        qct.assignContactFromPhone("15196630289",true);
    }
    private void showSeekBar(){
        mSeekBar = (SeekBar)findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SundyLog","seekbarchange" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("SundyLog","seekbar star" + mSeekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("SundyLog","seekbartop" + mSeekBar.getProgress());
            }
        });
    }
    private void showProgressBar(){
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
    }
    private void showSpinner2(){
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//建立数据源
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(getResources().getDrawable(R.drawable.tu,null),"skeu","chengdu"));
        users.add(new User(getResources().getDrawable(R.drawable.tuone,null),"xiangzi","shenzhen"));
        users.add(new User(getResources().getDrawable(R.drawable.tutwo,null),"lamian","beijing"));
        //建立adapter,连接了数据源
        UserAdapter userAdapter = new UserAdapter(this,users);
        //bind
        spinner.setAdapter(userAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str1 = ((TextView)findViewById(R.id.textView)).getText().toString();
                String str2 = ((TextView)findViewById(R.id.textView2)).getText().toString();
                String str = str1 + str2;
                Toast.makeText(MainActivity.this, str, 3000).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void showSpinner(){
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//建立数据源
        //从XML加载
        String[] myString = getResources().getStringArray(R.array.spinner);
        //自己创建
        String[] myString2 = new String[]{"qwe","erwer","ewrqwer","cxzvsdf"};
//建立adapter,连接了数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myString2);
//绑定adpater到UI
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), 3000).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void showRadioGroup(){
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radiobutton1:
                        Toast.makeText(MainActivity.this, "radiobutton1", 2000).show();
                        break;
                    case R.id.radiobutton2:
                        Toast.makeText(MainActivity.this, "radiobutton2", 2000).show();
                        break;
                    case R.id.radiobutton3:
                        Toast.makeText(MainActivity.this, "radiobutton3", 2000).show();
                        break;
                    default:
                        break;
                }

            }
        });

    }
    private void showCheckBox(){
        CheckBox mCheckBox = (CheckBox)findViewById(R.id.checkBox);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //实现方式和toggleButton一样
            }
        });

    }
    private void showTogButton(){
        final ToggleButton mToggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /*toggleButton的代码实现方式
                if(isChecked){
                    mToggleButton.setBackgroundResource(R.drawable.on);
                    Toast.makeText(MainActivity.this, "开", 2000).show();
                }
                else {
                    mToggleButton.setBackgroundResource(R.drawable.off);
                    Toast.makeText(MainActivity.this, "关", 2000).show();
                }
                */
                //toggleButton的xml实现方式
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "change", 2000);
                }
            }
        });
    }

    private void showButton(){
        Button mButton1 = (Button)findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SundyLog","clicked");
                mProgressBar.setProgress(mProgressBar.getProgress() + 3);
                if(mProgressBar.getProgress() >= mProgressBar.getMax()){
                    mProgressBar.setProgress(0);
                }
            }
        });

        mButton1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i("SundyLog","Longclicked");
                return true;
            }
        });
    }

    private void showTextView(){

        /*
        Html.ImageGetter imagegetter = new Html.ImageGetter(){

            @Override
            public Drawable getDrawable(String source) {
                if(source != null){
                    BitmapDrawable returnDrawable = (BitmapDrawable)getResources().getDrawable(R.drawable.tu);
                    returnDrawable.setBounds(0,0,returnDrawable.getIntrinsicWidth(),returnDrawable.getIntrinsicHeight());
                    return  returnDrawable;
                }
                else {
                    return null;
                }
            }
        };
        Html.TagHandler tagHandler = new Html.TagHandler(){

            @Override
            public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
                Toast.makeText(MainActivity.this, tag, 2000).show();
            }
        };
        */
        TextView textView1 = (TextView)findViewById(R.id.TextView1);
        //textView1.setText(Html.fromHtml("<b>hello</b><h1>你好</h1><font color=‘#00ff00’>刷你的卡</font><img src='http://www.maiziedu.com/static/images/favicon.ico'>",imagegetter,tagHandler));
        ImageSpan imageSpan = new ImageSpan(MainActivity.this, R.drawable.tu);


        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("#大家好#，今天天气真晴朗，处处好风光，好风光");


        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "你点击了", 3000).show();
            }
        };

        spannableStringBuilder.setSpan(imageSpan,4,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableSpan,0,4, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        textView1.setText(spannableStringBuilder);
    }

}
