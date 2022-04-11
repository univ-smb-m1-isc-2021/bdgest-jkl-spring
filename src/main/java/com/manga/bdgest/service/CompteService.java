package com.manga.bdgest.service;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Compte;
import com.manga.bdgest.persistence.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompteService {

    private final CompteRepository repository;

    public CompteService(CompteRepository repository) {
        this.repository = repository;
    }

    public List<Compte> getAll() {
        return repository.findAll();
    }

    public Optional<Compte> getById(Long id){
        return repository.findById(id);
    }

    
    public void create(Compte compte) {
        repository.save(compte);
    }

    public void delete(Long id) {
        Optional<Compte> compte = repository.findById(id);
        compte.ifPresent(repository::delete);
    }

    public Compte getByEmailOrPseudo(String email) {
        return repository.findByPseudoOrEmail(email,email);
    }
}
