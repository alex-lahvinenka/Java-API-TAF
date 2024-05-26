package com.jokesApi.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Error {
    private String type;
    private String message;
}
