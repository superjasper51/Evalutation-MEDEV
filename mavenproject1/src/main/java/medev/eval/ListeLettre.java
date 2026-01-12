/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nathan
 */
public class ListeLettre {
    private final ArrayList<Character> alphabet;
    private final ArrayList<Character> essais;
    public ListeLettre(){
        this.alphabet=new ArrayList<>(List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
        this.essais=new ArrayList<>(24);
    }
    
    public void proposer(String lettre, Mot mot){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tapez un caractère : ");//NO SONAR
        String c = scanner.nextLine();
        boolean test=false;
        for(char character :alphabet)
            if (character==c){
                test=true;
                break;
        }
        if (!test){
            System.out.println("Ceci n'est pas un caractère valide");//NO SONAR
            proposer(lettre,mot);
        }
        else{
            
        }
        System.out.println("La chaîne d'entrée utilisateur est : " + c);   
    }
    
}
