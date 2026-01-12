/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package medev.eval;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author julda
 */
public class MotTest {
    
    public MotTest() {
    }
    @BeforeAll
    public void creation() {
        Mot mot=new Mot("aRbre");
        assert "ARBRE".equals(mot.getReel());
        assert "_ _ _ _ _ ".equals(mot.getActuel());
    }
    @BeforeAll
    public void doubleLettre() {
        Mot mot=new Mot("aRbre");
        assert mot.possede('R');
        assert mot.possede('r');
    }
    public void maj() {
        Mot mot=new Mot("aRbre");
        mot.majMotActuel('r',1);
        assert "_ R _ _ _".equals(mot.getReel());
        mot.majMotActuel('r',3);
        assert "_ R _ R _".equals(mot.getReel());
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
