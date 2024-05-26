package com.jokesApi.clients;

import com.jayway.restassured.response.Response;
import com.jokesApi.models.Joke;
import com.jokesApi.specs.JokesSpec;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.nio.charset.Charset;
import java.util.Random;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

@NoArgsConstructor
@Log4j2
public class GeneralJokesClient {

    @Getter
    private String path = "";

    protected GeneralJokesClient(String s) {
        path = s;
    }

    public Response getRandomJokeResponse() {
        log.info("Getting a random joke");
        return given()
                .spec(JokesSpec.get())
                .when().get(path.concat("/random"))
                .then().extract().response();
    }

    public Response getJokeResponseById(int id) {
        log.info(String.format("Getting a joke by specifed id {%s}", id));
        return getJokeResponse(String.valueOf(id));
    }

    public Response getJokeResponse(String value) {
        log.info(String.format("Getting a joke by specifed value {%s}", value));
        return given()
                .spec(JokesSpec.get())
                .when().get(String.format("/%s", value))
                .then().extract().response();
    }

    public Response getErrorResponse() {
        return getJokeResponse(String.valueOf((char) ('A' + new Random().nextInt(26))));
    }

    public Joke getJokeById(int id) {
        return getJokeResponseById(id).as(Joke.class);
    }

    public Joke getRandomJoke() {
        return getRandomJokeResponse().as(Joke.class);
    }
}
