/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

//import Revetements.Revetement;

import java.util.ArrayList;
/**
 *
 * @author Thuy
 */
public class Sol extends Ttsurfaces{
    public ArrayList<Mur> murs;
    Revetement revetement;
    private int idrev;


    //Constructeur pour mur et son revetement
    public Sol(ArrayList<Mur> murs){
        this.murs = murs;
        //System.out.println("Quel revetement voulez vous pour le sol de cette piece?");
        //this.idrev=Lire.i();
        //this.revetement = new Revetement(idrev);
        definirRevetement();
    }

    //methode qui deetermine le revetement du sol
    @Override
    public void definirRevetement()
    {
        System.out.println("Quel revetement voulez vous pour le sol de cette piece?");
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourSol){//verifie que revetement est bien pour le sol
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
    }
    /*  public void definirRevetement()
    {
        System.out.println("Quel revetement voulez vous pour le plafond de cette piece?");
        //this.revetement = Lire;
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourSol){//verifie que revetement est bien pour le plafond
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
        
    }*/
  
    //meme calcul de surface que pour les murs dans piece
    @Override
       public double surface(){
        double L1;
        double L2;
        
        //L1 = Math.abs(this.murs.get(4).getFin().getX() - this.murs.get(1).getDebut().getX());
        //L2 = Math.abs(this.murs.get(4).getFin().getY() - this.murs.get(3).getDebut().getY());
        L1 = this.murs.get(1).longueur();
        L2 = this.murs.get(2).longueur();
        
        return L1*L2;
    }
    @Override
    public String toString() {
        return "\n Sol de surface " + surface() + "  ; utilisant: " + revetement + " ; au cout de "+ Revetement.montant(revetement, surface());
    }
       
     
}
