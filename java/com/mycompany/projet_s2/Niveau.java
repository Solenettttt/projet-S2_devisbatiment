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
    public ArrayList<Appartement> appartements;

    Niveau(int id){
        this.idNiveau = id;
 /*
        appartements = new ArrayList<Appartement>(nbreApparts);

        Appartement fooba;

        for(int i = 0; i < nbreApparts; i++)
        {
            fooba = new Appartement(id, idNiveau);
            appartements.add(fooba);
        }*/
        System.out.println("Combien d'appartement voulez vous dans ce niveau  " + this.idNiveau);
        int n = Lire.i();
        
        while(n <= 0){  //on ne veut pas de nombre d'appart négatif
            System.out.println("Nombre d'appart est  pas cceptable pour un nombre d'appartement " + (this.idNiveau));
            n = Lire.i();
        }
        
        appartements = new ArrayList<Appartement>(n);   //on initialise la taille de la liste de pièce pour contenir le bon nombre voulu

        for(int i = 0; i < n; i++){
            Appartement a = new Appartement(i+1);
            appartements.add(a);
        }
        
        System.out.println("Niveau " + this.idNiveau + " creee");
    }
    
    public double prixniveau(double hsp){
        double s =0 ;
        
        for (Iterator<Appartement> it = this.appartements.iterator(); it.hasNext();) {
            Appartement a = it.next();
            //this.piece downcastedObject = (this.piece) piece;
            s += a.prixappart(hsp);
        }
        return s;
     }

    @Override
    public String toString() {
        return "\n Niveau " + idNiveau + " qui contient " + appartements ;
    }
     
     
    
}