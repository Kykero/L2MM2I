public class E {
	
	static boolean pair(int u) {
		boolean flag = false;
		if((u % 2) == 0) {
			flag = true;
		}
		return flag;
	}//pair

	
	static int g(int u, int v) {
		if ((u <= v) && (pair(u))){
			return 14;
		}
		return 25;
	}//g

	public static void main(String[] args) {
		int x; //Pas d'erreur sur les déclarations
		float y;
		boolean c;
		x = 5;
		y = 7.8f;
		c = pair(8);
		x = g(x, 8);
		System.out.println("c = " + c);
		System.out.println("y = " + y); //il faut afficher 7.5
		System.out.println("x = " + x+ " g(x,8) = "+g(x,8));
	}//main
}//class		