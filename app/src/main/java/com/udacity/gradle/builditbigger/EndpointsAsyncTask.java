package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.denis.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import sk.denis.davidek.androidjokedisplay.JokeDisplayActivity;

/**
 * Created by denis on 07.07.2017.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressBarVisibilityHandler progressBarVisibilityHandler;

    public EndpointsAsyncTask(ProgressBarVisibilityHandler ProgressBarVisibilityHandler) {
        this.progressBarVisibilityHandler = ProgressBarVisibilityHandler;
    }

    @Override
    protected void onPreExecute() {
        progressBarVisibilityHandler.showProgressBar();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        // String name = params[0].second;

        try {
            return myApiService.sayHi().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        progressBarVisibilityHandler.hideProgressBar();
        if (result != null) {
            launchJokeActivity(result);
        }
        //  Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }


    public void launchJokeActivity(String result) {

        String intentKey = context.getString(R.string.key_joke);
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(intentKey, result);
        context.startActivity(intent);
    }
}
