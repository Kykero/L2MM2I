package fr.amine.tp2;

public class Ex1 {

	static boolean estRange (char []tabCar) {
		boolean range = true;
		System.out.println("i="+tabCar[0]);
		for(int i=0; i<tabCar.length-1; i++){
			
			System.out.println("i="+tabCar[i+1]);
			
			 if((range) && (tabCar[i] > tabCar[i+1])) {
				 range = false;
				 return range;
			}	 	
					
		}
		return range;

		
		//for(int i=0; i<tabCar.length-1; i++) {
			
		
			
		
		}//for i
		
	//estRange
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char []t = {'A','B','C','A','D'};
		//char []t2 = {'A','C','D'};
		System.out.println(estRange(t));
		//System.out.println(estRange(t2));
		//estRange(t);
		
	}

}
