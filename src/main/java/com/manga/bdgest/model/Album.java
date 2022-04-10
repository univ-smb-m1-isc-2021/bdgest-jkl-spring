package com.manga.bdgest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {


    @Id
    @Column(name="id_album", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre", nullable = false)
    private String titre;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_serie")
    private Serie serie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;

    @Column(name= "numero", nullable = false)
    private String numero;

    @Column(name="isbn", nullable = false)
    private String isbn;

    private String image;

    @Column(name="description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "collection", cascade = CascadeType.MERGE)
    private Set<Compte> collection = new HashSet<>();




    public Album() {
    }

    public Album(String titre, Serie serie, Auteur auteur, String numero, String isbn, String image, String description) {
        this.titre = titre;
        this.serie = serie;
        this.auteur = auteur;
        this.numero = numero;
        this.isbn = isbn;
        this.image = image;
        this.description = description;
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

    @JsonBackReference
    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @JsonBackReference
    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

