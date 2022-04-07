package com.manga.bdgest.service;


import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.persistence.AuteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService {

    private final AuteurRepository repository;

    public AuteurService(AuteurRepository repository) {
        this.repository = repository;
    }

    public List<Auteur> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Optional<Auteur> auteur = repository.findById(id);
        auteur.ifPresent(repository::delete);
    }

    public void create(Auteur auteur) {
        repository.save(auteur);
    }
}
