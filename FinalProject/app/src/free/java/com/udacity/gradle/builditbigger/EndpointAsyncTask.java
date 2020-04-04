package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.MyEndpoint;

import java.io.IOException;

public class EndpointAsyncTask  extends AsyncTask<Pair<Context, String>, Void, String> {
    private Context context;
    private static myApi myEndpoint;


    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {

        if (myEndpoint == null) {
      /*      myEndpoint.Builder builder = new MyEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                        throws IOException {
                    abstractGoogleClientRequest.setDisableGZipContent(true);
                }
            });
            mJokeApi = builder.build();
        }*/

        }
        return null;
    }
}