package com.manga.bdgest.service;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.persistence.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public List<Album> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Optional<Album> album = repository.findById(id);
        album.ifPresent(repository::delete);
    }

    public Album getAlbum(Long id) {
        return repository.findById(id).get();
    }

    public Album create(Album album) {
        return repository.save(album);
    }
}
