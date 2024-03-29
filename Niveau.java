/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Thuy
 */
public class Niveau { 
    public int idNiveau;
    public int hsp;
    public ArrayList<Appartement> appartements; //on créer une liste d'appart pour ce batiment

    Niveau(int id){
        this.idNiveau = id;

        System.out.println("Combien d'appartement voulez vous dans ce niveau  " + this.idNiveau);
        int n = Lire.i();
        
        while(n <= 0){  //on ne veut pas de nombre d'appart négatif
            System.out.println("Nombre d'appart est  pas cceptable pour un nombre d'appartement " + (this.idNiveau));
            n = Lire.i();
        }
        
        appartements = new ArrayList<Appartement>(n);   //on initialise la taille de la liste d'appart pour contenir le bon nombre voulu

        for(int i = 0; i < n; i++){
            Appartement a = new Appartement(i+1);
            appartements.add(a);
        }
        
        System.out.println("Niveau " + this.idNiveau + " creee");
    }
    
    //calcul du prix de ce niveau en additionnant le prix de chaque appartement
    public double prixniveau(double hsp){
        double s =0 ;
        
        for (Appartement a : this.appartements) {
            s += a.prixappart(hsp);
        }
        return s;
     }

    //affiche en console le niveau et ce qu'il contient(appartement)
    @Override
    public String toString() {
        return "\n   Niveau " + idNiveau + " qui contient " + appartements ;
    }
    
    //Affichage pour la sauvegarde du devis dans un fichier texte
    public String afficher()
    {
        String s = "\n   Niveau " + idNiveau + " qui contient : "  ;
        for(Appartement app : this.appartements)
        {
            s += app.afficher() + "\n";
        }
        return s;
    }
     
     
    
}