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
    //String[] attributs;
    //int revetementsaisie;
    //int trouve = 0;
    
    //int idrevchoisi;

    //construteur par default
    public Revetement(int idRevetement){
    this.idRevetement = idRevetement;
    try
    {
        
        BufferedReader revet=new BufferedReader(new FileReader("revs.txt"));
        String lignelue;// Ligne lue depuis le fichier
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
   
    //methode pour permettre l'utilisation des données du fichier texte revs en rangant dans une arraylist 
    public static ArrayList<Revetement> readDef() throws IOException{
        ArrayList<Revetement> rev = new ArrayList<Revetement>();
        try {
            FileReader fileReader = new FileReader("revs.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            line = bufferedReader.readLine();

            while (line != null) {      //Répète opération pour chaque ligne
                String[] mys = line.split(";");
                Revetement choix = new Revetement(0);

                try{        //range les données du fichier texte lu à ce qu'elles correspond pour pouvoir les utiliser
                    choix.idRevetement = Integer.parseInt(mys[0]);
                    choix.designation = mys[1];
                    choix.pourMur = (mys[2].equals("1"));
                    choix.pourSol = (mys[3].equals("1") );
                    choix.pourPlafond = (mys[4].equals("1") );
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
        
        catch(FileNotFoundException err){
        System.out.println("Erreur :le fichier n’existe pas!\n "+err);}

        catch(IOException err){
            System.out.println("Erreur :\n"+err);
        }/*
        if (trouve==0)
            System.out.println("Introuvable");
        return(0)*/
        return rev;
        }
      public static Revetement getRevetement(int id) {
     Revetement rev=new Revetement(id);   
        try{
        rev = Revetement.readDef().get(id-1);

    }catch(IOException error){
        
    }
        return rev;
    }  
    
        
    @Override
    public String toString()
    {
       // try {
            return ": ( Revetement " + this.idRevetement +"-"+ this.designation + " au prix unitaire de : " + this.prixUnitaire +')';
        /*} catch (IOException ex) {
            Logger.getLogger(Revetement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;*/
    }
   

}
