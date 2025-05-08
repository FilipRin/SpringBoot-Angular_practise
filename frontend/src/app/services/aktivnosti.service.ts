import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Aktivnost } from '../../models/aktivnost';

@Injectable({
  providedIn: 'root'
})
export class AktivnostiService {

  url = 'http://localhost:8080/aktivnosti';

  constructor(private http: HttpClient) { }

  aktuelneAktivnosti() {
    return this.http.get<Aktivnost[]>(`${this.url}/aktuelne`);
  }

  mojeAktivnosti(username: string) {
    return this.http.get<Aktivnost[]>(`${this.url}/moje/${username}`);
  }

  promenaStatusa(aktivnost: Aktivnost) {
    return this.http.post<boolean>(`${this.url}/promeniStatus`, aktivnost);
  }
}
