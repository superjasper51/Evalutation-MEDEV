/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medev.eval;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author julda
 */
public class Tool {
    int erreur;
    ListeLettre lettres;
    Mot mot;
    Parametre param;
    ArrayList<ArrayList<Character>> dessin;
    
    public Tool(Mot mot){
        this.lettres=new ListeLettre();
        this.mot=mot;
        this.erreur=0;
        this.dessin=new ArrayList<ArrayList<Character>>();
        ArrayList<Character> e=new ArrayList<Character>();
            for(int j=0;j<7;j++){
                e.add(' ');
            }
        for(int i=0;i<12;i++){
            dessin.add(e);
        }
        for(int i=0;i<7;i++){
            e.set(i,'=');
        }
        dessin.add(e);
    }
    
    
    public void afficher(){
        System.out.println("Les lettres déjà proposées sont :"+lettres.getEssais());
        this.afficheDessin();
        System.out.println(mot.getActuel());
    }
    public void afficheDessin(){
        for(ArrayList<Character> ligne : dessin){
            String stringLigne="";
            for(Character c : ligne){
                stringLigne=stringLigne+c.toString();
            }
            System.out.println(stringLigne);
        }
    }
    public void majDessin(){
        ArrayList<Character> ligne0=dessin.get(0);
        ArrayList<Character> ligne1=dessin.get(2);
        ArrayList<Character> ligne2=dessin.get(4);
        ArrayList<Character> ligne3=dessin.get(6);
        ArrayList<Character> ligne4=dessin.get(8);
        ArrayList<Character> ligne5=dessin.get(10);
        
        if(erreur==1){
            ligne0.set(5,'+');
            dessin.set(0,ligne0);
            for(int i=2; i<=10; i=i+2){
                ArrayList<Character> lignei=dessin.get(i);
                lignei.set(5,'|');
                dessin.set(i, lignei);
            }
        }
        if(erreur==2){
            ligne0.set(1,'+');
            ligne0.set(2,'-');
            ligne0.set(3,'-');
            ligne0.set(4,'-');
            dessin.set(0, ligne0);
        }
        if(erreur==3){
            ligne1.set(1,'|');
            dessin.set(2, ligne1);
        }
        if(erreur==4){
            ligne2.set(1,'0');
            dessin.set(4,ligne2);
        }
        if(erreur>=4 && param.getNbErreurMax()*erreur/9>=5){
            ligne3.set(1,'|');
            ligne4.set(1,'|');
            dessin.set(6,ligne3);
            dessin.set(8,ligne4);
        }
        if(erreur>=4 && param.getNbErreurMax()*erreur/9>=6){
            ligne3.set(0,'/');
            dessin.set(6,ligne3);
        }
        if(erreur>=4 && param.getNbErreurMax()*erreur/9>=7){
            ligne3.set(2,'\\');
            dessin.set(6,ligne3);
        }
        if(erreur>=4 && param.getNbErreurMax()*erreur/9>=9){
            ligne5.set(2,'\\');
            dessin.set(10,ligne5);
        }
        if(erreur>=4 && param.getNbErreurMax()*erreur/9>=8){
            ligne5.set(0,'/');
            dessin.set(10,ligne5);
        }
    }
    public void MAJ(){
        boolean continuer=true;
        while(continuer){
        char propal;//proposition lettre
        Scanner scanner = new Scanner(System.in);

        System.out.print("Veuillez entrer votre lettre : ");
        String lettreStr = scanner.nextLine();
        if (!lettreStr.isEmpty()){
            propal= lettreStr.charAt(0);
            this.lettres.proposer(propal,mot);
        }
        
        if(this.erreur>=this.param.getErreurMax()){
            continuer=false;
            System.out.println("Vous avez perdu");
        }
        else{
            if(this.mot.getReel()==this.mot.getActuel()){
                continuer=false;
                System.out.println("Bravo, vous avez gagné");
            }
        }
        }
    }

    /**
     *
     * @return un mot du dictionaire
     */
    public static String indice(){
            int n=lettres.getDictionaire().size();
            Random random=new Random();
            int indice;
            indice = random.nextInt(n);
            return lettres.getDictionaire().index(indice);
        }
}
