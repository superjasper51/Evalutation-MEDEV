/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

/**
 *
 * @author julda
 */
public class Mot {
    String reel;
    String actuel;
    public Mot(String mot){
        reel=mot;
        actuel="_";
        for(int i=1; i<reel.length(); i++){
            actuel=actuel+" _";
        }
    }
}
