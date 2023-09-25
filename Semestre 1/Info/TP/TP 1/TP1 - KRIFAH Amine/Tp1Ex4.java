package fr.amine.tp1;

public class Tp1Ex4 {
	
	public static int pgcd_it(int a,int b) { //Fonction itérative du pgcd
		while (a!=b) {
			if(a>b) {
				a=a-b;
			}
			else {
				b=b-a;
			}
		}
		return a;
	}//fonction pgcd_itérative
	
	public static int pgcd_rec(int a, int b) { //Fonction récursive du pgcd
		if (a==b) {
			return a;
		}
		else if (a>b) {
			return pgcd_rec(a-b,b);
		}
		else {
			return pgcd_rec(a,b-a);
		}
	}//fonction pgcd_récursive
	
	public static void main(String[] args) {
		int x, y;
		x=12;
		y=18;
		System.out.println("Test du PGCD itérative");
		System.out.println("Le dénominateur commun entre "+x+" et "+y+" est : "+pgcd_it(x,y));
		System.out.println("Test du PGCD récursive");
		System.out.println("Le dénominateur commun entre "+x+" et "+y+" est : "+pgcd_rec(x,y));
	}//main

}//class
