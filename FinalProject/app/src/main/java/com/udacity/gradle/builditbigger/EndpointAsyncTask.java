package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.androidlibrary.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.JokeBean;


import java.io.IOException;

public class EndpointAsyncTask  extends AsyncTask<Pair<Context, String>, Void, String> {
    private Context context;
    private static MyApi myEndpoint;
    private String mResult;

    public EndpointAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {

        if (myEndpoint == null) {
           MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                        throws IOException {
                    abstractGoogleClientRequest.setDisableGZipContent(true);
                }
            });
            myEndpoint = builder.build();
        } try {
            return myEndpoint.putJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mResult = s;

        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        Intent startJokeActivity = new Intent(context, JokeActivity.class);

        startJokeActivity.putExtra(JokeActivity.JOKE_KEY, mResult);
        context.startActivity(startJokeActivity);
    }
}