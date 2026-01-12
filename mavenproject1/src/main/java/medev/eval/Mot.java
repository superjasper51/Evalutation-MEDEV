/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julda
 */
public class Mot {
    private ArrayList<Character> reel;
    private List<Character> actuel;
    public Mot(String mot){
        mot = mot.toUpperCase();
        reel=new ArrayList<Character>();
        actuel=new ArrayList<Character>();
        for(int i=0; i<mot.length(); i++){
            reel.add(mot.charAt(i));
            actuel.add('_');
        }
    }
    
    public void majMotActuel(char c, int place){
        actuel.set(place,c);//L'affichage affichera la lettre entrée, y compris si celle-ci est en majuscule (mais ce n'est aps sensible à la casse pour le mot pour autant)
    }

    public String getReel() {
        String mot="";
        for(Character a : reel){
            mot=mot+a;
        }
        return mot;
    }

    public void setReel(ArrayList<Character> reel) {
        this.reel = reel;
    }

    public void setActuel(ArrayList<Character> actuel) {
        this.actuel = actuel;
    }

    public String getActuel() {
        String mot="";
        for(Character a : reel){
            mot=mot+a+" ";
        }
        return mot;
    }
    public boolean possede(Character c){
        String ch=c.toString();
        c= ch.toUpperCase().charAt(0);
        return reel.contains(c);
    }
}
