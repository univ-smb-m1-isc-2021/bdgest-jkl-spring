package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    Album findByTitre(String titre);

}
