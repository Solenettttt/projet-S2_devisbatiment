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
public class Appartement {
    public int idAppartement;
    public int niveauAppartement;
    public ArrayList<Piece> pieces;

    public Appartement(int id){
        this.idAppartement = id;
        //this.niveauAppartement = niv;
        
        System.out.println("Combien de pieces voulez vous pour l'appartement " + this.idAppartement);

        int n = Lire.i();
        while(n <= 0){  //on ne veut pas de nombre de pièce négatif
            System.out.println("Nombre de pieces inacceptable pour l'appartement " + (this.idAppartement));
            n = Lire.i();
        }
        
        pieces = new ArrayList<Piece>(n);   //on initialise la taille de la liste de pièce pour contenir le bon nombre voulu

        for(int i = 0; i < n; i++){
            Piece p = new Piece(i+1);
            pieces.add(p);
        }

        System.out.println("Appartement " + this.idAppartement + " creee");
        
    }    
    
     public double prixappart(double hsp){
        double s =0 ;
        /* for(int i = 0; i < pieces.size(); i++){
        s+= Piece(i).calculrevetement(hsp);
        }*/
        for (Iterator<Piece> it = this.pieces.iterator(); it.hasNext();) {
            Piece p = it.next();
            //this.piece downcastedObject = (this.piece) piece;
            s += p.calculrevetement(hsp);
        }
        return s;
     }
     
     
    @Override
    public String toString() {
        String s = "\n L'Appartement " + idAppartement + " qui contient " + pieces ;
        /*
        for(int i = 0; i < pieces.size(); i++)
        {
            s += pieces.get(i).toString();
        }*/
        return  s;
    }
    
    
    
}
