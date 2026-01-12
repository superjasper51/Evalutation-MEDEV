/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class Parametre {

    private List<String> dictionaire;
    private int nbErreurMax;
    int nbJoueur;
    
    /**
     * constructeur par défaut de Parametre
     */
    public Parametre() {
        this.dictionaire = new ArrayList<>(List.of("chat", "chien"));
        nbErreurMax = 7;
        nbJoueur=1;
    }

    /**
     *
     * @param mot qui ne doit contenir que des lettres
     */
    public void ajouterMot(String mot) {
        if (!this.dictionaire.contains(mot)) {
            boolean probleme = false;
            int i = 0;
            mot = mot.toLowerCase();
            while (i < mot.length()) {
                if (!ListeLettre.getAlphabet().contains(mot.charAt(i))) {
                    System.out.println("Tous les mots du dictionaire doivent être valides, un mot ne l'est pas, il a été skip");
                    probleme = true;
                }
            }
            if (!probleme) {
                this.dictionaire.add(mot);
            }
        } else {
            System.out.println("ce mot existe déjà");
        }
    }

    /**
     *
     * @param mot qui doit faire partie du dictionaire
     */
    public void supprimerMot(String mot) {
        mot=mot.toLowerCase();
        if (this.dictionaire.contains(mot)) {
            this.dictionaire.remove(mot);
        } else {
            System.out.println("ce mot n'existe pas dans la liste");
        }
    }

    /**
     *
     * @param fichier chemin d'acces du fichier le fichier ne doit contenir
     * qu'un mot par ligne
     */
    public void chargerDictionnaire(String fichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String mot;
            while ((mot = br.readLine()) != null) {
                if (mot.contains(" ")) {
                    System.out.println("il ne doit y avoir qu'un seul mot par ligne");
                } else {
                    ajouterMot(mot);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param n qui doit être compris entre 4 et 9, il y sera remis si il est
     * hors de ce cadre
     */
    public void erreurMax(int n) {
        this.nbErreurMax = min(9, max(4, n));
    }

    public List<String> getDictionaire() {
        return dictionaire;
    }

    public void setDictionaire(List<String> dictionaire) {
        this.dictionaire = dictionaire;
    }

    public int getNbErreurMax() {
        return nbErreurMax;
    }

    public void setNbErreurMax(int nbErreurMax) {
        this.nbErreurMax = nbErreurMax;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }
    
    
}
