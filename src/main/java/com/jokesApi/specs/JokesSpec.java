package com.jokesApi.specs;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import com.jokesApi.config.ConfigurationManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JokesSpec {
    public static RequestSpecification get() {
        var configuration = ConfigurationManager.getConfiguration();

        return new RequestSpecBuilder().
                setBaseUri(configuration.baseURI()).
                setBasePath(configuration.basePath()).
                build();
    }
}
