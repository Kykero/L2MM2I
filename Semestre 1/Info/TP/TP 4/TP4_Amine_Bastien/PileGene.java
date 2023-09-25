package fr.amine.tp4;

public class PileGene<T> { //On creer une classe Pile generique de variable T
	private T [] P;	//Il n'est pas possible d'allouer un tableau generique (c-a-d P=new T[10];)
	private int indice;
	
	
	public PileGene() {
		P=(T []) new Object[1000];//Creation d'un tableau d'objet, qu'on affecte par la variable generique T
		indice=-1;
	
		
	}

	public PileGene(int taille) {
		P =(T []) new Object [taille];
		indice=-1;
	}
	public PileGene(PileGene <T>p) {
		
		int taille=p.P.length;
		P =(T []) new Object [taille];
		for(int i=0;i<taille;i++) {
			P[i]=p.P[i];
		}
		
		
		indice=p.indice;
	}
	
	public boolean estVide() {
		if(indice<0) {
			return true;
		}
		return false;
	}
	
	public boolean estPleine() {
		return (indice>=P.length);
	}
	
	public int nbElement() {
		return indice+1;
		
	}
	
	public void empiler(T x) {
		if(estPleine()) {
			System.out.println("PileArray::empiler: Erreur, la pile est pleine");
			System.exit(-1);
		}
		indice++;
		(P[indice])=x;
	}
	
	public T depiler() {
		if(estVide()) {
			System.out.println("PileArray::depiler: Erreur, la pile est vide");
			System.exit(-1);
		}
		T val=P[indice];
		indice--;
		return val;
	}
	public T sommetPile() {
		return P[indice];
	}
	public String toString() {
		String result = "[";
		for(int i=0;i<nbElement()-1;i++) {
			result+=" "+P[i]+",";
		}
		if(!estVide()) {
			result+=" "+P[nbElement()-1]+" ";
		}
		result+="]\n";
		return result;
	}
	
	public void inverse() {
		for(int i=0;i<=indice/2;i++) {
			T tmp=P[i];
			P[i]=P[indice-i];
			P[indice-i]=tmp;
		}
	}
	
	public boolean appartient(T e) {
		for(int i =0;i<=indice;i++) {
			if(P[i]==e) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		PileGene <Integer> p1 = new PileGene <Integer>();
		PileGene <Integer> p2 = new PileGene <Integer>(10);
		int elem=2;
		p1.empiler(2);
		p1.empiler(3);
		System.out.println("Contenu de la pile 1 : "+p1);
		p1.inverse();
		System.out.println("Contenu de la pile inverse de 1 : "+p1);
		p1.depiler();
		System.out.println("Contenu de la pile 1 apres depilage : "+p1);
		System.out.println("Le nombre "+elem +" est dans la pile 1 ? Reponse : "+ p1.appartient(elem));
		p2.empiler(1);
		p2.empiler(3);
		p2.empiler(4);
		
		PileGene <Integer> p3 = new PileGene <Integer>(p1);
		System.out.println("Contenu de la pile 2 : "+p2);
		
		System.out.println("Contenu de la pile 3 : "+p3);
	}

}
