import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Korisnik } from '../../models/korisnik';

@Injectable({
  providedIn: 'root'
})
export class KorisniciService {

  url = 'http://localhost:8080/korisnici';

  constructor(private http:HttpClient) { }

  prijava(username: string, password: string, tip: string) {
    const data = {
      korisnicko_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }

}
