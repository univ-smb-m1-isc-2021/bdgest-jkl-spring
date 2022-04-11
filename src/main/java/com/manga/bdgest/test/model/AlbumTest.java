package com.manga.bdgest.test.model;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Auteur;
import com.manga.bdgest.model.Serie;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class AlbumTest {


    @Test
    public void CorrectAffectation() {
        Album album = new Album("titre", null, null, "numero", "isbn", "image", "description", new Date());
        assertThat(album.getTitre()).isEqualTo("titre");
        assertThat(album.getSerie()).isEqualTo(null);
        assertThat(album.getAuteur()).isEqualTo(null);
        assertThat(album.getNumero()).isEqualTo("numero");
        assertThat(album.getIsbn()).isEqualTo("isbn");
        assertThat(album.getImage()).isEqualTo("image");
        assertThat(album.getDescription()).isEqualTo("description");

    }
}
