package fr.amine.tp2;

public class Ex2 {
	
	
	static int nbPositifs (int[] tab){
		int nb =0 ;
		for(int i=0 ; i<tab.length ; i++){
			if (tab[i]>0) {
				nb=nb+1;
			}
		
		}//for i
		return nb;
		}//nbPositifs

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tab= {4,5,-6};
		System.out.println(nbPositifs (tab));
	}

}
