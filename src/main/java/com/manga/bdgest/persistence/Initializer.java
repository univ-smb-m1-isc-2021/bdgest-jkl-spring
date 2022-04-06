package com.manga.bdgest.persistence;

import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Compte;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
class Initializer {

        private final AlbumRepository albumRepository;

        private final AuteurRepository auteurRepository;

        private final CompteRepository compteRepository;

        public Initializer(AlbumRepository albumRepository, AuteurRepository auteurRepository, CompteRepository compteRepository) {
            this.albumRepository = albumRepository;
            this.auteurRepository = auteurRepository;
            this.compteRepository = compteRepository;
        }

        @PostConstruct
        public void initialize()
        {
                albumRepository.deleteAllInBatch();
                auteurRepository.deleteAllInBatch();
                compteRepository.deleteAllInBatch();

                if (albumRepository.findAll().isEmpty() && compteRepository.findAll().isEmpty() && auteurRepository.findAll().isEmpty()){

                    Auteur auteur = new Auteur("Jubard", "Théo");

                    Auteur auteur2 = new Auteur("Khial", "Omar");


                    Auteur auteur3 = new Auteur("Lacerenza", "Loris");

                    auteurRepository.saveAndFlush(auteur);
                    auteurRepository.saveAndFlush(auteur2);
                    auteurRepository.saveAndFlush(auteur3);

                    Compte compte = new Compte("Barjonitro", "123", "test@test.com");

                    Compte compte2 = new Compte("Omarmelade", "123", "test@test.com");

                    Compte compte3 = new Compte("Luxem", "123", "test@test.com");

                    compteRepository.saveAndFlush(compte);
                    compteRepository.saveAndFlush(compte2);
                    compteRepository.saveAndFlush(compte3);

                    Album album1 = new Album("Tintin et Loris","Les aventures de Lorissou", "45", "156565161313", auteur, new Date(), "C'est pas ouf","sdfgsdfgsdfg");

                    Album album2 = new Album("Loris au toilette","Les aventures de Lorissou", "69", "654424874654", auteur2, new Date(), "Loris à bu trop de coca, pourra-t-il évacuer correctement ?","dflglksjhdfg");

                    Album album3 = new Album("Loris mange du poisson","Les aventures de Lorissou", "100", "64598731654", auteur3, new Date(), "dernier tome ...","oshkfdjhg");

                    albumRepository.saveAndFlush(album1);
                    albumRepository.saveAndFlush(album2);
                    albumRepository.saveAndFlush(album3);



                }

        }
}
