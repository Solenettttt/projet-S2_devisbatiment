
package com.mycompany.projet_s2;
/*import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public Plafond(ArrayList<Mur> murs, int idrev){
        this.murs = murs;
        //definirRevetement(revetement );
        //System.out.println("Quel revetement voulez vous pour le plafond de cette piece?");
        //this.revetement = Lire;
        //this.idrev=Lire.i();
        //this.revetement = this.getRevetement(idrev);
        definirRevetement();
    }

    
    public void setRevetement(int i) {
        this.revetement = Revetement.getRevetement(i);
    }
    
    
    //methode qui vérfie et détermine le revetement du plafond
    @Override
    public void definirRevetement() {

        System.out.println("Quel revetement voulez vous pour le plafond de cette piece?");
        //this.revetement = Lire;
        this.idrev=Lire.i();
        this.revetement = new Revetement(idrev);

        while(false==revetement.pourPlafond){//verifie que revetement est bien pour le plafond
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            this.idrev=Lire.i();
            this.revetement = new Revetement(idrev);
        }
    
        //if(rev.pourMur){ 
          //  this.revetement = rev;}
        
    }
    /*
        System.out.println("Quel revetement voulez vous pour le plafond de cette piece?");
        //this.revetement = Lire;
        int id =Lire.i();
        rev = new Revetement(id);

        while(false==rev.pourPlafond){//verifie que revetement est bien pour le plafond
            System.out.println("Ce revetement n'est pas adapter à cette surface. Veuillez reessayer:");
            id =Lire.i();
            rev = new Revetement(id);
        }
        this.idrev=id;
        this.revetement = rev;
    }
       */

    public Revetement getRevetement(int id) {
     Revetement rev=new Revetement(id);   
        try{
        rev = Revetement.readDef().get(id-1);

    }catch(IOException error){
        
    }
        return rev;
    }
/*
    public double getIdrev(int id) {
        
    }
    
    */
    @Override
       public double surface(){
        double s;
        
        double L1 = this.murs.get(1).longueur();
        double L2 = this.murs.get(2).longueur();
        s=L1*L2;
        
        return s;
    }
   /*
    public double getPrice() throws IOException {

        try
        {
        BufferedReader flux = new BufferedReader(new FileReader("revs.txt"));
        String lignelue;

        while((lignelue=flux.readLine())!=null){        //on vérifie à chaque ligne
            //on décompose en chaine de caratères avec la méthode split de la classe String
            String[] attributs = lignelue.split(";"); //et on range les attributs dans une liste de String
            
            if (Double.parseDouble(attributs[0])==(this.idrev)|| Double.parseDouble(attributs[0])==(this.idrev)){
                return(Double.parseDouble(attributs[5]));       //on recupere le prix du revetement selectionné
            }
        }
        flux.close();
        }       //try-catch pour recuper et identifier les erreurs plus efficacement
        catch(FileNotFoundException err){
            System.out.println("Erreur :le fichier n’existe pas!\n "+err);}
        catch(IOException err){
            System.out.println("Erreur :\n"+err);}
        int trouve = 0;
        if (trouve==0)
            System.out.println("Introuvable");
        return(0);
        }
*/
    @Override
    public String toString() {
        return "\n Plafond de surface " + surface() + " ; utilisant: " + revetement + " ; au cout de "+ Revetement.montant(revetement, surface());
    }
     
}
