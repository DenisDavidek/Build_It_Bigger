package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokerTeller {

    private ArrayList<String> jokesList = new ArrayList<>();
    private Random random;

    public JokerTeller() {
        addJokes();
        random = new Random();
    }

    public String tellJoke() {

       // int position = random.nextInt(6 - 0 + 1) + 0;
        int position = random.nextInt(jokesList.size()-1);
        return jokesList.get(position);
    }

    public void addJokes() {

        jokesList.add("I named my hard drive \"dat ass\" so once a month my computer asks if I want to 'back dat ass up'.");
        jokesList.add("It's ok computer, I go to sleep after 20 minutes of inactivity too.");
        jokesList.add("Q: What do you call the security outside of a Samsung Store? A: Guardians of the Galaxy.");
        jokesList.add("Any room is a panic room if you've lost your phone in it.");
        jokesList.add("Wifi went down during family dinner tonight. One kid started talking and I didn't know who he was.");
        jokesList.add("My internet is so slow, it's just faster to drive to the Google headquarters and ask them shit in person.");
        jokesList.add("Entered what I ate today into my new fitness app and it just sent an ambulance to my house.");
    }
}
