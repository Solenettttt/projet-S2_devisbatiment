 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.util.ArrayList;



public class Appartement {
    public int idAppartement;
    public ArrayList<Piece> pieces;

    public Appartement(int id){
        this.idAppartement = id;
        
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
    
    //calcul du prix de l'appartement en additionnant le prix de chaque piece
     public double prixappart(double hsp){
        double s =0 ;
        
        for (Piece p : this.pieces) {
            s += p.calculrevetement(hsp);
        }
        return s;
     }
     
     
    //toString pour l'affichage sur la console de l'appart et appel successif des autres classe(piece)
    @Override
    public String toString() {
        String s = "\n    L'Appartement " + idAppartement + " qui contient " + pieces ;      
        return  s;
    }
    
    //Affichage pour la sauvegarde du devis dans un fichier texte
    public String afficher()
    {
        String s = "\n    L'Appartement " + idAppartement + " qui contient :  " ;
        for(Piece p : this.pieces)
        {
            s +=  p.toString() + "\n";
        }
        return s;
    }
    
    
    
}
