package com.manga.bdgest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Serie {

    @Id
    @GeneratedValue
    private Long  id;
    private String titre;
    private String description;
    private String image;
    private String categorie;
    private String auteur;
    private Date debut;
    private Date fin;
    private int nbTomes;

    @OneToMany
    private ArrayList<Album> albums;

    public Serie() {
        // JPA
    }

    public Serie(String titre, String description, String image, String categorie, String auteur, String Isbn, Date debut, Date fin, int nbTomes) {
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
        this.auteur = auteur;
        this.debut = debut;
        this.fin = fin;
        this.nbTomes = nbTomes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getNbTomes() {
        return nbTomes;
    }

    public void setNbTomes(int nbTomes) {
        this.nbTomes = nbTomes;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void addAlbum(Album album) {
        if (albums == null) {
            albums = new ArrayList<>();
        }
        albums.add(album);
    }

}


