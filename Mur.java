/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
        


/**
 *
 * @author Thuy
 */
public class Mur extends Ttsurfaces{
    private final int idMur;
    private  Coin debut;     //Point de départ du mur
    private  Coin fin;     //Point de fin du mur
    //private int nmbrPortes;     extention
    //private int nmbrFenetres;   
    String[] attributs;
    //int revetementsaisie;
    int trouve = 0;
    Revetement revetement;
    public int idrev; 
    public double prix; 

    
     //Constructeur pour le  premier mur: avec coins données
       public Mur(int id, Coin c1, Coin c2) {
        this.debut = c1;
        this.fin = c2;
        this.idMur = id;
        //this.nmbrFenetres = 0;
        //this.nmbrPortes = 0;
        //System.out.println("quel revetement vouleez vous pour le mur "+idMur+'?');
        //this.revetement = Lire;
        //this.idrev=Lire.i();

        //this.revetement = new Revetement(idrev);
        definirRevetement();
    }

    
    //methode qui détermine le revetement pour un mur et le définit comme le revetement du mur
    @Override
    public void definirRevetement()
    {
        System.out.println("Quel revetement voulez vous pour le mur"+ idMur +" de cette piece?");
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourMur){//verifie que revetement est bien pour le sol
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
    }
    //Methode calcule de longueur du mur horizontale ou verticale
    public double longueur() {
        return Math.sqrt(Math.pow(Math.abs(this.debut.getX() - this.fin.getX()), 2) + Math.pow(Math.abs(this.debut.getY() - this.fin.getY()), 2));
    }
    // calcul de surface que pour les murs
    @Override
       public double surface(){
        return Batiment.hsp* this.longueur();
    }
       
       
    @Override
    public String toString()
    {
        return "\n Mur " + this.idMur + " de coin de debut: ( " + this.debut.getX() + " , " + this.debut.getY() + " ) "
             +  "; de coin de fin: ( " + this.fin.getX() + " , " + this.fin.getY() + " ) " ;
    }
    
    
    public String afficher() throws IOException
    {
        return "\n Mur : " + this.idMur + " coin de debut( " + this.debut.getX() + " , " + this.debut.getY() + " ) "
             +  "; coin de fin( " + this.fin.getX() + " , " + this.fin.getY() + " ) " + " ; utilisant" + revetement 
                + " ; au cout de finale de " + Revetement.montant(revetement, surface());
        
    }
    
    void dessiner(){
    }
    
     public void sauvegarde(BufferedWriter bWriter) throws IOException{
        bWriter.append(this.idMur +";"+";"+ this.surface() +";" +
                toString() );
    }

    public static String labelSauvegarde(){
        return "idMur;Nb fenêtres;Nb portes;Surface mur; id revètement mur;";
    }
        // this.nbFenetres +";"+ this.nbPortes +
    
    /*
    //Methode pour ajouter des fenetres
    public void addFenetres(int n)          
    {
        this.nmbrFenetres += n;
    }

    //Methode pour ajouter des portes au mur 
    public void addPortes(int n)    
    {
        this.nmbrPortes += n;
    }
*/
    
    //methodes getters

    public Coin getDebut()
    {
        return this.debut;
    }

    public Coin getFin()
    {
        return this.fin;
    }
/*
    public int getNFenetres()         
    {
        return this.nmbrFenetres;
    }

    public int getNPortes()             
    {
        return this.nmbrPortes;
    }
*/
    
    //Methode setters changer coin de depart
    public void setDebut(Coin d)
    {
        this.debut = d;
    }

    public void setFin(Coin d)
    {
        this.fin = d;
    }

    public int getID()
    {
        return this.idMur;
    }

    public int getIdDebut()
    {
        return debut.getId();
    }

    public int getIdFin()
    {
        return fin.getId();
    }

    public Revetement getRevetement() {
        return revetement;
    }

    public void setRevetement(Revetement revetement) {
        this.revetement = revetement;
    }
    
    

}
