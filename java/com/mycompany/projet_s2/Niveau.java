/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet_s2;

import java.util.ArrayList;

/**
 *
 * @author Thuy
 */
public class Niveau { 
    public int idNiveau;
    public ArrayList<Appartement> appartements;

    Niveau(int id, int nbreApparts)
    {
        this.idNiveau = id;
        appartements = new ArrayList<Appartement>(nbreApparts);

        Appartement foobar;

        for(int i = 0; i < nbreApparts; i++)
        {
            foobar = new Appartement(id, idNiveau);
            appartements.add(foobar);
        }

    }
}