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
      System.out.println("\nLe devis de ce batiment est : \n"+n);
      System.out.println(" \n Le prix total de ce batiment est : "+ n.prixBatiment());
      {try
      {
          try(BufferedWriter batiment = new BufferedWriter(new FileWriter("batiment.txt",false))) {
              batiment.write("                   Bonjour! \n Voici votre le devis correspondant au Batiment que vous venez de construire: ");
              batiment.newLine();
              batiment.write(n.afficher());
              batiment.newLine();
              batiment.write("\n Le prix total de ce batiment est :" );
              batiment.write(Double.toString( n.prixBatiment()) );
              batiment.close();
          }
        }
        catch (IOException err)
        {System.out.println("Erreur :\n"+err);}
        }
      
    /*  menuSauvegarde();
      
       public void menuSauvegarde() {
        try
        {
            String fichier = "./File/Batiment.txt";
            BufferedWriter file =new BufferedWriter(new FileWriter(fichier, false));
            // nom du batiment + surface +
            file.append(n.getIdBatiment() + ";" + n.prixBatiment() + ";" +"\n");
            
            // écriture des désignation des colonnes
            file.append(Piece.labelSauvegarde() +"\n");
           
            // liste des pièces
            for (int i=0;i<this.Piece.getMurs().size();i++)
            {
                this.model.getListePieces().get(i).sauvegarde(file);
                file.append('\n');
            }
            file.close();

        }
        catch(FileNotFoundException err){
            messageError("Erreur :le fichier n’existe pas!\n "+err.toString());
        }
        catch (IOException err){
            messageError(" Erreur :\n "+err);
        }
    }

    private void messageError(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
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