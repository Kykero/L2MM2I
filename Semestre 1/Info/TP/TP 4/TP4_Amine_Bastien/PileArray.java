package fr.amine.tp4;

public class PileArray implements Pile{
	private int []tab;
	private int indice;
	
	
	public PileArray() {
		tab= new int [1000];
		indice=-1;
	}
	public PileArray(int taille) {
		tab=new int [taille];
		indice=-1;
	}
	public PileArray(PileArray p) {
		int new_taille =p.tab.length;
		tab=new int [new_taille];
		for(int i =0; i<new_taille;i++) {
			tab[i]=p.tab[i];
		}
		
		indice=p.indice;
	}
	//3 Constructeurs PileArray
	
	public boolean estVide() {//Indique que la pile est vide
		if(indice<0) {
			return true;
		}
		return false;
	}//estVide
	
	public boolean estPleine() {//Indique que la pile est pleine
		return (indice>=tab.length);
	}//estPleine
	
	public int nbElement() {//Compte le nb d'elements dans la pile
		return indice+1;
		
	}//nbElement
	
	public void empiler(int x) {//Ajoute un element dans la pile
		if(estPleine()) {
			System.out.println("PileArray::empiler: Erreur, la pile est pleine");
			System.exit(-1);
		}
		indice++;
		tab[indice]=x;
	}//empiler
	
	public int depiler() {//Enleve un element de la pile
		if(estVide()) {
			System.out.println("PileArray::depiler: Erreur, la pile est vide");
			System.exit(-1);
		}
		int val=sommetPile();
		indice--;
		return val;
	}//depiler
	
	public int sommetPile() {//retourne le dernier elements de la pile
		return tab[indice];
	}//sommetPile
	
	public String toString() {
		String result = "[";
		for(int i=0;i<nbElement()-1;i++) {
			result+=" "+tab[i]+",";
		}
		if(!estVide()) {
			result+=" "+tab[nbElement()-1]+" ";
		}
		result+="]\n";
		return result;
	}//toString
	
	public void inverse() {//Inverse l'ordre de la pile
		for(int i=0;i<=indice/2;i++) {
			int tmp=tab[i];
			tab[i]=tab[indice-i];
			tab[indice-i]=tmp;
		}
	}//inverse
	
	public boolean appartient(int e) {//Cherche un element dans la pile
		for(int i =0;i<=indice;i++) {
			if(tab[i]==e) {
				return true;
			}
		}
		return false;
	}//appartient

	public static void main(String[] args) {
		PileArray p1= new PileArray();
		PileArray p2= new PileArray(10);
		int elem=2;
		p1.empiler(2);
		p1.empiler(3);
		System.out.println("Contenu de la pile 1 : "+p1);
		p1.inverse();
		System.out.println("Contenu de la pile inverse de 1 : "+p1);
		p1.depiler();
		System.out.println("Contenu de la pile 1 apres depilage : "+p1);
		p2.empiler(1);
		p2.empiler(3);
		p2.empiler(4);
		
		PileArray p3= new PileArray(p2);
		System.out.println("Contenu de la pile 2 : "+p2);
		System.out.println("Le nombre "+elem +" est dans la pile 1 ? Reponse : "+ p1.appartient(elem));
		System.out.println("Contenu de la pile 3 : "+p3);
		

	}//main

}//class Pile
