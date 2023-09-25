package fr.amine.tp1;

public class Mediane {
	
	public static int max(int a, int b) {
		int max;
		if(a<b) {
			max=b;
		}
		else {
			max=a;
		}
		return max;
	}//fonction recherhe du maximum
	
	public static int min(int a, int b) {
		int min;
		if(a<b) {
			min=a;
		}
		else {
			min=b;
		}
		return min;
	}//fonction recherche du minimum

	public static void main(String[] args) {
		int x,y,z;
		int maxi,mini;
		int m = 0;
		x = 4;
		y = 30;
		z = 2;
		System.out.println("Valeurs : x = " + x + ", y = " + y + ", z = " + z);
		maxi=max(x,y);
		maxi=max(maxi,z);			
		mini=min(x,y);
		mini=min(mini,z);
		m=(x+y+z)-(maxi+mini);			
		System.out.println("Valeur mediane = " + m );
		
		}//main	
	
}//class
