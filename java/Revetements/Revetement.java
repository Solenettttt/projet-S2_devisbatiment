/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Revetements;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Thuy
 */
public class Revetement {   //astraite
    int idRevetement;
    public boolean pourMur;
    public boolean pourSol;
    public boolean pourPlafond;
    String designation;
    public double prixUnitaire;

    //construteur par default
    public Revetement()
    {
        idRevetement = 0;
        pourMur = false;
        pourSol = false;
        pourPlafond = false;
        designation = "";
        prixUnitaire = 0;
    }
    
    
    //constructeur pour définir un revetement
    public Revetement(int id, String nom, boolean mur, boolean sol, boolean plafond, double prix)
    {
        this.idRevetement = id;
        this.designation = nom;
        this.pourMur = mur;
        this.pourSol = sol;
        this.pourPlafond = plafond;
        this.prixUnitaire = prix;
    }

    
    //methode calcul du prix en fonction du prix unitaire du rev et surface choisi
    public static double montant(Revetement R, double s)
    {
        return R.prixUnitaire * s;
    }
    
    //methode pour permettre l'utilisation des données du fichier texte revs en rangant dans une arraylist 
    public static ArrayList<Revetement> readDef(){
        ArrayList<Revetement> rev = new ArrayList<Revetement>();
        try {
            FileReader fileReader = new FileReader("Revetements/revs.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            line = bufferedReader.readLine();

            while (line != null) {
                String[] mys = line.split(";");
                Revetement choix = new Revetement();

                try{
                    choix.idRevetement = Integer.parseInt(mys[0]);
                    choix.designation = mys[1];
                    choix.pourMur = (mys[2].equals("1") );
                    choix.pourSol = (mys[3].equals("1") );
                    choix.pourPlafond = (mys[4].equals("1") ? true : false );
                    choix.prixUnitaire = Double.parseDouble(mys[5]);

                    rev.add(choix);
                }
                catch(NumberFormatException e)
                {
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            fileReader.close();

        }

        catch (IOException e){
                    }
        return rev;
    }
        
    @Override
    public String toString()
    {
        return ": Revetement " + this.idRevetement + " : " + this.designation + " a un prix unitaire de : " + this.prixUnitaire;
    }
   

}
