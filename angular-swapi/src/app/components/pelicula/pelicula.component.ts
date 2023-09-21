import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject, takeUntil } from 'rxjs';
import { FilmService } from 'src/app/services/film.service';

@Component({
  selector: 'app-pelicula',
  templateUrl: './pelicula.component.html',
  styleUrls: ['./pelicula.component.css']
})
export class PeliculaComponent implements OnInit, OnDestroy {

  film: any;
  spiner = true;
  unsubscribe$ = new Subject();

  constructor(private activatedRoute: ActivatedRoute, public filmService: FilmService) {
    
  }

  ngOnDestroy(): void {
    this.unsubscribe$.next(true);
    this.unsubscribe$.complete();
  }

  ngOnInit(){

    this.activatedRoute.params.pipe(takeUntil(this.unsubscribe$)).subscribe((film: any) => {
  
      const id = film.id;
      console.log(id);
      this.spiner = true;

      this.filmService.getFilmById(id).subscribe((resp: any) => {
        console.log(resp);
        this.film = resp;
        this.spiner = false;
      })
    })
  }

}
