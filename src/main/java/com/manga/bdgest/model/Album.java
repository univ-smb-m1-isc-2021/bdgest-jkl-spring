package com.manga.bdgest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {


    @Id
    @Column(name="id_album", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre", nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_serie")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "id_auteur")
    private Auteur auteur;



//    @Column(name="id_auteur")
//    private String auteur;

    @Column(name= "numero", nullable = false)
    private String numero;

    public Album() {
    }

    public Album(String titre, Serie serie, Auteur auteur, String numero) {
        this.titre = titre;
        this.serie = serie;
        this.auteur = auteur;
        this.numero = numero;
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
}
