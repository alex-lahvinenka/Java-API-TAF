package com.jokesApi;

import com.jokesApi.clients.GeneralJokesClient;
import com.jokesApi.clients.KnockKnockGeneralJokes;
import com.jokesApi.clients.ProgrammingGeneralJokes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContractJokesTest extends BaseTest {
    @DataProvider(name = "all-client-provider")
    public Object[][] allClientProviders() {
        return new Object[][]{{new GeneralJokesClient()}, {new ProgrammingGeneralJokes()}, {new KnockKnockGeneralJokes()}};
    }

    @Test(dataProvider = "all-client-provider")
    public void testSchema(GeneralJokesClient client) {
        client.getRandomJokeResponse()
                .then().body(matchesJsonSchemaInClasspath("schemas/joke-schema-v1.json"));
    }

    @Test(dataProvider = "all-client-provider")
    public void testJokeSchema(GeneralJokesClient client) {
        client.getErrorResponse().then().body(matchesJsonSchemaInClasspath("schemas/error-schema-v1.json"));
    }
}
