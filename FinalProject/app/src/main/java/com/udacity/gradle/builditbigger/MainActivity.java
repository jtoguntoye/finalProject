package com.udacity.gradle.builditbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidlibrary.JokeActivity;
import com.example.jokelibrary.JokeTeller;


public class MainActivity extends AppCompatActivity {
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void tellJoke(View view) {
        Intent startJokeActivity = new Intent(this, JokeActivity.class);
        JokeTeller jokeTeller = new JokeTeller();
        joke = jokeTeller.getJoke();
        startJokeActivity.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(startJokeActivity);
        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }


}
