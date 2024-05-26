package com.jokesApi.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Joke {
    private Integer id;
    private String type;
    private String setup;
    private String punchline;
}