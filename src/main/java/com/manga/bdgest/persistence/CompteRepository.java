package com.manga.bdgest.persistence;


import com.manga.bdgest.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByPseudo(String pseudo);

    Compte findByEmail(String email);

    Boolean existsByPseudo(String pseudo);

    Boolean existsByEmail(String email);

    Compte findByPseudoOrEmail(String pseudo, String email);
}
