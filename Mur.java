/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2; 

import java.io.IOException;
      

/**
 *
 * @author Thuy
 */
public class Mur extends Ttsurfaces{
    private final int idMur;
    private  Coin debut;     //Point de départ du mur
    private  Coin fin;     //Point de fin du mur
    private int nmbrPortes;    
    private int nmbrFenetres;   
    Revetement revetement;
    public int idrev; 
    public double prix; 

    
     //Constructeur pour le  premier mur: avec coins données
       public Mur(int id, Coin c1, Coin c2) {
        this.debut = c1;
        this.fin = c2;
        this.idMur = id;
        this.nmbrFenetres = 0;
        this.nmbrPortes = 0;
       
        definirRevetement();
        
        //definir ouverture voulu
        System.out.println("Combien de porte voulez vous pour le mur "+idMur+'?');
        this.nmbrPortes=Lire.i();
        System.out.println("Combien de fenetre voulez vous pour le mur "+idMur+'?');
        this.nmbrFenetres=Lire.i();
    }

       
    //Methode calcule de longueur du mur horizontale ou verticale
    public double longueur() {
        return Math.sqrt(Math.pow(Math.abs(this.debut.getX() - this.fin.getX()), 2) + Math.pow(Math.abs(this.debut.getY() - this.fin.getY()), 2));
    }
    
    
    // calcul de surface que pour les murs: hereditaire de Ttsurface
    //on y soustrait les surface vide=ouverture de portes et fenetres avec dimension fixé
    @Override
       public double surface(){
        return Batiment.hsp* this.longueur() - 3 * nmbrPortes - 2 * nmbrFenetres;
    }
       
       
    //methode qui détermine le revetement pour un mur et le définit comme le revetement du mur
    @Override
    public void definirRevetement()
    {
        System.out.println("Quel revetement voulez vous pour le mur "+ idMur +" de cette piece?");
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourMur){//verifie que revetement est bien pour le sol
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
    }
       

    //pour la sauvegarde du devis dans un fichier texte
    public String afficher() throws IOException
    {
        return "\n Mur " + this.idMur + " :  debut: " + this.debut.toString()+ "; fin: " +this.fin.toString() + " ; utilisant" + this.revetement +
                "\n   ; le nombre porte est:" + this.nmbrPortes + " et le nombre fenetre est:"+ this.nmbrFenetres+
                 " ; au cout de finale de " + Revetement.montant(revetement, surface());
        
    }
    
    
    /* pas utilisé ici : idée pour controleur GUI
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

    public int getNFenetres()         
    {
        return this.nmbrFenetres;
    }

    public int getNPortes()             
    {
        return this.nmbrPortes;
    }

    
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

    public Revetement getRevetement() {
        return revetement;
    }

    public void setRevetement(Revetement revetement) {
        this.revetement = revetement;
    }
    
    

}
