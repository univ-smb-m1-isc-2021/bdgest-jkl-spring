package com.manga.bdgest.test;

import com.manga.bdgest.model.Compte;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CompteTest {

    @Test
    public void CorrectCreation() {
        assertThat(new Compte().getCollection().size()).isEqualTo(0);

    }
}
