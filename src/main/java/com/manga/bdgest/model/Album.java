package com.manga.bdgest.model;

import org.springframework.stereotype.Indexed;
import com.manga.bdgest.model.Auteur;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;
    private String titre;
    private String numero;
    private String Isbn;

    @OneToOne
    private Auteur auteur; 
    private Date date;
    private String description;
    private String image;

    @OneToOne
    private Serie serie;

    public Album() {
        // JPA
    }

    public Album(String titre, Serie serie, String numero, String Isbn, Auteur auteur, Date date, String description,String image) {
        this.titre = titre;
        this.serie = serie;
        this.numero = numero;
        this.Isbn = Isbn;
        this.auteur = auteur;
        this.date = date;
        this.description = description;
        this.image = image;
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





    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
