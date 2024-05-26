package com.jokesApi.clients;

import com.jokesApi.models.Joke;

public class KnockKnockGeneralJokes extends GeneralJokesClient {

    public KnockKnockGeneralJokes() {
        super("/knock-knock");
    }

    public Joke getRandomJoke() {
        return getRandomJokeResponse().as(Joke[].class)[0];
    }
}
