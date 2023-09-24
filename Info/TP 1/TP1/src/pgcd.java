public class pgcd {

	public static int recursive(int a, int b) {

		int val =1;

		if(a==b) {
			val = a;
		}
		if(a > b) {
			val = recursive(a-b,b);
		}
		
		if(a < b) {
			val = recursive(a,b-a);
		}

		return val;
	}

	public static int iterative(int a , int b) {

		if(a==0 || b == 0) {
			System.exit(-1);
		}
		while(a != b) {

			if(a > b) {
				a = a-b;
			}
			else {
				b = b-a;
			}
		}

		return a;
	}



	public static void main(String[] args) {

		System.out.println(iterative(12,20));
		System.out.println(recursive(12,20));

	}

}//class
