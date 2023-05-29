/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Thuy
 */
public class Piece {
    public int idPiece;
    public ArrayList<Mur> murs;
    public ArrayList<Ttsurfaces> solplafond;
    double hsp;
    //Batiment objet = new Batiment(1);
    
    public Piece(int id){
        this.hsp = Batiment.hsp;
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
    
     
    //calcul du cout de la piece en fonction de suface et revetement determiné
   public double calculrevetement(double hsp){
        double res = 0;
        for(Mur mur : this.murs){       //pour tous les murs de la arrayliste
            if(mur.revetement != null) res += mur.surface() * mur.revetement.prixUnitaire;
        }
        
        for(Ttsurfaces s : solplafond){     //calculs pour tous sols et plafonds de la array liste solplafond
            if(s instanceof Sol){           //si c'est un sol:
                Sol sol = (Sol) s;
                res += sol.surface() * sol.revetement.prixUnitaire;
            }
            else if(s instanceof Plafond){  //si c'est un plafond:
                Plafond plaf = (Plafond) s;
                res += plaf.surface() * plaf.revetement.prixUnitaire;
            }
        }
        
        return res;
    }  
   
       //toString pour l'affichage sur la console et dans le fichier devis de la piece et de ses données=liste de murs, sol et plafond
    @Override
    public String toString() {
        String s = "\n     La Piece " + idPiece + " qui contient : " ;
        for(int i = 0; i < murs.size(); i++)
        { 
            try {
                s += murs.get(i).afficher();
            } catch (IOException ex) {
                System.out.println("Type de revetement n'existe pas");
            }        
        }
        for(Object t : solplafond)
        {
            if(t instanceof Sol downcastedObject){
                s += downcastedObject.toString();//downcast pour pouvoir utiliser les éléments de la classe
            }
            if(t instanceof Plafond d){
                s += d.toString();
            }
        }
        s += "\n Le cout de cette piece"+ idPiece+" est de : "
                + calculrevetement(hsp);
        return s;
    }
   
  
}
    

