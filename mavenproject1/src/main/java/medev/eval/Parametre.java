/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan
 */
public class Parametre {

    private List<String> dictionaire;
    private int nbErreurMax;

    public Parametre() {
        this.dictionaire = new ArrayList<>(List.of("chat", "chien"));
        nbErreurMax = 7;
    }

    public void ajouterMot(String mot) {
        if (!this.dictionaire.contains(mot)) {
            this.dictionaire.add(mot);
        } else {
            System.out.println("ce mot existe déjà");//NO SONAR
        }
    }

    public void supprimerMot(String mot) {
        if (this.dictionaire.contains(mot)) {
            this.dictionaire.remove(mot);
        } else {
            System.out.println("ce mot n'existe pas dans la liste");//NO SONAR
        }
    }
    /**
     * 
     * @param fichier chemin d'acces du fichier
     * le fichier ne doit contenir qu'un mot par ligne
     */
    public void chargerDictionnaire(String fichier){
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String mot;
            boolean probleme=false;
            int i=0;
            while ((mot = br.readLine()) != null) {
                i=0;
                mot=mot.toLowerCase();
                if (mot.contains(" ")){
                System.out.println("il ne doit y avoir qu'un seul mot par ligne");//NO SONAR
                }
                while (i<mot.length()){
                    if(!ListeLettre.getAlphabet().contains(mot.charAt(i))){
                        System.out.println("Tous les mots du dictionaire doivent être valides, un mot ne l'est pas, il a été skip");
                        probleme=true;
                    }
                }
                if (!probleme){
                    ajouterMot(mot);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
