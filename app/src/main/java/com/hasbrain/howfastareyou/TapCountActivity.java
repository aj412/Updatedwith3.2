package com.hasbrain.howfastareyou;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TapCountActivity extends AppCompatActivity {

    public static final int TIME_COUNT = 10000; //10s
    public final static String EXTRA_DD = "";
    public static final String EXTRA_PP = "";
    @Bind(R.id.bt_tap)
    Button btTap;
    @Bind(R.id.bt_start)
    Button btStart;
    @Bind(R.id.tv_time)
    Chronometer tvTime;

    private long startTime;
    int x, s;
    private long btnTime;

   List<Long> timeArray = new ArrayList<>();
    private GoogleApiClient client;

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
                    timeArray.add(System.currentTimeMillis()); //step1
                    long[] array = new long[timeArray.size()];
                    for(int i=0;i<timeArray.size();i++){
                        array[i] = timeArray.get(i);
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    TapCountResultFragment f1 = new TapCountResultFragment();

                    Bundle bundle = new Bundle();

                    bundle.putLongArray("time",array ); //step 2
                    bundle.putInt(EXTRA_DD, s);
                    f1.setArguments(bundle);
                    fragmentTransaction.replace(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                }
            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        x = s;


    }

    private void pauseTapping() {
        btTap.setEnabled(false);
        tvTime.stop();
        btTap.setEnabled(false);
        btStart.setEnabled(true);

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TapCount Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.hasbrain.howfastareyou/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TapCount Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.hasbrain.howfastareyou/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
