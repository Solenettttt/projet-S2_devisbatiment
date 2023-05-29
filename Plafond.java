
package com.mycompany.projet_s2;


import java.util.ArrayList;

//import Revetements.Revetement;
/**
 *
 * @author Thuy
 */
public class Plafond extends Ttsurfaces{

    ArrayList<Mur> murs;
    Revetement revetement;
    private int idrev;

    
    //Constructeur plafond avec mur et revetement
    public Plafond(ArrayList<Mur> murs){
        this.murs = murs;

        definirRevetement();
    }

  
    
    //methode qui vérfie et détermine le revetement du plafond
    @Override
    public void definirRevetement() {

        System.out.println("Quel revetement voulez vous pour le plafond de cette piece?");
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourPlafond){//verifie que revetement est bien pour le plafond
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
    
       
    }

    //calcul surface heredité de Ttsurface
    @Override
       public double surface(){
        double s;
        
        double L1 = this.murs.get(1).longueur();
        double L2 = this.murs.get(2).longueur();
        s=L1*L2;
        
        return s;
    }
  
       //afffichage du plafond en console et fichier texte
    @Override
    public String toString() {
        return "\n Plafond de surface " + surface() + " ; utilisant: " + revetement + " ; au cout de "+ Revetement.montant(revetement, surface());
    }
    
}
