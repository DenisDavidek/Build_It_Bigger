package com.udacity.gradle.builditbigger.paid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.ProgressBarVisibilityHandler;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity implements ProgressBarVisibilityHandler {

    static ProgressBar loadingProgressBar;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        Toast.makeText(getApplicationContext(), "free variant", Toast.LENGTH_SHORT).show();
/*        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        requestNewInterstitialAd();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                requestNewInterstitialAd();
                getJokes();
                Log.e("AD LISTENER ", "called");
            }
        });*/
    }

    public void requestNewInterstitialAd() {
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(request);
    }

    public void getJokes() {
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(getApplicationContext(), "1"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    protected void tellJoke(View view) {

    /*    if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

            getJokes();
        }*/
getJokes();
    }

    @Override
    public void showProgressBar() {
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        loadingProgressBar.setVisibility(View.INVISIBLE);
    }

}

