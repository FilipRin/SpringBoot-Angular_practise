package com.example.backend.db;

import java.util.List;

import com.example.backend.models.Aktivnost;

public interface AktivnostiRepoInterface {
    public List<Aktivnost> dohvatiAktuelneAktivnosti();

    public List<Aktivnost> dohvatiMojeAktivnosti(String username);

    public boolean promeniStatus(Aktivnost aktivnost);
}
