package com.manga.bdgest.model;

import javax.persistence.*;
import java.util.ArrayList;
import com.manga.bdgest.model.Album;

@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @Column(name="id_user", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pseudo", nullable = false, unique = true)
    private String pseudo;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false, unique = true)
    private String email;


    public Compte() {
        //JPA
    }

    public Compte(String pseudo, String password, String email, ArrayList<Album> favoris) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public Compte(String pseudo, String password, String email) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
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


}
