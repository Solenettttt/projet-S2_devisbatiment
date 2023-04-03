/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com_insa.trieu.solene.mycompany.devisbatiment;

/**
 *
 * @author strieu01
 */
public class Peinture extends Revetement {

    public Peinture(int idRevetement, double PrixU) {
        super(idRevetement, PrixU);
    }
    

    
    
    @Override
    public double montant (double surface){
        double montant = surface * PrixU;
        return montant;
    }
    
//    créer exception pour ne pas l'appliquer au sol
  }
