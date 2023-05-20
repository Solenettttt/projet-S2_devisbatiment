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
    @Override
    public void changeRevetement(Revetement rev)
    {
        if(rev.pourSol){    //verifie que revetement est bien pour le sol
            this.revetement = rev;
        }
    }
  
    //meme calcul de surface que pour les murs dans piece
    @Override
       public double surface(double hsp){
        double L1 = 0;
        double L2 = 0;
        
        //L1 = Math.abs(this.murs.get(4).getFin().getX() - this.murs.get(1).getDebut().getX());
        //L2 = Math.abs(this.murs.get(4).getFin().getY() - this.murs.get(3).getDebut().getY());
        L1 = this.murs.get(1).longueur();
        L2 = this.murs.get(2).longueur();
        
        return L1*L2;
    }
    @Override
    public String toString() {
        return "solok";
    }
       
     
}
