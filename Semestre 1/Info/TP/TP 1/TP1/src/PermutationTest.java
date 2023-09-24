public class PermutationTest {

	public int t[];
	
	public PermutationTest(int x) {
		t = new int[x];
		for(int i = 0; i < x ; i++)
			t[i] = i;
	}
	
	
	public static void swap(PermutationTest h, int i ,int j) {
		int b = 0;
		b = h.t[i];
		h.t[i] = h.t[j];
		h.t[j] = b;
	}
	
	
	
	public String toString() {
		String str ="";
		for(int i =0; i < t.length ; i++) {
			str += t[i] + ",";
		}
		return str;
	}
	
	
	public static void main(String[] args) {

		PermutationTest t1 = new PermutationTest(50);
		
		System.out.println(t1);
		swap(t1, 1, 3);
		System.out.println(t1);
		
		
	}
}
