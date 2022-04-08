package com.manga.bdgest.model;


import javax.persistence.*;

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

}
