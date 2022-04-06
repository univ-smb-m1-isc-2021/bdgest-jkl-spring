package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    Auteur findByFullname(String nom, String prenom);

}
