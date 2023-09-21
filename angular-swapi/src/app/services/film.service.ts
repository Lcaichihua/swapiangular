import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Film } from '../interfaces/film';


@Injectable({
  providedIn: 'root'
})
export class FilmService {

  //apiUrl = 'https://swapi.dev/api/';
  apiUrl = 'http://localhost:8090/webclient';
  constructor(public http: HttpClient) { }

  getAllFilm(){
  	return this.http.get<Film>(`${this.apiUrl}/films`);  	
  }

  getFilmById(id: string){
  	return this.http.get(`${this.apiUrl}/films/${id}`);  	
  }

}
