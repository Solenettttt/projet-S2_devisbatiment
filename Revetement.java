/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

//import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thuy
 */
public class Revetement {   
    
    int idRevetement;
    public boolean pourMur;
    public boolean pourSol;
    public boolean pourPlafond;
    String designation;
    public double prixUnitaire;

    //construteur par default
    public Revetement(int idRevetement){
    this.idRevetement = idRevetement;
    try
    {
        
        BufferedReader revet=new BufferedReader(new FileReader("revs.txt"));
        String lignelue;        // Ligne lue depuis le fichier
           while((lignelue=revet.readLine())!=null )
           {
               StringTokenizer separation=new StringTokenizer(lignelue, ";");
               String[] revetI = {separation.nextToken(),separation.nextToken(),separation.nextToken(),separation.nextToken(),separation.nextToken(),separation.nextToken()};

               if (String.valueOf(idRevetement).equals(revetI[0])){
                   this.designation= revetI[1];
                   this.prixUnitaire= Double.valueOf(revetI[5]);
                   this.pourMur= Integer.valueOf(revetI[2])==1;
                   this.pourSol= Integer.valueOf(revetI[3])==1;
                   this.pourPlafond= Integer.valueOf(revetI[4])==1;
               }
           }
        revet.close();
    }
    catch(FileNotFoundException err){
    System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
    catch (IOException err){
    System.out.println(" Erreur :\n "+err);}
   
    
}

    public int getIdRevetement() {
        return idRevetement;
    }

    
    //methode calcul du prix en fonction du prix unitaire du rev et surface choisi
    public static double montant(Revetement R, double s)
    {
        return R.prixUnitaire * s;
    }
   /*
      public static Revetement getRevetement(int id) {
     Revetement rev=new Revetement(id);   
        try{
        rev = Revetement.readDef().get(id-1);

    }catch(IOException error){
        
    }
        return rev;
    }  
    */
        
    @Override
    public String toString()
    {
            return ": ( Revetement " + this.idRevetement +"-"+ this.designation + " au prix unitaire de : " + this.prixUnitaire +')';
       
    }
   

}
