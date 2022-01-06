package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "Matricule {0}, performance {1}, anciennete {2}, temps partiel {3} => prime {4}")
    @CsvSource({
            "'T12345', 1, 0, 1.0, 1000.0",
            "'T23442', 1, 2, 1.0, 1200.0",
            "'T23442', 1, 0, 0.5, 500.0",
            "'T23442', 2, 0, 1.0, 2300.0",
            "'M12345', 1, 0, 1.0, 1700.0",
            "'T23442', 0, 0, 1.0, 1000.0",
            "'T23442',, 0, 1.0, 1000.0",
            ", 0, 0, 1.0, 1000.0",
    })
    public void testGetPrimeAnnuelle(String matricule, Integer performance, Long nbAnneesAnciennete, Double tempsPartiel, Double primeAttendue) {
        // Given
        Employe employe = EmployeMaker.employeTechnicienPleinTemps().
                but().withMatricule(matricule).
                but().withPerformance(performance).
                but().withDateEmbauche(LocalDate.now().minusYears(nbAnneesAnciennete)).
                but().withTempsPartiel(tempsPartiel).
                build();
        // When
        Double prime = employe.getPrimeAnnuelle();
        // Then
        // Prime de base + prime de perf + prime d'ancienneté au pro rata de son activité
        Assertions.assertThat(prime).isEqualTo(primeAttendue);
    }

}
