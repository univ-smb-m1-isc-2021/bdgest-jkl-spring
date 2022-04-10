package com.manga.bdgest.controller;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Compte;
import com.manga.bdgest.service.CompteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/compte")
public class CompteController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CompteService compteService;

    public CompteController(CompteService compteService){
        this.compteService = compteService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional<Compte> getCompteById(@PathVariable(value="id") Long id){
        logger.info("Get album by id");
        return compteService.getById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}/collection")
    public Set<Album> getCollectionByCompteById(@PathVariable(value="id") Long id){
        logger.info("Get album by id");
        return compteService.getById(id).get().getCollection();
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Compte> getAll(){
        logger.info("Get all albums");
        return compteService.getAll();
    }



}
