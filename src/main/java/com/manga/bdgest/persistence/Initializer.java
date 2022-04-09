package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Compte;
import com.manga.bdgest.model.Serie;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
class Initializer {

    private final AlbumRepository albumRepository;

    private final AuteurRepository auteurRepository;

    private final CompteRepository compteRepository;

    private final SerieRepository serieRepository;

    public Initializer(AlbumRepository albumRepository, AuteurRepository auteurRepository, CompteRepository compteRepository, SerieRepository serieRepository) {
        this.albumRepository = albumRepository;
        this.auteurRepository = auteurRepository;
        this.compteRepository = compteRepository;
        this.serieRepository = serieRepository;
    }

    @PostConstruct
    public void initialize()
    {
        albumRepository.deleteAllInBatch();
        auteurRepository.deleteAllInBatch();
        compteRepository.deleteAllInBatch();
        serieRepository.deleteAllInBatch();

        if (albumRepository.findAll().isEmpty() && compteRepository.findAll().isEmpty() && auteurRepository.findAll().isEmpty() && serieRepository.findAll().isEmpty()) {

            Auteur auteur = new Auteur("Jubard", "Théo");

            Auteur auteur2 = new Auteur("Khial", "Omar");

            Auteur auteur3 = new Auteur("Lacerenza", "Loris");

            auteurRepository.saveAndFlush(auteur);
            auteurRepository.saveAndFlush(auteur2);
            auteurRepository.saveAndFlush(auteur3);

            Compte compte = new Compte("Barjonitro", "123", "test@test.com");

            Compte compte2 = new Compte("Omarmelade", "123", "test@test.com");

            Compte compte3 = new Compte("Luxem", "123", "test@test.com");

            Serie serie = new Serie("Les aventures du Spring", "L'histoire de la vie", "image", "seum", auteur, new Date(), new Date(), 3);

            Album album1 = new Album("Tintin et Loris",serie, "auteur", "65");

            Album album2 = new Album("Loris au toilette",serie, "auteur2", "69");

            Album album3 = new Album("Loris mange du poisson",serie, "auteur3", "100");


            serieRepository.saveAndFlush(serie);
            albumRepository.saveAndFlush(album1);
            albumRepository.saveAndFlush(album2);
            albumRepository.saveAndFlush(album3);



        }

    }
}
