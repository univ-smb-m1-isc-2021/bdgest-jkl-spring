package com.manga.bdgest.persistence;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.manga.bdgest.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

import java.time.Instant;
import java.util.Arrays;
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

    public Initializer(AlbumRepository albumRepository, AuteurRepository auteurRepository,
            CompteRepository compteRepository, SerieRepository serieRepository, RoleRepository roleRepository) {
        this.albumRepository = albumRepository;
        this.auteurRepository = auteurRepository;
        this.compteRepository = compteRepository;
        this.serieRepository = serieRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void initialize() throws UnsupportedEncodingException, NoSuchAlgorithmException, JSONException {
        albumRepository.deleteAllInBatch();
        auteurRepository.deleteAllInBatch();
        compteRepository.deleteAllInBatch();
        serieRepository.deleteAllInBatch();

        if (albumRepository.findAll().isEmpty() && compteRepository.findAll().isEmpty()
                && auteurRepository.findAll().isEmpty() && serieRepository.findAll().isEmpty()
                && compteRepository.findAll().isEmpty()) {

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

            Serie serie = new Serie("Le Mystère de Tintin",
                    "Ensemble d'histoire tournée autour des aventures de Tintin. Suivez les aventures du célèbre reportaire aux quatres coins du globe !",
                    "https://lesimpressionsnouvelles.com/wp-content/uploads/2016/09/tintinCOUVsite-1.jpg", "Aventure",
                    auteur, new Date(), new Date(), 3);

            Album album1 = new Album("Le Mystère de Tinin", serie, auteur, "65", "523",
                    "https://lesimpressionsnouvelles.com/wp-content/uploads/2016/09/tintinCOUVsite-1.jpg",
                    "Le célèbre reporter", new Date());

            Album album2 = new Album("Alerte à Fukushima", serie, auteur, "69", "23",
                    "https://ds.static.rtbf.be/article/image/1920xAuto/1/6/8/c7d86983f21da3de678b6562edbeea0a-1427872987.jpg",
                    "Après l'attaque d'un missile, Tintin et le captiaine Hadock se rendent sur les lieux de la centrale afin d'enquêter",
                    new Date());

            Album album3 = new Album("Les 7 boules de cristal", serie, auteur, "100", "123",
                    "https://www.bedetheque.com/media/Couvertures/tintinfl07_20092003.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Serie serie2 = new Serie("Dragon Ball Z ",
                    "Goku, un alien de la race des Sayens et arriver sur Terre après la destruction de sa planète",
                    "https://images-na.ssl-images-amazon.com/images/I/71BaBz2cBLL.jpg", "Action", auteur2, new Date(),
                    new Date(), 152);

            Album album4 = new Album("La vengeance de Freezer", serie2, auteur2, "45", "12651643",
                    "https://images-na.ssl-images-amazon.com/images/I/71BaBz2cBLL.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Album album5 = new Album("La vengeance de Freezer", serie2, auteur2, "19", "12651643",
                    "https://images-na.ssl-images-amazon.com/images/I/81ki-YrtLgL.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Album album6 = new Album("La vengeance de Freezer", serie2, auteur2, "43", "12651643",
                    "https://www.bdfugue.com/media/catalog/product/cache/1/image/400x/17f82f742ffe127f42dca9de82fb58b1/9/7/9782723474771_1_75.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Album album7 = new Album("La vengeance de Freezer", serie2, auteur2, "36", "12651643",
                    "https://images-na.ssl-images-amazon.com/images/I/616RHMD7dML.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Album album8 = new Album("La vengeance de Freezer", serie2, auteur2, "42", "12651643",
                    "https://ec56229aec51f1baff1d-185c3068e22352c56024573e929788ff.ssl.cf1.rackcdn.com/attachments/large/0/9/3/005298093.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

            Album album9 = new Album("La vengeance de Freezer", serie2, auteur2, "20", "12651643",
                    "https://ec56229aec51f1baff1d-185c3068e22352c56024573e929788ff.ssl.cf1.rackcdn.com/attachments/large/8/8/6/005963886.jpg",
                    "Après de nombreux combats, la bataille finale commence enfin ! Qui sortira vainqueur de ce choc de titan ?!",
                    new Date());

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


            fetchData(0);

            fetchData(100);
            fetchData(200);
        }
    }

    public void fetchData(int offset) throws JSONException {
        System.err.println("Fetching data from offset " + offset);
        String ts = "1";
        String prvKey = "095be71477288ef901d0338db08f552c88bf0cdf";
        String pubKey = "a54935baa06e1ce6e3227290bbe79668";

        Instant instant = Instant.now();
        long timestamp = instant.toEpochMilli();
        String beforehash = 1 + prvKey + pubKey;

        String hash = DigestUtils.md5Hex(beforehash);

        String url = "https://gateway.marvel.com:443/v1/public/comics?format=comic&formatType=comic&noVariants=true&dateDescriptor=thisMonth&limit=100&offset="+offset+"&ts=" + ts + "&apikey="+ pubKey + "&hash=" + hash;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(response);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray results = data.getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            JSONObject j = results.getJSONObject(i);
            String serieTitle = j.getJSONObject("series").getString("name");
            JSONObject authors = j.getJSONObject("creators");
            String desc = j.getString("description");
            JSONArray authorsArr = authors.getJSONArray("items");
            String authorName = authorsArr.getJSONObject(0).getString("name");
            String[] names = authorName.split(" ");
            Auteur a1 = new Auteur(names[0], names[1]);
            Serie s = new Serie(serieTitle, desc, "", "", a1, new Date(), new Date(), -1);
            Album l = new Album(j.get("title").toString(), s , a1, j.get("issueNumber").toString(), j.get("isbn").toString(), "", desc, new Date());
            auteurRepository.saveAndFlush(a1);
            serieRepository.saveAndFlush(s);
            albumRepository.saveAndFlush(l);
        }
    }
}
