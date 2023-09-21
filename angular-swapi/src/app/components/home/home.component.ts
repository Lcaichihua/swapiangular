import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subject, takeUntil } from 'rxjs';
import { Film } from 'src/app/interfaces/film';
import { FilmService } from 'src/app/services/film.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy  {

  spiner = true;
  listFilms: any;
  unsubscribe$ = new Subject();

  constructor(public filmService: FilmService) {
    
  }

  ngOnInit() {
  	this.obtenerFilms();
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next(true);
    this.unsubscribe$.complete();
  }

  obtenerFilms(){
    this.spiner = true;
    this.filmService.getAllFilm().pipe(takeUntil(this.unsubscribe$)).subscribe((resp: Film) => {    
      
      this.listFilms = resp.results.filter(data => Number(this.obtenerIdPelicula(data.url)) < 7);   
  
      this.spiner = false;
      console.log(this.listFilms);
   
        
      
    }, err => {
      console.log(err);
    })
  }

  obtenerIdPelicula(cadena: string){
    return cadena.substring(28,cadena.length - 1);
  }

}
