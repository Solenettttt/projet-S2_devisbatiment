/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projet_s2;
import Revetements.Revetement;



/**
 *
 * @author Thuy
 */
public class projet {

    public static void main(String[] args) {
        int i;
      /*  for(i == 0, i<100, i++){
        Coin c1;
        System.out.println("Donner les coordonnées du point");
        int id = Lire.i();
        double x = Lire.d();
        double y = Lire.d();
        c1 = new Coin (id, x, y);
        System.out.println(c1.toString());}
        */
      //Coin n = new Coin(5);
      //Mur m = new Mur(3);
      
      
      //Piece p = new Piece(5);
      //Piece p1 = new Piece(4);
      //p.murs.get(0).changeRevetement(new Revetement(0, "Peinture", true, true, true, 10.0d));
      //System.out.println(p.calculrevetement(1));
     //System.out.println(p);ok
     
     
      /*
      Appartement a = new Appartement(2, 2);
      System.out.println(a.prixappart(1));
      System.out.println(a);
      ok */
      
      /*
      Niveau n = new Niveau(2);
      System.out.println(n.prixniveau(1));
      System.out.println(n);
okkkk*/
      
      Batiment n = new Batiment(6);
      System.out.println(n.prixBatiment(1));
      System.out.println(n);
    }
}

