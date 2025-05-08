import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { KorisniciService } from '../../services/korisnici.service';
import { FormsModule } from '@angular/forms';
import { AppRoutes } from '../../app.routes';
import { HttpClient } from '@angular/common/http';
import { Aktivnost } from '../../../models/aktivnost';
import { Korisnik } from '../../../models/korisnik';
import { AktivnostiService } from '../../services/aktivnosti.service';

@Component({
  selector: 'app-student',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css',
  providers:[KorisniciService,HttpClient]
})
export class StudentComponent {
  ulogovan: Korisnik = new Korisnik();
  aktuelneAktivnosti: Aktivnost[] = [];

  constructor(private http: HttpClient, private router: Router, private aktivnostiServis: AktivnostiService) { }

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.aktivnostiServis.aktuelneAktivnosti().subscribe(data => {
        this.aktuelneAktivnosti = data;
      });
    }
  }

  prijavi(aktivnost: Aktivnost) {
    // Ispravnije bi bilo da prosledjujemo aktivnost, tj. njen identifikator kao parametar,
    // ali s obzirom na to da nam na narednoj strani trebaju i podaci o aktivnosti,
    // kako ne bismo vise puta bespotrebno dohvatali iz baze podatke,
    // sacuvacemo podatke o aktivnosti u localStorage objektu
    localStorage.setItem("selektovana", JSON.stringify(aktivnost));
    this.router.navigate(['/prijava']);
  }

}
