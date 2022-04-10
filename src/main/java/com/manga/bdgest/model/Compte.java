package com.manga.bdgest.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.manga.bdgest.model.Album;

@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @Column(name="id_compte", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pseudo", nullable = false, unique = true)
    private String pseudo;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "collection",
            joinColumns = { @JoinColumn(name = "id_compte")},
            inverseJoinColumns = { @JoinColumn(name = "id_album") }
    )
    private Set<Album> collection = new HashSet<>();


    public Compte() {
        //JPA
    }

//    public Compte(String pseudo, String password, String email, ArrayList<Album> favoris) {
//        this.pseudo = pseudo;
//        this.password = password;
//        this.email = email;
//    }

    public Compte(String pseudo, String password, String email) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Album> getCollection() {
        return collection;
    }

    public void setCollection(Set<Album> collection) {
        this.collection = collection;
    }

    public void addCollection(Album album) {
        this.collection.add(album);
    }
}
