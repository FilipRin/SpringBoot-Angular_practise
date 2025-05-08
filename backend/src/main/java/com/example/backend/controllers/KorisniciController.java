package com.example.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.db.KorisniciRepo;
import com.example.backend.models.Korisnik;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/korisnici")
@CrossOrigin(origins = "http://localhost:4200")
public class KorisniciController {
    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik kor) {
        return new KorisniciRepo().prijava(kor);
    }
    
}
