package com.manga.bdgest.test.model;

import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Compte;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuteurTest {
    @Test
    public void CorrectCreation() {
        assertThat(new Auteur().getAlbums().size()).isEqualTo(0);

    }

    @Test
    public void CorrectAffectation() {
            Auteur auteur = new Auteur("nom", "prenom");
            assertThat(auteur.getNom()).isEqualTo("nom");
            assertThat(auteur.getPrenom()).isEqualTo("prenom");

    }
}
