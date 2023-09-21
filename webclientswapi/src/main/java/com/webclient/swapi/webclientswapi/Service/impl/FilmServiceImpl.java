package com.webclient.swapi.webclientswapi.Service.impl;

import com.webclient.swapi.webclientswapi.Service.FilmService;
import com.webclient.swapi.webclientswapi.response.dto.Film;
import com.webclient.swapi.webclientswapi.response.dto.ListFilm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService {
    private  final org.springframework.web.reactive.function.client.WebClient client;

    private static final String ERRO_MSG = "valida datos";

    public FilmServiceImpl(org.springframework.web.reactive.function.client.WebClient.Builder builder){
        client = builder.baseUrl("https://swapi.dev/api/").build();
    }

    public Mono<Film> findFilmById(String id){
        log.info("lista por id", id);
        return client
                .get()
                .uri("/films/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException(ERRO_MSG)))
                .bodyToMono(Film.class);
    }

    public Mono<ListFilm> findAllFilms(){
        log.info("Lista de peliculas");
        return client
                .get()
                .uri("/films/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException(ERRO_MSG)))
                .bodyToMono(ListFilm.class);
    }
}
