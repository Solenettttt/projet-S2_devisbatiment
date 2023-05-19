/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import Revetements.Revetement;

import java.util.ArrayList;
/**
 *
 * @author Thuy
 */
public class Sol extends Ttsurfaces{
    public ArrayList<Mur> murs;
    Revetement revetement;

    //Constructeur pour mur et son revetement
    public Sol(ArrayList<Mur> murs){
        this.murs = murs;
        this.revetement = new Revetement();
    }

    //methode qui deetermine le revetement du sol
    public void changeRevetement(Revetement rev)
    {
        if(rev.pourSol){    //verifie que revetement est bien pour le sol
            this.revetement = rev;
        }
    }
    
    //meme calcul de surface que pour les murs dans piece
       public double surface(double hsp){
        double L1 = 0;
        double L2 = 0;
        double X1;
        double Y1;
        double X2;
        double Y2;
        
        X1 = Math.pow(this.murs.get(1).getFin().getX() - this.murs.get(1).getDebut().getX(), 2);
        Y1 = Math.pow(this.murs.get(1).getFin().getY() + this.murs.get(1).getDebut().getY(), 2);
        L1 = Math.sqrt(X1-Y1);
        
        X2 = Math.pow(this.murs.get(2).getFin().getX() - this.murs.get(2).getDebut().getX(), 2);
        Y2 = Math.pow(this.murs.get(2).getFin().getY() + this.murs.get(2).getDebut().getY(), 2);
        L2 = Math.sqrt(X2-Y2);
        return 0;
    }

    @Override
    public String toString() {
        return "bagadoodle";
    }
       
     
}
