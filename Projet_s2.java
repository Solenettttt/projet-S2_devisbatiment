/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projet_s2;

/**
 *
 * @author atassart01
 */
public class Projet_s2 {

    public static void main(String[] args) {
        int i;
        for (i == 0, i<100, i++){
        Coin c1;
        System.out.println("Donner les coordonnées du point");
        int id = Lire.i();
        double x = Lire.d();
        double y = Lire.d();
        c1 = new Coin (id, x, y);
        System.out.println(c1.toString());
        
        
    }
}
