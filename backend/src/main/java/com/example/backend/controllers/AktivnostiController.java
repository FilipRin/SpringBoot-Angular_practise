package com.example.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.AktivnostiRepo;
import com.example.backend.models.Aktivnost;

@RestController
@RequestMapping("/aktivnosti")
@CrossOrigin(origins = "http://localhost:4200")
public class AktivnostiController {

    
    @GetMapping("/aktuelne")
    public List<Aktivnost> dohvatiAktuelneAktivnosti() {
        return new AktivnostiRepo().dohvatiAktuelneAktivnosti();
    }

    @GetMapping("/moje/{username}")
    public List<Aktivnost> dohvatiNapravljeneAktivnosti(@PathVariable String username) {
        return new AktivnostiRepo().dohvatiMojeAktivnosti(username);
    }

    @PostMapping("/promeniStatus")
    public boolean promeniStatus(@RequestBody Aktivnost aktivnost) {
        return new AktivnostiRepo().promeniStatus(aktivnost);
    }
}
