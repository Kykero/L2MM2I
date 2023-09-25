package fr.amine.tp5;

public class EnsembleGene <T>{
	private T[] tab; //Il n'est pas possible d'allouer un tableau générique

	private int indice;
	public EnsembleGene() {//Défini u tableau qui sera notre ensemble
		// TODO Auto-generated constructor stub
		tab =(T[])new Object[1000]; //Création d'un tableau d'objet qui est ensuite "casté"
	}
	public T getElement(int indice) {//Retourne un élément d'un ensemble
		return tab[indice];
	}//getElement
	
	public boolean estVide() {//Fonction qui retourne (vrai/faux) si l'ensemble est vide
							//vrai:vide faux : non vide
		if(indice<0) {
			return true;
		}
		return false;
	}//estVide
	
	public boolean estPlein() {//Fonction qui retourne (vrai/faux) si l'ensemble est plein
								//vrai:plein faux : non plein
		if(indice>=tab.length) {
			return true;
		}
		return false;
	}//estPlein
	public int nbElement() {//Calcule le nombre d'élement dans notre ensemble
		return indice+1;
	}//nbElement
	
	public T element() {//Retourne un élement de l'ensemble, ici le 1er
		return tab[0];
	}
	public boolean appartient (T element) {//Retourne (Vrais/faux) si un element donné en entrée
										//appartient à notre ensemble
		for(int i=0;i<indice;i++) {
			if(tab[i]==element) {
				return true;
			}
		}
		return false;
	}//appartient
	
	public int getIndice(T element) { //Retourne l'indice d'un élement de l'ensemble
		int val=0;
		for(int i=0;i<indice;i++) {
			if(tab[i]==element) {
				val = i;
			}
			else {
				System.exit(-1);
			}
		}
		return val;
		
	}//getIndice
	
	public void ajoutElt(T element) {//Ajoute un élément dans l'ensemble
		if(estPlein()) {
			System.out.println("Element plein");
			System.exit(-1);
		}
		indice++;
		tab[indice]=element;
	}//ajoutElt
	
	public void oterElt(T element) {//Retir un élement dans l'ensemble
		if(estVide()) {
			System.out.println("Element vide");
			System.exit(-1);
		}
		/*for(int i=getIndice(element);i<indice;i++) {
			tab[i]=tab[i+1];
		}
		indice--;*/
		int val=0;
		for(int i=0;i<=indice;i++) {
			if(tab[i]==element) {
				val=i;
			}
		}
		for(int i=val;i<=indice;i++) {
			tab[i]=tab[i+1];
		}
		indice--;
	}//oterElt
	
	public String toString() {//Affiche les élements de l'ensemble
		String ch="[";
		for(int i=1;i<indice;i++) {
			ch+=tab[i]+" , ";
		}
		ch+=tab[indice]+"]\n";
		return ch;
		
	}//toString
	
	public EnsembleGene<T> union(EnsembleGene<T> e) {//Retourne un ensemble, qui contient, l'union de 2 ensembles,
													//c'est à dire tout les élements des 2 ensembles, sauf les doublons
		EnsembleGene<T> C=new EnsembleGene<T>();
		for(int i=0;i<=indice;i++) {
			C.ajoutElt(tab[i]);
	
		}
		for(int i=0;i<=e.indice;i++) {

			C.ajoutElt(e.tab[i]);
			
		}
		
		for(int i=0;i<=C.indice-1;i++) {
			for(int j=i+1;j<=C.indice;j++) {
				if(C.tab[i]==C.tab[j]) {
					C.oterElt(C.tab[i]);	
				}
				
			}
		}	
		return C;
	
	}//union
	
	public EnsembleGene<T> intersection(EnsembleGene<T> e) {//Retourne un ensemble qui contient l'intersection entre 2 ensembles,
															//c'est à dire les élements en commun des 2 ensembles
		EnsembleGene<T> C=new EnsembleGene<T>();
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					C.ajoutElt(tab[i]);
				}
			}
		
		}
		
		return C;
	}//intersection
	
	public EnsembleGene<T> diff(EnsembleGene<T> e) {//Retourne un enseble qui contient la différence de 2 ensembles,
													//c'est à dire le 1er ensemble sans l'intersection avec l'ensemble 2  
		
		EnsembleGene<T> C=new EnsembleGene<T>();
		for(int i=0;i<=indice;i++) {
			C.ajoutElt(tab[i]);
	
		}
		for(int i=0;i<=e.indice;i++) {

			C.ajoutElt(e.tab[i]);
			
		}
		
		for(int i=0;i<=C.indice-1;i++) {
			for(int j=i+1;j<=C.indice;j++) {
				if(C.tab[i]==C.tab[j]) {
					C.oterElt(C.tab[i]);
					
				}
			}
		}
		for(int i=0;i<=e.indice;i++) {

			C.oterElt(e.tab[i]);
			
		}
		return C;
	}//diff
	public boolean egal(EnsembleGene<T> e) {//Retourne (vrais/faux) si 2 ensembles sont égaux
		boolean flag =true;
		for(int i=0;i<=indice;i++) {
			
				if(tab[i]!=e.tab[i]) {
					flag=false;
				}
			
		}
		return flag;
	}//egal
	
	public boolean disjoints(EnsembleGene<T> e) {//Retourne (vrais/faux) si 2 ensembles n'ont pas d'éléments communs
		
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=e.indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					return false;
				}
			}
		}
		return true;
	}//disopints
	
	public boolean inclus(EnsembleGene<T> e) {//Retourne (vrais/faux) si au moins un élement de 1 ensembles est aussi dans un autre ensemble
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=e.indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					return true;
				}
			}
		}
		return false;
	}//inclus
	
	
	

	public static void main(String[] args) {
		EnsembleGene<Integer> e1= new EnsembleGene<Integer>();
		EnsembleGene<Integer> e2= new EnsembleGene<Integer>();
		EnsembleGene<Integer> e3= new EnsembleGene<Integer>();
		EnsembleGene<Integer> e4= new EnsembleGene<Integer>();
		EnsembleGene<Integer> e5= new EnsembleGene<Integer>();
		EnsembleGene<Integer> e6= new EnsembleGene<Integer>();
		e1.ajoutElt(5);
		e1.ajoutElt(3);
		e1.ajoutElt(2);
		e2.ajoutElt(3);
		e2.ajoutElt(7);
		e2.ajoutElt(8);
		e4=e1.intersection(e2);
		e3=e1.union(e2);
		e5=e1.diff(e2);
		e6.ajoutElt(5);
		e6.ajoutElt(3);
		e6.ajoutElt(2);
		System.out.println("Ensemble 1: "+e1);
		System.out.println("Ensemble 2: "+e2);
		System.out.println("Ensemble 3 (union des ensembles 1 et 2: "+e3);
		System.out.println("Ensemble 4 (intersection des ensembles 1 et 2) : "+e4);
		System.out.println("Ensemble 5 difference : E1 - E2 = "+e5);
		System.out.println("Ensemble 6: "+e6);
		System.out.println("Les ensembles 1 et 2 sont egaux ? Reponse :"+e1.egal(e2));
		System.out.println("Les ensembles 1 et 6 sont egaux ? Reponse :"+e1.egal(e6));
		System.out.println("Les ensembles 1 et 2 sont disjoints ? Reponse : "+e1.disjoints(e2));
		System.out.println("L'ensemble 1 est inclus dans l'ensemble 2 ? Reponse : "+e1.inclus(e2));

	}//main

}//class EnsembleGene
