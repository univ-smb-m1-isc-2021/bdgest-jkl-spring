package com.manga.bdgest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "serie")
public class Serie {

    @Id
    @Column(name="id_serie", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name="titre", nullable = false)
    private String titre;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="image", nullable = false)
    private String image;
    @Column(name="categorie", nullable = false)
    private String categorie;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.MERGE)
    private Set<Album> albums = new HashSet<>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;

    @Column(name="date_creation")
    private Date debut;
    @Column(name="date_fin")
    private Date fin;
    @Column(name="nb_tomes")
    private int nbTomes;

    @ManyToMany(mappedBy = "serieSuivi", cascade = CascadeType.MERGE)
    private Set<Compte> serieSuivi = new HashSet<>();

    public Serie() {

    }

    public Serie(String titre, String description, String image, String categorie, Auteur auteur, Date debut, Date fin, int nbTomes) {
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

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
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

    @JsonManagedReference
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}


