package com.manga.bdgest.model;

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
    @Column(name= "serie")
    private String serie;
    @Column(name= "auteur", nullable = false)
    private String auteur;
    @Column(name= "numero", nullable = false)
    private String numero;

    public Album() {
    }

    public Album(String titre, String serie, String auteur, String numero) {
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
