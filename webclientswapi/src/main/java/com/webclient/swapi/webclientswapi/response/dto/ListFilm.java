package com.webclient.swapi.webclientswapi.response.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListFilm {
    private List<Film> results;
}
