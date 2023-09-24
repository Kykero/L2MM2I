public class Permutation {


	public static void swap(int t[], int i , int j) {
		
		int b = 0;
		b = t[i];
		t[i] = t[j];
		t[j] = b;
	}
	
	
	public static void main(String[] args) {
		
		int t[] = new int[10];
		for(int i = 0; i < 10; i++) {
			t[i] = i;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.print(t[i] + ",");
		}
		System.out.println();
		
		
		swap(t, 1, 3);
		
		
		for(int i = 0; i < 10; i++) {
			System.out.print(t[i] + ",");
		}

		
		
	}
}
