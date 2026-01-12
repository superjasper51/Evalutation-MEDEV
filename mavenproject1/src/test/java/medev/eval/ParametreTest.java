/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package medev.eval;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nathan
 */
public class ParametreTest {

    public ParametreTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ajouterMot method, of class Parametre.
     */
    @Test
    public void testAjouterMot() {
        System.out.println("ajouterMot");
        ArrayList<String> mots = new ArrayList<>();
        mots.add("Tortue");
        mots.add("A");
        mots.add("");
        mots.add("VoiciUnMotQuiPeutParaitreLong");
        mots.add("chaîne");
        mots.add("o o");
        mots.add("O_O");
        Parametre instance = new Parametre();
        for (String mot : mots) {
            instance.ajouterMot(mot);
        }
        // TODO review the generated test code and remove the default call to fail.
        if (!(instance.getDictionaire().size() == 3)) {
            fail("ça n'a pas fonctionné");
        }
    }

    /**
     * Test of supprimerMot method, of class Parametre.
     */
    @Test
    public void testSupprimerMot() {
        System.out.println("supprimerMot");
        String mot = "chat";
        Parametre instance = new Parametre();
        instance.supprimerMot(mot);
        if (!(instance.getDictionaire().size() == 1)) {
            fail("ça n'a pas fonctionné");
        }
        mot = "Tortue";
        instance.supprimerMot(mot);
        if (!(instance.getDictionaire().size() == 1)) {
            fail("ça n'a pas fonctionné");
        }
        mot = "CHIEN";
        instance.supprimerMot(mot);
        if (!instance.getDictionaire().isEmpty()) {
            fail("ça n'a pas fonctionné");
        }
    }

    /**
     * Test of chargerDictionnaire method, of class Parametre.
     */
    @Test
    public void testChargerDictionnaire() {
        System.out.println("chargerDictionnaire");
        String fichier = "fichier.txt";
        Parametre instance = new Parametre();
        instance.chargerDictionnaire(fichier);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getDictionaire().isEmpty()) {
            fail("ça n'a pas fonctionné");
        }
    }

    /**
     * Test of erreurMax method, of class Parametre.
     */
    @Test
    public void testErreurMax() {
        System.out.println("erreurMax");
        int n = 0;
        Parametre instance = new Parametre();
        instance.erreurMax(n);
        if (instance.getNbErreurMax() != 4) {
            fail("Erreur");
        }
        n = 10;
        instance.erreurMax(n);
        if (instance.getNbErreurMax() != 9) {
            fail("Erreur");
        }
        n = 7;
        instance.erreurMax(n);
        if (instance.getNbErreurMax() != 7) {
            fail("Erreur");
        }
    }

}
