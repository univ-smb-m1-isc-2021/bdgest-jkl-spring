package com.manga.bdgest.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "auteur")
public class Auteur {

    @Id
    @Column(name="id_auteur", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom", nullable = false, updatable = false)
    private String nom;
    @Column(name="prenom", nullable = false, updatable = false)
    private String prenom;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.MERGE)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany(mappedBy = "auteurSuivi", cascade = CascadeType.MERGE)
    private Set<Compte> auteurSuivi = new HashSet<>();

    public Auteur() {
        // JPA
    }

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @JsonManagedReference
    public Set<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }



}
