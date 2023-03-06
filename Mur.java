/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.projet_s2;
import java.lang.Math;

        /**
         *
         * @author atassart01
         */

public class Mur {

    int idMur;
    Coin debut;
    Coin fin;
    double hsp;

    public Mur(int idMur, Coin dbut, Coin fin) {
        this.idMur = idMur;
        this.debut = debut;
        this.fin = fin;
    }
//public String toString(){
//        return this.idCoin + " " + this.cx + " " + this.cy;}

    public double longueur(Coin debut, Coin fin) {
        return Math.sqrt(Math.pow((debut.getX() - fin.getX()), 2) + Math.pow((debut.getY() - fin.getY()), 2));

    }

    public double surface(Mur m) {

        return hsp*m.longueur(debut, fin);
    }

    public String toString() {
        return "Mur{" + "idMur=" + idMur + ", debut=" + debut + ", fin=" + fin + '}';
    }

}
