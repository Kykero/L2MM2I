package fr.amine.tp1;

public class Tp1Ex3 {
	
	static int code(int a, int b, int c) {
		int v;
		if((a==b)||(a==c)) {
			v=a;
		}
		else if ((b==a)||(b==c)){
			v=b;
		}
		else if((c==a)||(c==b)){
			
				v=c;
		}
		else {
			v=-1;
		}
		return v;
	}//fonction code			
	
	
	public static void main (String [] args) {
		int x, y, z;
		x=3;
		y=3;
		z=0;
		System.out.println("On a au moins 2 arguments qui sont égaux et dont la valeur est : "+code(x,y,z));
	}//main
}//class
