/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projet_s2;

import Revetements.Revetement;

/**
 *
 * @author Thuy
 */
public abstract class Ttsurfaces {
    abstract double surface(double hsp);
    abstract void changeRevetement(Revetement rev);
    /*
    public void changeRevetement(Revetement rev)
    {
        if(rev.pourSol)     //verifie que revetement est bien pour le sol
        {    
            this.revetement = rev;
        }else if(rev.pourPlafond)   //verifie que revetement est bien pour le plafond
        {     
            this.revetement = rev;
        }
        if(rev.pourMur)
        { 
            this.revetement = rev;
        }
    }
    public double surface(double hsp){    
        if (instanceof Mur){
            
        return hsp * this.longueur();
        
        }else{
        double L1 = 0;
        double L2 = 0;
        double L;
        
        L1 = Math.abs(this.murs.get(4).getFin().getX() - this.murs.get(1).getDebut().getX());
        L2 = Math.abs(this.murs.get(4).getFin().getY() - this.murs.get(3).getDebut().getY());
        
        L = L1*L2;
        return L;}
    }*/
}
