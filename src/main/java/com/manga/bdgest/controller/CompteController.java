package com.manga.bdgest.controller;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Compte;
import com.manga.bdgest.service.AlbumService;
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
    private final AlbumService albumService;

    public CompteController(CompteService compteService, AlbumService albumService){
        this.compteService = compteService;
        this.albumService = albumService;
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
    @GetMapping(value = "/{id}/addcollection/{idAlbum}")
    public void addToCollectionByUserIdAndAlbumId(@PathVariable(value="id") Long id, @PathVariable(value="idAlbum") Long idAlbum){
        logger.info("Get album by id");
        Album album = albumService.getById(idAlbum).get();
        Compte compte = compteService.getById(id).get();
        compte.addCollection(album);
        compteService.create(compte);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}/deletecollection/{idAlbum}")
    public void removeFromCollectionByUserIdAndAlbumId(@PathVariable(value="id") Long id, @PathVariable(value="idAlbum") Long idAlbum){
        logger.info("Get album by id");
        Album album = albumService.getById(idAlbum).get();
        Compte compte = compteService.getById(id).get();
        compte.removeCollection(album);
        compteService.create(compte);
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Compte> getAll(){
        logger.info("Get all albums");
        return compteService.getAll();
    }

    @CrossOrigin
    @GetMapping(value = "/signup/{pseudo}/{email}/{password}")
    public Boolean signIn(@PathVariable(value="pseudo") String pseudo, @PathVariable(value="email") String email, @PathVariable(value="password") String password){
        Compte compte = new Compte(pseudo, email, password);
        compteService.create(compte);
        return true;
    }

    @CrossOrigin
    @GetMapping(value = "/delete/{id}")
    public Boolean signIn(@PathVariable(value="id") Long id){
        compteService.delete(id);
        return true;
    }




}
