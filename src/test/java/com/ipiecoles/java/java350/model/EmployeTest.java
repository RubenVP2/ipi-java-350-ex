package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class EmployeTest {

    // Cas 1
    // DateNow = 05/01/2021
    // DateEmbauche = 05/01/2023
    // Resultat attendu : Nombre d'années d'ancienneté = 0
    @Test
    public void testGetNombreAnneeAncienneteWithDateEmbaucheFuture() {
        Employe employe = EmployeMaker.employeTechnicienPleinTemps()
                .but().withDateEmbauche(LocalDate.now().plusYears(2)).
                build();
        // Then
        Assertions.assertThat(employe.getNombreAnneeAnciennete()).isZero();
    }

    // Cas 2
    // DateNow = 05/01/2021
    // DateEmbauche = 05/01/2021
    // Resultat attendu : Nombre d'années d'ancienneté = 0
    @Test
    public void testGetNombreAnneeAncienneteWithDateEmbaucheNow() {
        Employe employe = EmployeMaker.employeTechnicienPleinTemps()
                .but().withDateEmbauche(LocalDate.now()).
                build();
        // Then
        Assertions.assertThat(employe.getNombreAnneeAnciennete()).isZero();
    }

    // Cas 3
    // DateNow = 05/01/2021
    // DateEmbauche = 05/01/2019
    // Resultat attendu : Nombre d'années d'ancienneté = 2
    @Test
    public void testGetNombreAnneeAncienneteWithDateEmbauchePast() {
        Employe employe = EmployeMaker.employeTechnicienPleinTemps()
                .but().withDateEmbauche(LocalDate.now().minusYears(2)).
                build();
        // Then
        Assertions.assertThat(employe.getNombreAnneeAnciennete()).isEqualTo(2);
    }

    // Cas 4
    // DateNow = 05/01/2021
    // DateEmbauche = null
    // Resultat attendu : Nombre d'années d'ancienneté = 0
    @Test
    public void testGetNombreAnneeAncienneteWithDateEmbaucheNull() {
        Employe employe = EmployeMaker.employeTechnicienPleinTemps()
                .but().withDateEmbauche(null).
                build();
        // Then
        Assertions.assertThat(employe.getNombreAnneeAnciennete()).isZero();
    }

}
