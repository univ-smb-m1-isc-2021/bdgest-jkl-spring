package com.manga.bdgest.persistence;


import com.manga.bdgest.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByPseudo(String pseudo);
}
