package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    List<Auteur> findByNom(String nom);

    List<Auteur> findByPrenom(String prenom);

    List<Auteur> findByNomAndPrenom(String nom, String prenom);
}
