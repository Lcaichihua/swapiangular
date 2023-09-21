import { People } from './people';

export interface Film {
  results: Result[];
}

export interface Result {
  title: string;
  episode_id: string;
  opening_crawl: string;
  director: string;
  producer: string;
  release_date: string;
  characters: People[];
  url: string;
}
