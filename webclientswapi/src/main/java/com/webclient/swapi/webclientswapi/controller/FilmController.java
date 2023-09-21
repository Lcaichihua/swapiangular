package com.webclient.swapi.webclientswapi.controller;

import com.webclient.swapi.webclientswapi.Service.FilmService;
import com.webclient.swapi.webclientswapi.response.dto.Film;
import com.webclient.swapi.webclientswapi.response.dto.ListFilm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/webclient")
public class FilmController {
    @Autowired
    FilmService webClient;

    @GetMapping("/films/{id}")
    public Mono<Film> getEpisodeById(@PathVariable String id){
        return webClient.findFilmById(id);
    }

    @GetMapping("/films")
    public Mono<ListFilm> getAllEpisodes(){
        return webClient.findAllFilms();
    }

}
