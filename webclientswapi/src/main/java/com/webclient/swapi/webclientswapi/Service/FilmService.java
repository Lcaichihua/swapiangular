package com.webclient.swapi.webclientswapi.Service;

import com.webclient.swapi.webclientswapi.response.dto.Film;
import com.webclient.swapi.webclientswapi.response.dto.ListFilm;
import reactor.core.publisher.Mono;

public interface FilmService {
    public Mono<Film> findFilmById(String id);
    public Mono<ListFilm> findAllFilms();
}
