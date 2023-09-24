public class C {
	public static void main(String[] args) {
		int x,y;
		int b;
		int c = 0;
		x = 987654321;
		System.out.println("La valeur de x est : "+ x);
		y = 3*x;
		b = x = y;
		b = b+c;
		System.out.println("La valeur de y est : "+y);
		System.out.println("La valeur de b est : "+b);
	}//main
}//class