package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Serie findByTitre(String titre);
}
