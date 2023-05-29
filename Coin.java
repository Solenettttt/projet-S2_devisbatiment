/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

/**
 *
 * @author Thuy
 */
public class Coin {
    private int idCoin; //identificateur coin
    private double x;  //abscisse du coin
    private double y;  //ordonnee du coin
    private static int nextId = 0; //pour itérer automatiquement le numéro d'identifiant
    

//Constructeur pour créer un coin saisissant les coordonnees</p>
    public Coin(int idCoin)
    {   
        this.idCoin = idCoin;
        System.out.println("Donnez la coordonnée x de votre coin " + this.idCoin);
        this.x = Lire.d();
        System.out.println("Donnez la coordonnée y de votre coin " + this.idCoin);
        this.y = Lire.d();
    }
    
    
    //Constructeur pour créer un coin avec les parametres donnees 
    public Coin (int idCoin, double x, double y){
        this.idCoin =idCoin;
        this.x = x;
        this.y = y;
    }
   // pas utilisé mais possible pour interface graphique
    public Coin (double x, double y){
        this.idCoin = nextId++;
        this.x = x;
        this.y = y;}
    
    
    //getters
    public int getId()  {
        return idCoin;
    }
    
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    //on change puis affect à la variable correspondante abscisse et ordonnée du coin avec méthode set
//interface_pas utilisé pour console
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    //methode tostring permet l'affichage correct de chaque coin
    @Override
    public String toString(){
        return ("Coin"+ this.idCoin + " ( " + this.x + " , " + this.y+" ) ") ;
    }
    
}
