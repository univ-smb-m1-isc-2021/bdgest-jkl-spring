package com.manga.bdgest.test.model;

import com.manga.bdgest.model.Compte;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CompteTest {

    @Test
    public void CorrectCreation() {
        assertThat(new Compte().getCollection().size()).isEqualTo(0);

    }

    @Test
    public void CorrectAffectation() {
        Compte compte = new Compte("pseudo", "password", "email");
        assertThat(compte.getPseudo()).isEqualTo("pseudo");
        assertThat(compte.getPassword()).isEqualTo("password");
        assertThat(compte.getEmail()).isEqualTo("email");
    }
}
