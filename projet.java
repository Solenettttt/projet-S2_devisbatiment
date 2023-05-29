/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projet_s2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Thuy
 */
public class projet {

    public static void main(String[] args) {
     
      System.out.println("                   Bonjour! \n Veuillez entrer les donnees suivantes pour effectuer un calcul de devis ");
      System.out.println("Entrez l'identifiant du batiment que vous voulez creer: ");
      int id = Lire.i();
      Batiment n = new Batiment(id);
      System.out.println("\nLe devis de ce batiment est : ");
      System.out.println(n+" \n Le prix total de ce batiment est : "+ n.prixBatiment());
      {try
      {
          try (BufferedWriter Batiment = new BufferedWriter(new FileWriter("batiment.txt",true))) {
              Batiment.write("                   Bonjour! \n Veuillez entrer les donnees suivantes pour effectuer un calcul de devis ");
              Batiment.newLine();
              Batiment.write((int) n.prixBatiment());
              Batiment.newLine();
             // Batiment.write(Batiment.toString());
              Batiment.newLine();
              Batiment.write(Niveau.toString());
              Batiment.newLine();
              Batiment.write(Niveau.toString());
              Batiment.newLine();
              Batiment.close();
          }
        }
        catch (IOException err)
        {System.out.println("Erreur :\n"+err);}
        }
    }
}

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
      Appartemen  t a = new Appartement(2, 2);
      System.out.println(a.prixappart(1));
      System.out.println(a);
      ok */
      
      /*
      Niveau n = new Niveau(2);
      System.out.println(n.prixniveau(1));
      System.out.println(n);
okkkk*/