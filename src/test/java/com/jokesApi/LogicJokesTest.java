package com.jokesApi;

import com.jokesApi.clients.GeneralJokesClient;
import com.jokesApi.clients.KnockKnockGeneralJokes;
import com.jokesApi.clients.ProgrammingGeneralJokes;
import com.jokesApi.models.Error;
import com.jokesApi.models.Joke;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicJokesTest extends BaseTest {
    @DataProvider(name = "all-client-provider")
    public Object[][] allClientProviders() {
        return new Object[][]{{new GeneralJokesClient()}, {new ProgrammingGeneralJokes()}, {new KnockKnockGeneralJokes()}};
    }

    @Test(dataProvider = "all-client-provider")
    public void testJokeRandomness(GeneralJokesClient client) {
        var firstJoke = client.getRandomJoke();
        var secondJoke = client.getRandomJoke();
        if (secondJoke.getId().equals(firstJoke.getId())) {
            //in case of very low chance of getting the same value twice,
            //giving the second chance to acquire unique value
            secondJoke = client.getRandomJokeResponse().as(Joke[].class)[0];
        }
        assertThat(firstJoke).isNotEqualTo(secondJoke);
    }

    @Test(dataProvider = "all-client-provider")
    public void testJokeId(GeneralJokesClient client) {
        var initialJoke = client.getRandomJoke();
        var controlJoke = client.getJokeById(initialJoke.getId());
        assertThat(initialJoke).isEqualTo(controlJoke);
    }

    @Test(dataProvider = "all-client-provider")
    public void testErrorHandling(GeneralJokesClient client) {
        var initialJoke = client.getErrorResponse().as(Error.class);

        assertThat(initialJoke.getType()).isEqualTo("error");
        assertThat(initialJoke.getMessage()).isEqualTo("joke not found");
    }
}
