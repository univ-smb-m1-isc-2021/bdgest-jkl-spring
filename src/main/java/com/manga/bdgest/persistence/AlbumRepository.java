package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album findByIsbn(String isbn);

    Album findByName(String name);


}
