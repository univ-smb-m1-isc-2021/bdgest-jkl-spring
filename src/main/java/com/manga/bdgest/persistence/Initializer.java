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

            Serie serie = new Serie("Le Mystère de Tintin", "Ensemble d'histoire tournée autour des aventures de Tintin. Suivez les aventures du célèbre reportaire aux quatres coins du globe !", "https://lesimpressionsnouvelles.com/wp-content/uploads/2016/09/tintinCOUVsite-1.jpg", "Aventure", auteur, new Date(), new Date(), 3);

            Album album1 = new Album("Le Mystère de Tinin",serie, auteur, "65", "523", "https://lesimpressionsnouvelles.com/wp-content/uploads/2016/09/tintinCOUVsite-1.jpg", "Le célèbre reporter",new Date());

            Album album2 = new Album("Alerte à Fukushima",serie, auteur, "69", "23", "https://ds.static.rtbf.be/article/image/1920xAuto/1/6/8/c7d86983f21da3de678b6562edbeea0a-1427872987.jpg", "Après l'attaque d'un missile, Tintin et le captiaine Hadock se rendent sur les lieux de la centrale afin d'enquêter",new Date());

            Album album3 = new Album("Les 7 boules de cristal",serie, auteur, "100", "123", "https://www.bedetheque.com/media/Couvertures/tintinfl07_20092003.jpg", "aled", new Date());

            Serie serie2 = new Serie("Dragon Ball Z ", "Goku, un alien de la race des Sayens et arriver sur Terre après la destruction de sa planète", "https://images-na.ssl-images-amazon.com/images/I/71BaBz2cBLL.jpg", "Action", auteur2, new Date(), new Date(), 152);

            Album album4 = new Album("La vengeance de Freezer",serie2, auteur2, "45", "12651643", "https://images-na.ssl-images-amazon.com/images/I/71BaBz2cBLL.jpg", "aled", new Date());

            Album album5 = new Album("La vengeance de Freezer",serie2, auteur2, "19", "12651643", "https://images-na.ssl-images-amazon.com/images/I/81ki-YrtLgL.jpg", "aled", new Date());

            Album album6 = new Album("La vengeance de Freezer",serie2, auteur2, "43", "12651643", "https://www.bdfugue.com/media/catalog/product/cache/1/image/400x/17f82f742ffe127f42dca9de82fb58b1/9/7/9782723474771_1_75.jpg", "aled", new Date());

            Album album7 = new Album("La vengeance de Freezer",serie2, auteur2, "36", "12651643", "https://images-na.ssl-images-amazon.com/images/I/616RHMD7dML.jpg", "aled", new Date());

            Album album8 = new Album("La vengeance de Freezer",serie2, auteur2, "42", "12651643", "https://ec56229aec51f1baff1d-185c3068e22352c56024573e929788ff.ssl.cf1.rackcdn.com/attachments/large/0/9/3/005298093.jpg", "aled", new Date());

            Album album9 = new Album("La vengeance de Freezer",serie2, auteur2, "20", "12651643", "https://ec56229aec51f1baff1d-185c3068e22352c56024573e929788ff.ssl.cf1.rackcdn.com/attachments/large/8/8/6/005963886.jpg", "aled", new Date());




            serieRepository.saveAndFlush(serie);
            serieRepository.saveAndFlush(serie2);
            albumRepository.saveAndFlush(album1);
            albumRepository.saveAndFlush(album2);
            albumRepository.saveAndFlush(album3);
            albumRepository.saveAndFlush(album4);
            albumRepository.saveAndFlush(album5);
            albumRepository.saveAndFlush(album6);
            albumRepository.saveAndFlush(album7);
            albumRepository.saveAndFlush(album8);
            albumRepository.saveAndFlush(album9);

            Set<Album> albums = new HashSet<>();
            albums.add(album1);
            albums.add(album2);
            albums.add(album4);

            Compte compte4 = new Compte("Robert", "123", "robert@gmail.com", albums);

            compteRepository.saveAndFlush(compte4);

            roleRepository.save(new Role("ROLE_ADMIN"));
        }
    }
}
