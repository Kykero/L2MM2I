public class Exercice3 {

	public static int code(int a, int b, int c) {
		int v;
		
		if(a==b) {
			v = a;
			return v;
		}
		
		if(a==c) {
			v=a;
			return v;
		}
		
		if(b==c) {
			v=b;
			return v;
			
		}else {
			v = -1;
			return v;
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println(code(6,10,10));
	}
	
	
	
	
	
	
	
	
}//class
