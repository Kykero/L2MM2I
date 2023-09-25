package fr.amine.tp3_objets_et_classes;

public class Groupe {

	  private Etudiant[] grp; //tableau d'étudiant
	  private int indice; //indice de remplissage du groupe
	  
	  public Groupe() {
		  grp = new Etudiant[0];
		  indice=-1;
	  }
	  public Groupe(int taille) { //Permet de créer un groupe de taille prédéfinie
	    grp = new Etudiant [taille];
	    indice=-1;
	   
	  }//Constructeur Groupe
	  
	  public boolean ajoute(Etudiant Et) {//ajoute un etudiant dans le groupe, si le groupe n'est pas plein
		 
		  if(indice>=grp.length-1) { 
	    	
	    	return false; //Renvoi faux si le groupe est plein
	    }
		  else{
			 
			  	indice++;
			    grp[indice]= Et;
			    //System.out.println(Et.getNom()+" est ajouté dans le groupe");
			    return true;
			  }
		  }//ajoute
	    
	    
	  
	  public void affiche() {//Affiche les étudiants contenus dans le groupe
	    System.out.println("Liste des étudiants dans le groupe");
	    for(int i=0;i<=indice;i++) {
	    	System.out.print(grp[i].getNom()+" | ");
	    }
	   
	    System.out.println();
	  }//affiche
	  
	  
	  public static void main (String[] args) {
		  int[]ch = {1,2,3};
		Etudiant e1 = new Etudiant ("A",ch);
		Etudiant e2 = new Etudiant ("B",ch);
		Etudiant e3 = new Etudiant ("C",ch);
		
		Groupe g1 = new Groupe(3);
		Groupe g2 = new Groupe(2);
	    g1.ajoute(e1);
	    g1.ajoute(e2);
	    g2.ajoute(e3);
	    System.out.println("Groupe 1");
	    g1.affiche();
	    System.out.println("Groupe 2");
	    g2.affiche();
			
		}

	}
	
	