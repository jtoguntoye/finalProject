package com.udacity.gradle.builditbigger.backend;

import com.example.jokelibrary.JokeTeller;

/** The object model for the data we are sending through endpoints */
public class JokeBean {
    private JokeTeller jokeTeller;
    private String myData;

    public JokeBean() {
        jokeTeller = new JokeTeller();
    }
    public String getJoke() {
        myData = jokeTeller.getJoke();
        return myData;
    }

    public void setData(String data) {

    }
}