package com.manga.bdgest.model;

import javax.persistence.*;
import java.util.ArrayList;
import com.manga.bdgest.model.Album;

@Entity
public class Compte {

    @Id
    @GeneratedValue
    private Long id;

    private String pseudo;

    private String password;

    private String email;

    @OneToMany
    private ArrayList<Album> favoris;

    public Compte() {
        //JPA
    }

    public Compte(String pseudo, String password, String email, ArrayList<Album> favoris) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.favoris = favoris;
    }

    public Compte(String pseudo, String password, String email) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.favoris = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Album getAlbum(int index) {
        return favoris.get(index);
    }

    public ArrayList<Album> getFavoris() {
        return favoris;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoris(ArrayList<Album> favoris) {
        this.favoris = favoris;
    }

    public void addFavoris(Album album) {
        this.favoris.add(album);
    }

}
