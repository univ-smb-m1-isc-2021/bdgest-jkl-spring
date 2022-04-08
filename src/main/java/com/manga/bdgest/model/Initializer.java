package com.manga.bdgest.model;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Initializer {

    private final  AlbumRepository repository;

    public Initializer(AlbumRepository repository){
        this.repository = repository;
    }

    @PostConstruct
    public void initialize(){

        repository.deleteAllInBatch();

        if(repository.findAll().isEmpty()){
            repository.saveAndFlush(new Album("titre", "serie", "auteur", "numero"));
        }
    }
}
