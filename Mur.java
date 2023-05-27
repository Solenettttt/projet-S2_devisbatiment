/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2; 

import java.io.BufferedReader;
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
/*
    public int getIdrev() {     //on recupere l'identifiant du revetement
        return idrev;
    }

    public Revetement getRevetement() {
        return revetement;
    }
   
    
    public double getPrice() throws IOException {

        try
        {
        BufferedReader flux = new BufferedReader(new FileReader("revs.txt"));
        String lignelue;

        while((lignelue=flux.readLine())!=null){        //on vérifie à chaque ligne
            
            //on décompose en chaine de caratères avec la méthode split de la classe String
            attributs = lignelue.split(";");    //et on range les attributs dans une liste de String
            
            if (Double.parseDouble(attributs[0])==(this.idrev)){
                return(Double.parseDouble(attributs[5]));       //on recupere le prix du revetement selectionné
            }
        }
        flux.close();
        }       //try-catch pour recuper et identifier les erreurs plus efficacement
        catch(FileNotFoundException err){
            System.out.println("Erreur :le fichier n’existe pas!\n "+err);}
        catch(IOException err){
            System.out.println("Erreur :\n"+err);}
        if (trouve==0)
            System.out.println("Introuvable");
        return(0);
        }
   
*/
    //Methode calcule de longueur du mur horizontale ou verticale
    public double longueur() {
        return Math.sqrt(Math.pow(Math.abs(this.debut.getX() - this.fin.getX()), 2) + Math.pow(Math.abs(this.debut.getY() - this.fin.getY()), 2));
    }
   
    //Methode pour verifier que le revetement est pour un mur et le définir comme revetement du mur
   @Override
      public void definirRevetement()
    {
        System.out.println("Quel revetement voulez vous pour le mur "+ idMur +" de cette piece?");
        //this.revetement = Lire;
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourMur){//verifie que revetement est bien pour le plafond
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
        
    }
    
    
    //Methode pour calculer la surface du mur
    @Override
    public double surface() 
    {
        return Batiment.hsp * this.longueur();
    }

    /*
    @Override
    public String toString()
    {
        return "\n Mur " + this.idMur + " de coin de debut: ( " + this.debut.getX() + " , " + this.debut.getY() + " ) "
             +  "; de coin de fin: ( " + this.fin.getX() + " , " + this.fin.getY() + " ) " ;
    }
    */
    
    public String afficher() throws IOException
    {
        return "\n Mur : " + this.idMur + " coin de debut( " + this.debut.getX() + " , " + this.debut.getY() + " ) "
             +  "; coin de fin( " + this.fin.getX() + " , " + this.fin.getY() + " ) " + " ; utilisant" + revetement 
                + " ; au cout de finale de " + Revetement.montant(revetement, surface());
        
    }
    
    void dessiner(){
    }
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
