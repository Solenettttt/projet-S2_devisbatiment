/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.util.ArrayList;

/**
 *
 * @author Thuy
 */
public class Batiment {

    public int idBatiment;
    public static double hsp;
    public ArrayList<Niveau> niveaux;   //on créer une liste de niveau pour ce batiment

    Batiment(int id){
        this.idBatiment = id;
 
        System.out.println("Combien d'etages voulez vous dans ce batiment " + this.idBatiment);
        int n = Lire.i();
        while(n <= 0){  //on ne veut pas de nombre d'etage négatif
            System.out.println("Nombre d'étages inacceptable pour un nombre d'appartement " + (this.idBatiment));
            n = Lire.i();
        }
        
        System.out.println("Quelle est l'hauteur sous plafond de votre batiment " + this.idBatiment);
        this.hsp = Lire.i(); //enfin on defini hsp; on l'appele partout pour calcule du devis
        
        niveaux = new ArrayList<Niveau>(n);   //on initialise la taille de la liste de niveau pour contenir le bon nombre voulu

        for(int i = 0; i < n; i++){
            
            Niveau b = new Niveau(i+1);
            niveaux.add(b);
        }
        
        System.out.println("Batiment " + this.idBatiment + " creee");
    }
    
    public static double HSP(){    //static pour qu'on puisse recupere la valeur dans toute les autre classe   
        return Batiment.hsp;
    }
    
    //calcul du prix du batiment en additionnant le prix de chaque niveau
    public double prixBatiment(){
        double s =0 ;
        
        for (Niveau n : this.niveaux) {
            s += n.prixniveau(this.hsp);
        }
        return s;
     }

    //toString pour l'affichage sur la console du devis et appel successif des autres classe
    @Override
    public String toString() {
        return " Batiment "+ idBatiment + " de hsp " + hsp + " contient" + niveaux ;
        
    }
    
    
//pour la sauvegarde du devis dans un fichier texte
    public String afficher()
    {
        String s = "\n Batiment"+ idBatiment + " de hsp " + hsp + " contient : ";
        for(Niveau n : this.niveaux)
        {
            s += n.afficher() + "\n";
        }
        return s;
    
    }

    //getter pour recuperer la valeurs hsp dans les autre classe pour calculs du devis
    public double gethsp() {
        return this.hsp;
    }

    public void setHsp(int hsp) {
        this.hsp = hsp;
    }

    public int getIdBatiment() {
        return idBatiment;
    }

    public ArrayList<Niveau> getNiveaux() {
        return niveaux;
    }

   
     
    
}
