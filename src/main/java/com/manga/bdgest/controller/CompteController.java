package com.manga.bdgest.controller;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Compte;
import com.manga.bdgest.model.Serie;
import com.manga.bdgest.service.AlbumService;
import com.manga.bdgest.service.AuteurService;
import com.manga.bdgest.service.CompteService;
import com.manga.bdgest.service.SerieService;
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
    private final AuteurService auteurService;
    private final SerieService serieService;

    public CompteController(CompteService compteService, AlbumService albumService, AuteurService auteurService, SerieService serieService){
        this.compteService = compteService;
        this.albumService = albumService;
        this.auteurService = auteurService;
        this.serieService = serieService;
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
    @GetMapping(value = "/{id}/auteursuivi")
    public Set<Auteur> getAuteurSuiviByCompteById(@PathVariable(value="id") Long id){
        return compteService.getById(id).get().getAuteurSuivi();
    }


    @CrossOrigin
    @GetMapping(value = "{id}/addauteursuivi/{idAuteur}")
    public void addAuteurSuivi(@PathVariable(value="id") Long id, @PathVariable(value="idAuteur") Long idAuteur){
        Compte compte = compteService.getById(id).get();
        Auteur auteur = auteurService.getById(idAuteur).get();
        compte.addAuteurSuivi(auteur);
        compteService.create(compte);
    }

    @CrossOrigin
    @GetMapping(value = "{id}/deleteauteursuivi/{idAuteur}")
    public void deleteAuteurSuivi(@PathVariable(value="id") Long id, @PathVariable(value="idAuteur") Long idAuteur){
        Compte compte = compteService.getById(id).get();
        Auteur auteur = auteurService.getById(idAuteur).get();
        compte.removeAuteurSuivi(auteur);
        compteService.create(compte);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}/seriesuivi")
    public Set<Serie> getAuteurByCompteById(@PathVariable(value="id") Long id){
        return compteService.getById(id).get().getSerieSuivi();
    }

    @CrossOrigin
    @GetMapping(value = "{id}/addseriesuivi/{idSerie}")
    public void addSerieSuivi(@PathVariable(value="id") Long id, @PathVariable(value="idSerie") Long idSerie){
        Compte compte = compteService.getById(id).get();
        Serie serie = serieService.getById(idSerie).get();
        compte.addSerieSuivi(serie);
        compteService.create(compte);
    }

    @CrossOrigin
    @GetMapping(value = "{id}/deleteseriesuivi/{idSerie}")
    public void deleteSerieSuivi(@PathVariable(value="id") Long id, @PathVariable(value="idSerie") Long idSerie){
        Compte compte = compteService.getById(id).get();
        Serie serie = serieService.getById(idSerie).get();
        compte.removeSerieSuivi(serie);
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


    @CrossOrigin
    @GetMapping(value = "/getByEmailOrPseudo/{emailorpseudo}")
    public Compte getByEmailOrPseudo(@PathVariable(value="emailorpseudo") String email){
        return compteService.getByEmailOrPseudo(email);
    }




}
