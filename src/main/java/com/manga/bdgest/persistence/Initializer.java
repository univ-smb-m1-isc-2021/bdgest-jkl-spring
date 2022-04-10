package com.manga.bdgest.persistence;

import com.manga.bdgest.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
class Initializer {

    private final AlbumRepository albumRepository;

    private final AuteurRepository auteurRepository;

    private final CompteRepository compteRepository;

    private final SerieRepository serieRepository;

    private final RoleRepository roleRepository;

    public Initializer(AlbumRepository albumRepository, AuteurRepository auteurRepository, CompteRepository compteRepository, SerieRepository serieRepository,RoleRepository roleRepository) {
        this.albumRepository = albumRepository;
        this.auteurRepository = auteurRepository;
        this.compteRepository = compteRepository;
        this.serieRepository = serieRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initialize()
    {
        albumRepository.deleteAllInBatch();
        auteurRepository.deleteAllInBatch();
        compteRepository.deleteAllInBatch();
        serieRepository.deleteAllInBatch();

        if (albumRepository.findAll().isEmpty() && compteRepository.findAll().isEmpty() && auteurRepository.findAll().isEmpty() && serieRepository.findAll().isEmpty() && compteRepository.findAll().isEmpty()) {

            Auteur auteur = new Auteur("Jubard", "Théo");

            Auteur auteur2 = new Auteur("Khial", "Omar");

            Auteur auteur3 = new Auteur("Lacerenza", "Loris");

            auteurRepository.saveAndFlush(auteur);
            auteurRepository.saveAndFlush(auteur2);
            auteurRepository.saveAndFlush(auteur3);

            Compte compte = new Compte("Barjonitro", "123", "test@test.com");

            Compte compte2 = new Compte("Omarmelade", "123", "test2@test.com");

            Compte compte3 = new Compte("Luxem", "123", "test3@test.com");

            compteRepository.saveAndFlush(compte);
            compteRepository.saveAndFlush(compte2);
            compteRepository.saveAndFlush(compte3);

            Serie serie = new Serie("Le Mystère de Tintin", "Ensemble d'histoire tournée autour des aventures de Tintin. Suivez les aventures du célèbre reportaire aux quatres coins du globe !", "https://www.bedetheque.com/media/Couvertures/Couv_420341.jpg", "Aventure", auteur, new Date(), new Date(), 3);

            Album album1 = new Album("Tintin et Loris",serie, auteur, "65", "523", "https://lesimpressionsnouvelles.com/wp-content/uploads/2016/09/tintinCOUVsite-1.jpg", "852",new Date());

            Album album2 = new Album("Loris au toilette",serie, auteur, "69", "23", "https://ds.static.rtbf.be/article/image/1920xAuto/1/6/8/c7d86983f21da3de678b6562edbeea0a-1427872987.jpg", "image",new Date());

            Album album3 = new Album("Loris mange du poisson",serie, auteur, "100", "123", "https://www.bedetheque.com/media/Couvertures/tintinfl07_20092003.jpg", "aled", new Date());



            serieRepository.saveAndFlush(serie);
            albumRepository.saveAndFlush(album1);
            albumRepository.saveAndFlush(album2);
            albumRepository.saveAndFlush(album3);

            Set<Album> albums = new HashSet<>();
            albums.add(album1);

            Compte compte4 = new Compte("Caca", "123", "test85@test.com", albums);

//            Compte compteTest = compteRepository.findById(1L).get();
//            compteTest.addCollection(album1);

//            compteRepository.saveAndFlush(compteTest);

            compteRepository.saveAndFlush(compte4);

            roleRepository.save(new Role("ROLE_ADMIN"));

        }

    }
}
