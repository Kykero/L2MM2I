package fr.amine.tp3_objets_et_classes;

public class Etudiant {
	  private String nom;//nom de l'étudiant
	  private int[] choix;//son tableau de choix sur les groupes de sa classe

	  
	  public Etudiant() {
		  choix = new int [100];
	  }
	  public Etudiant(String n, int[] c) {//Créer un étudiant à partir de son nom et de son tableau de choix
		nom=n;
		choix=new int [c.length];
		for(int i=0;i<c.length;i++) {
			choix[i]=c[i];
		}
	  }//Constructeur Etudiant

	  public void affiche() {//Affiche le nom et les choix de l'étudiant
	    	System.out.println(nom);
	    	System.out.print("Choix : ");
	    	for(int i=0;i<choix.length;i++) {
	    		System.out.print(choix[i]+"|");
	    	}
	    	System.out.println();
	  }//affiche
	  
	  public String getNom() {
		  return this.nom;
	  }
	  public void setNom(String n) {
		  this.nom=n;
	  }
	  public void setElemChoix(int i){
		  int indice=0;
		  choix[indice]=i;
		  indice++;
	  }
	  public void setChoix(int []c) {
		 
		  choix=c;
	  }
	  public int[] getChoix() {
		  return choix;
	  }
	  
	  
	  
	 
	  public static void main (String args[]) {
		  int[]ch = {1,2,3};
		Etudiant e1 = new Etudiant ("A",ch);
		Etudiant e2 = new Etudiant ("B",ch);
		Etudiant e3 = new Etudiant ("C",ch);
		e1.affiche();
		e2.affiche();
		e3.affiche();
	
	  }//main

	
	}//class etudiant

