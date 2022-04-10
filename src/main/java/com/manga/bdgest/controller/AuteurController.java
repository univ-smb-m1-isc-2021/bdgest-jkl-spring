package com.manga.bdgest.controller;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.service.AuteurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/auteur")
public class AuteurController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService){
        this.auteurService = auteurService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional<Auteur> getAuteurById(@PathVariable(value="id") Long id){
        logger.info("Get auteur by id");
        return auteurService.getById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}/albums")
    public Set<Album> getAlbumsByAuteurId(@PathVariable(value="id") Long id){
        logger.info("Get albums by author id");
        return auteurService.getById(id).get().getAlbums();
    }


    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Auteur> getAll(){
        logger.info("Get all authors");
        return auteurService.getAll();
    }

}
