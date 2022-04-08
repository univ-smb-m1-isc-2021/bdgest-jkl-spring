package com.manga.bdgest.model;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository repository;

    public AlbumService(AlbumRepository repository){
        this.repository = repository;
    }

    public List<Album> getAll(){
        return repository.findAll();
    }

    public Optional<Album> getById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        Optional<Album> album = repository.findById(id);
        album.ifPresent(repository::delete);
    }

    public void create(String titre, String serie, String auteur, String numero){
        repository.save(new Album(titre,serie,auteur,numero));
    }
}
