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
public class Piece {
    public int idPiece;
    public ArrayList<Mur> murs;
    public ArrayList<Ttsurfaces> solplafond;
  
    public Piece(int id){
        this.idPiece = id;
        this.murs = new ArrayList<Mur>();
        this.solplafond = new ArrayList<Ttsurfaces>();

        Coin c1 = new Coin(1);
        Coin c3 = new Coin(3);
        Coin c2 = new Coin(2, c1.getX(), c3.getY());
        Coin c4 = new Coin(4, c1.getY(), c3.getX());
        
        Mur m1 = new Mur(1, c1, c2);
        Mur m2 = new Mur(2, c2, c3);
        Mur m3 = new Mur(3, c3, c4);
        Mur m4 = new Mur(4, c4, c1);
        
        murs.add(m1);
        murs.add(m2);
        murs.add(m3);
        murs.add(m4);
        
        Sol sol = new Sol(murs);
        Plafond plafond = new Plafond(murs);

        this.solplafond.add((Ttsurfaces)sol);
        this.solplafond.add((Ttsurfaces)plafond);
           
        System.out.println("Piece creee");
        

    }
    
     
    //calcul du cout en fonction de suface et revetement determiné
    
   public double calculrevetement(double hsp){
        double res = 0;
        for(Mur mur : this.murs){//pour tous les murs
            if(mur.revetement != null) res += mur.surface(hsp) * mur.revetement.prixUnitaire;
        }
        for(Ttsurfaces s : solplafond){  //calculs pour tous sols et plafonds
            if(s instanceof Sol){   //si c'est un sol
                Sol sol = (Sol) s;
                res += sol.surface(hsp) * sol.revetement.prixUnitaire;
            }
            else if(s instanceof Plafond){//si c'est un plafond
                Plafond plaf = (Plafond) s;
                res += plaf.surface(hsp) * plaf.revetement.prixUnitaire;
            }
        }
        return res;
    }  
   
    @Override
    public String toString() {
        String s = "\n  La Piece " + idPiece + " qui contient " ;
        for(int i = 0; i < murs.size(); i++)
        {
            s += murs.get(i).toString();
        }
        for(Object t : solplafond)
        {
            if(t instanceof Sol)
            {
                Sol downcastedObject = (Sol) t;      //downcast pour pouvoir utiliser les éléments de la classe
                s += downcastedObject.toString();
            }
            if(t instanceof Plafond)
            {
                Plafond d = (Plafond) t;
                s += d.toString();
            }
        }
        return s;
    }
 
   
  
}
    

