package com.hasbrain.howfastareyou;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TapCountActivity extends AppCompatActivity {

    public static final int TIME_COUNT = 10000; //10s
  public final static String EXTRA_DD = "" ;
    public static final String EXTRA_PP = "" ;
    @Bind(R.id.bt_tap)
    Button btTap;
    @Bind(R.id.bt_start)
    Button btStart;
    @Bind(R.id.tv_time)
    Chronometer tvTime;

    private long startTime;
    int x, s;
    private long btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.bind(this);
        tvTime.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - startTime >= TIME_COUNT) {
                    pauseTapping();
                  // btnTime =  Calendar.get(Calendar.HOUR_OF_DAY);
                    Date f = new Date();
                    btnTime =  f.getTime();
                   // btnTime = btTap.getDrawingTime();
                   long[] mylist = new long[]{btnTime};
                    //this adds an element to the list.

                    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    TapCountResultFragment f1 = new TapCountResultFragment();

                    Bundle bundle = new Bundle();
                    bundle.putLongArray("time", mylist);
                    bundle.putInt(EXTRA_DD, s);
                    bundle.putLong(EXTRA_PP,btnTime);
                    f1.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings) {
            Intent showSettingsActivity = new Intent(this, SettingsActivity.class);
            startActivity(showSettingsActivity);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.bt_start)
    public void onStartBtnClicked(View v) {
        startTapping();




//create an arraylist and add data through there.
    }

    @OnClick(R.id.bt_tap)
    public void onTapBtnClicked(View v) {

    }

    private void startTapping() {
        startTime = SystemClock.elapsedRealtime();
        tvTime.setBase(SystemClock.elapsedRealtime());
        tvTime.start();
        btTap.setEnabled(true);
        btStart.setEnabled(false);
       x = x++;
        x=s;


    }

    private void pauseTapping() {
        btTap.setEnabled(false);
        tvTime.stop();
        btTap.setEnabled(false);
        btStart.setEnabled(true);

    }
}
