/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Thuy
 */
public class Sauvegarde {/*
    ArrayList<Coin> coins; 
    ArrayList<Mur> murs; 
    ArrayList<Piece> pieces;
    ArrayList<Niveau> etages;
    String temp;
    String idniveau;
    String txtcoins,idcoin,xcoin,ycoin,niveau;
    String txtmurs,idmur,coindebut,coinfin,revetement;
    String txtpieces,sol,murhaut,murbas,murgauche,murdroit,usage;
    char c;
    int debut,fin;
    
    public void lecture(String chemin){
        try{
            FileReader fr= new FileReader(chemin);
            BufferedReader br = new BufferedReader(fr);
            while((idetage=br.readLine())!=null){
                Etage newEtage = new Etage(Integer.parseInt(idetage));
                txtcoins = br.readLine();
                debut = 0;
                fin = 0;
                c = txtcoins.charAt(debut);
                while (c != '@') {
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    idcoin = txtcoins.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    xcoin = txtcoins.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    ycoin = txtcoins.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    etage = txtcoins.substring(debut,fin-1);
                    Coin newCoin = new Coin(Integer.parseInt(idcoin),Double.parseDouble(xcoin),Double.parseDouble(ycoin),Integer.parseInt(etage));
                    newEtage.getCoin().add(newCoin);  
                }
                txtmurs = br.readLine();
                debut = 0;
                fin = 0;
                c = txtmurs.charAt(debut);
                while (c != '@') {
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    idmur = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    coindepart = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    coinarrivee = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    etage = txtcoins.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtcoins.charAt(fin);
                    }
                    revetement = txtcoins.substring(debut,fin-1);
                    Mur newmur = new Mur(Integer.parseInt(idmur),getObject(Integer.parseInt(coindepart)),getObject(Integer.parseInt(coinarrivee)),Integer.parseInt(etage),Integer.parseInt(revetement));
                    newEtage.getMur().add(newmur);
                }
                txtpieces = br.readLine();
                debut = 0;
                fin = 0;
                c = txtmurs.charAt(debut);
                while (c != '@') {
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    idcoin = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    sol = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    murhaut = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    murbas = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    murdroit = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    murgauche = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    etage = txtmurs.substring(debut,fin-1);
                    debut = fin;
                    while (c != '/') {
                        fin = fin + 1;
                        c = txtmurs.charAt(fin);
                    }
                    usage = txtmurs.substring(debut,fin-1);
                }
                
                
            }
            br.close();
        }catch(IOException e){
            System.out.println("Erreur"+e);
        }
    }
    public void ecriture(String chemin){
        try{
            FileWriter fw =new FileWriter (chemin, false);
            BufferedWriter bw =new BufferedWriter (fw);
            etages = Etage.getEtage();
            for (Etage etage : etages) {                
                coins = etage.getCoin();
                murs = etage.getMur();  
                pieces = etage.getPiece();
                bw.write(Integer.toString(etage.getIdetage()));
                bw.write("\n");
                for (Coin coin : coins) { 
                    bw.write("/"+Integer.toString(coin.getIdcoin()));                    
                    bw.write("/"+Double.toString(coin.getX()));                    
                    bw.write("/"+Double.toString(coin.getY()));
                    bw.write("/"+Integer.toString(coin.getIdetage()));                    
                }
                bw.write("@");
                bw.write("\n");
                for (Mur mur : murs) {
                    bw.write("/"+Integer.toString(mur.getidMur()));
                    bw.write("/"+Integer.toString(mur.getDepart().getIdcoin()));
                    bw.write("/"+Integer.toString(mur.getArrivee().getIdcoin()));
                    bw.write("/"+Integer.toString(mur.getIdetage()));
                }
                bw.write("@");
                bw.write("\n");
                for (Piece piece : pieces) {
                    bw.write("/"+Integer.toString(Piece.getidPiece()));
                    bw.write("/"+Integer.toString(Piece.getSol().getidsol()));
                    bw.write("/"+Integer.toString(Piece.getMurHaut().getidMur()));
                    bw.write("/"+Integer.toString(piece.getMurBas().getidMur()));
                    bw.write("/"+Integer.toString(piece.getMurDroit().getidMur()));
                    bw.write("/"+Integer.toString(piece.getMurGauche().getidMur()));
                    bw.write("/"+Integer.toString(piece.getidetage()));
                    bw.write(piece.getUsage());
                }
                bw.write("@");
            }
            bw.close();
        }catch (IOException err){
            System.out.println("Erreur d'écriture"+err);
        }
    }
    public Coin getObject(int index) {
        Coin res = this.coins.get(index);
        if (res == null) {
            throw new IndexOutOfBoundsException();
        }
        return res;
    }
*/
}
