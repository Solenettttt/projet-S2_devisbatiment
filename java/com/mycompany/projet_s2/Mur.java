/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2; 

import Revetements.Revetement;
        


/**
 *
 * @author Thuy
 */
public class Mur extends Ttsurfaces{
    private int idMur;
    private Coin debut;     //Point de départ du mur
    private Coin fin;     //Point de fin du mur
    //private int nmbrPortes;     extention
    //private int nmbrFenetres;   
    
    
    Revetement revetement;

     //Constructeur pour le  premier mur: avec coins données
   
    public Mur(int id, Coin c1, Coin c2){
        
        
        this.debut = c1;
        this.fin = c2;
        this.idMur = id;
        //this.nmbrFenetres = 0;
        //this.nmbrPortes = 0;
        this.revetement = new Revetement();
    }

    //Constructeur pour un mur en continuation d'un autre: le deuxieme coin est demandé

    public Mur(int id, Coin debut){
        this.debut = debut;
        Coin fin = new Coin(id+1);
        this.fin = fin;
        this.idMur = id;
        //this.nmbrFenetres = 0;
        // this.nmbrPortes = 0;
        this.revetement = null;

    }
    
     //Constructeur pour un mur de fin:où les deux coin sont demandé

    public Mur(int id){
        Coin debut = new Coin((id*2)-1);
        Coin fin = new Coin(id*2);

        this.debut = debut;
        this.fin = fin;
        this.idMur = id;
        //this.nmbrFenetres = 0;
        //this.nmbrPortes = 0;
        this.revetement = null;

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
    
    
    //Methode calcule de longueur du mur

    public double longueur() {
        return Math.sqrt(Math.pow(Math.abs(this.debut.getX() - this.fin.getX()), 2) + Math.pow(Math.abs(this.debut.getY() - this.fin.getY()), 2));
    }
   
    
    //Methode pour définir revetement du mur

 
    public void changeRevetement(Revetement rev)
    {
        if(rev.pourMur){ 
            this.revetement = rev;
        }
    }
    
    
    //Methode pour calculer la surface du mur

    public double surface(double hsp) {

        return hsp * this.longueur();
    }

    
    @Override
    public String toString()
    {
        return "\n Mur " + this.idMur + " de coin de debut: ( " + this.debut.getX() + " , " + this.debut.getY() + " ) "
             +  "; et de coin de fin: ( " + this.fin.getX() + " , " + this.fin.getY() + " ) " + " au revetement " + revetement;
    }
    
    void dessiner(){
    }
    
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
    
    

}
