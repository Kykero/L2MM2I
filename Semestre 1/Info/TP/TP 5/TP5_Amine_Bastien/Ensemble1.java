package fr.amine.tp5;

public class Ensemble1 implements Ensemble{
	private int []tab;
	private int indice;
	
	
	public Ensemble1() {
		indice=-1;
		tab=new int [1000];
		 
	}
	
	public int getElement(int indice) {
		return tab[indice];
	}
	
	public boolean estVide() {
		if(indice<0) {
			return true;
		}
		return false;
	}
	
	public boolean estPlein() {
		if(indice>=tab.length) {
			return true;
		}
		return false;
	}
	public int nbElement() {
		return indice+1;
	}
	
	public int element() {
		return tab[0];
	}
	public boolean appartient (int element) {
		for(int i=0;i<indice;i++) {
			if(tab[i]==element) {
				return true;
			}
		}
		return false;
	}
	
	public int getIndice(int element) {
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
		
	}
	
	public void ajoutElt(int element) {
		if(estPlein()) {
			System.out.println("Element plein");
			System.exit(-1);
		}
		indice++;
		tab[indice]=element;
	}
	
	public void oterElt(int element) {
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
	}
	
	public String toString() {
		String ch="[";
		for(int i=0;i<indice;i++) {
			ch+=tab[i]+" , ";
		}
		ch+=tab[indice]+"]\n";
		return ch;
		
	}
	
	public Ensemble1 union(Ensemble1 e) {
		Ensemble1 C=new Ensemble1();
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
	
	}
	public Ensemble1 intersection(Ensemble1 e) {
		Ensemble1 C=new Ensemble1();
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					C.ajoutElt(tab[i]);
				}
			}
		}
		
		return C;
	}
	
	public Ensemble1 diff(Ensemble1 e) {
		/*Ensemble1 C=new Ensemble1();
		for(int i=0;i<=indice;i++) {
			C.ajoutElt(tab[i]-e.tab[i]);
			
		}
		return C;*/
		Ensemble1 C=new Ensemble1();
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
		
	
	}
	public boolean egal(Ensemble1 e) {
		boolean flag =true;
		for(int i=0;i<=indice;i++) {
			
				if(tab[i]!=e.tab[i]) {
					flag=false;
				}
			
		}
		return flag;
	}
	public boolean disjoints(Ensemble1 e) {
		
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=e.indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean inclus(Ensemble1 e) {
		for(int i=0;i<=indice;i++) {
			for(int j=0;j<=e.indice;j++) {
				
				if(tab[i]==e.tab[j]) {
					return true;
				}
			}
		}
		return false;
	}

	
	
	public static void main(String[] args) {
		Ensemble1 e1=new Ensemble1();
		Ensemble1 e2=new Ensemble1();
		Ensemble1 e3=new Ensemble1();
		Ensemble1 e4=new Ensemble1();
		Ensemble1 e5=new Ensemble1();
		Ensemble1 e6=new Ensemble1();
		
		
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
		e1.oterElt(5);
		System.out.println("Les ensembles 6 et 1 sont egaux ? Reponse :"+e6.egal(e1));
	}

}
