package fr.amine.tp2;

/**

 *       tableau et boucles for 
 * 
 */


public  class Ex4 { 
    /*           a completer  */
	public static int rang(char c, char[] tab) {
		int i;
		int rg=0;
		for(i=0;i<tab.length;i++) {
			if(tab[i]==c) {
				rg=i;
			}
		}
		return rg;
	}//rang
	
	public static char[] decode(char[] message, char[] entree, char[] sortie) {
		int i;
		int rg;
		for(i=0;i<message.length;i++) {
			rg=rang(message[i],sortie);//On cherche à quel rang appartient les lettres de notre message, dans notre tableau de sortie.
			message[i]=entree[rg];//Ensuite on affecte a notre message, les lettres du tableau entree, qui sont associé aux rangs qu'on a cherché precedemment.
			//Exemple : Pour i=0; rg = rang(message[0],sortie) = rang('Z',sortie)/ message[0]=entree[0]='B'
		}
		return message;
		
	}//decode
	
	static char[] supprime3  (char[] tCar, int k){
	    char []nvtCar = new char[tCar.length-1];
	    for(int i=0 ; i<k ; i++){
		nvtCar[i] = tCar[i];
	    }     
	    for(int i=k+1 ; i<tCar.length ; i++){
		nvtCar[i-1] = tCar[i];
	    }//for i
	    return nvtCar; 
	  }//supprime3 est une fonction qui supprime un caractere
	
	public static char[] compacte (char[] phrase)
	{
		int i,j;
		for(i=0;i<phrase.length;i++) 
		{
			if((phrase[i]==' '))
			{
				phrase=supprime3(phrase,i);

			}	
		}
		
		for(i=0;i<phrase.length-1;i++) {
			for(j=i+1;j<phrase.length;j++) {
				if(phrase[i]==phrase[j]) {
					phrase=supprime3(phrase,j);
				}
			}
		}
		return phrase;
	}//Compacte est une fonction qui supprime les espaces et les caracteres qui apparaissent plus de 1 fois
	
	
  public static void main(String args[]) { 
	 
    char[] entree ={'A','B','C','D','E','F','G','H','I','J','K','L','M',
                    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] sortie ={'F','Z','H','L','B','O','T','D','K','A','W','Y','C',
                    'X','E','V','G','U','I','S','J','R','M','Q','N','P'};
    char[] messCode={'Z','E','X','A','E','J','U'};
    char[] phrase ={ 'H','U','M','E','Z',' ','C','E','B','O','N',' ','V','I','E','U','X',' ','W','H','I','S','K','Y',' ','Q','U',' ','A','L','F','R','E','D',' ','J','U','G','E',' ','C','A','P','I','T','E','U','X'}; 
    /***..........a completer*/
    System.out.println(rang('F',sortie));
  
    System.out.println(decode(messCode,entree,sortie));
    
    System.out.println(compacte(phrase));
   
    
    }//main
  }//class
