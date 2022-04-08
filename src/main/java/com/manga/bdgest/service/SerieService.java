package com.manga.bdgest.service;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Serie;
import com.manga.bdgest.persistence.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final SerieRepository repository;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<Serie> getAll() {
        return repository.findAll();
    }

    public Optional<Serie> getById(Long id){
        return repository.findById(id);
    }


    public void create(Serie serie) {
        repository.save(serie);
    }

    public void delete(Long id) {
        Optional<Serie> serie = repository.findById(id);
        serie.ifPresent(repository::delete);
    }



}
