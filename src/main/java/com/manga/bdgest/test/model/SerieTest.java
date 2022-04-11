package com.manga.bdgest.test.model;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Serie;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class SerieTest {

    @Test
    public void CorrectAffectation() {
        Serie serie = new Serie("titre", "description", "image", "categorie", new Auteur(), new Date(), new Date(), 0);
        assertThat(serie.getTitre()).isEqualTo("titre");
        assertThat(serie.getDescription()).isEqualTo("description");
        assertThat(serie.getImage()).isEqualTo("image");
        assertThat(serie.getCategorie()).isEqualTo("categorie");
        assertThat(serie.getAuteur()).isNotNull();
        assertThat(serie.getDebut()).isNotNull();
        assertThat(serie.getFin()).isNotNull();
        assertThat(serie.getNbTomes()).isEqualTo(0);

    }

}
