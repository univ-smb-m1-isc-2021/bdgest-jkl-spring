package com.manga.bdgest.persistence;


import com.manga.bdgest.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Compte findByPseudo(String pseudo);

    void delete(Long id);
}
