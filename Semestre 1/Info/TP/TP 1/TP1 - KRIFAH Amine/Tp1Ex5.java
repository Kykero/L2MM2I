package fr.amine.tp1;

public class Tp1Ex5 {
	public static void permute (int[] t, int i, int j) {
		int tmp;
		tmp=t[i];
		t[i]=t[j];
		t[j]=tmp;
	}//fonction permute entre 2 valeurs d'un tableau
	
	public static void main(String[] args) {
		int [] tab = {1, 2, 3, 4, 5};
		int i,i1,i2;
		//Attention il faut entrer des indices comprises entre 0 et le nombres total de valeurs dans le tableau - 1, 
		//donc ici 5-1=4, par exemple.
		
		i1=4;
		i2=2;
		
		System.out.print("Tableau avant permutation : |");
		
		for(i=0;i<tab.length;i++) {
			System.out.print(tab[i]+" |");
		}
		
		System.out.print("\nTableau apres permutation des indices "+i1+" et "+i2+" : |");
		permute(tab,i1,i2);
		for(i=0;i<tab.length;i++) {
			System.out.print(tab[i]+" |");
		}//main
		
		
	}//class
	

}
