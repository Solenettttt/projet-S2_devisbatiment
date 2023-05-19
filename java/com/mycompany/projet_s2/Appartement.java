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
public class Appartement {
    private int idAppartement;
    private int niveauAppartement;
    public ArrayList<Piece> pieces;

    Appartement(int id, int niv)
    {
        this.idAppartement = id;
        this.niveauAppartement = niv;
        
        System.out.println("Combien de pieces voulez vous pour l'appartement " + this.idAppartement);

        int n = Lire.i();
        while(n <= 0)
        {
            System.out.println("Nombre de pieces inacceptable pour l'appartement " + (this.idAppartement));
            n = Lire.i();
        }
        pieces = new ArrayList<Piece>(n);

        for(int i = 0; i < n; i++){
            Piece p = new Piece(i+1);
            pieces.add(p);
        }

        System.out.println("Appartement " + this.idAppartement + " creee");
        
    }    
}
