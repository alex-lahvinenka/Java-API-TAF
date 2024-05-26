package com.jokesApi.clients;

import com.jokesApi.models.Joke;

public class ProgrammingGeneralJokes extends GeneralJokesClient {

    public ProgrammingGeneralJokes() {
        super("/programming");
    }

    public Joke getRandomJoke() {
        return getRandomJokeResponse().as(Joke[].class)[0];
    }
}
