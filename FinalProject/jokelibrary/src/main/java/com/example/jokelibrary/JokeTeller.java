package com.example.jokelibrary;

import java.util.Random;

public class JokeTeller {
    private String[] jokes;
    private Random random;

    public JokeTeller(){
        jokes = new String[3];
        jokes[0] = "What is the carpet telling the floor? A: I've got you covered";
        jokes[1] = "Q: What do you call a two-humped camel? A: Pregnant.";
        jokes[2] = "Why do Java developers wear glasses? Because they can't C#";
        random = new Random();
    }

    public String getRandomJokes(){
        return jokes[random.nextInt(jokes.length)];
    }
    public String getJoke(){
        return "crack your ribs";
    }
}
