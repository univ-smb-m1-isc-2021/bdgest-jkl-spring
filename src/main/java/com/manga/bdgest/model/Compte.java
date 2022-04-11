package com.manga.bdgest.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "collection",
            joinColumns = { @JoinColumn(name = "id_compte")},
            inverseJoinColumns = { @JoinColumn(name = "id_album") }
    )
    private Set<Album> collection = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id_compte"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


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
        this.collection = new HashSet<>();
    }

    public Compte(String pseudo, String password, String email, Set<Album> collection) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.collection = collection;
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

    public void removeCollection(Album album) {
        this.collection.remove(album);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
