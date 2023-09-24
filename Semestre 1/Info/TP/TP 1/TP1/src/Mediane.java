public class Mediane {
	
	public static void main(String[] args) {
		int x,y,z;
		int m = 0;
		x = 30;
		y = 2;
		z = 4;
		System.out.println("Valeurs : x = " + x + ", y = " + y + ", z = " +z);
		
		if(x < y && x > z) {
			m = x;
		}
		if(y < x && y > z) {
			m = y;
		}
		if(z < x && z > y) {
			m = z;
		}
		System.out.println("Valeur médiane = " + m);
		
	}//main
}//class		