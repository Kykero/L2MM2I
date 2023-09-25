
package fr.amine.tp2;
/**
 *
 *       tableau et boucles for 
 * 
 */


public  class Ex3 { 

  /**
   *   Cette méthode supprime le kème caractère dans un tableau
   *   en décalant tous les caractères situés à sa droite
   *    @param tableau de caractères tCar
   *    @param rang du caractère à supprimer k
   *    @return void
   *    
   */
 static void  supprime1  (char[] tCar, int k){     
    for(int i=tCar.length-1 ; i>k ; i--){
	tCar[i-1] = tCar[i];
    }//for i 
  }//supprime1

 static void  supprime2  (char[] tCar, int k){     
    for(int i=k+1 ; i<tCar.length ; i++){
	tCar[i-1] = tCar[i];
    }//for i 
  }//supprime2

static char[] supprime3  (char[] tCar, int k){
    char []nvtCar = new char[tCar.length-1];
    for(int i=0 ; i<k ; i++){
	nvtCar[i] = tCar[i];
    }     
    for(int i=k+1 ; i<tCar.length ; i++){
	nvtCar[i-1] = tCar[i];
    }//for i
    return nvtCar; 
  }//supprime3

 /**
   *   Cette méthode insère un  caractère dans un tableau
   *   à la kème place
   *   en décalant tous les caractères situés à sa droite
   *    @param tableau de caractères tCar
   *    @param le caractère à insérer
   *    @param rang k du caractère c à insérer 
   *    
   */
static void  insere1  (char[] tCar,char c, int k){     
    for(int i=tCar.length-1 ; i>k ; i--){
	tCar[i] = tCar[i-1];
    }//for i 
    tCar[k]=c;
  }//insère1

 static void affiche(String nom,  char[] tCar){
     System.out.print(nom +" : ");
     for (int i =0; i<tCar.length ; i++){
	 System.out.print(tCar[i]+" ");
     }//for i
     System.out.println();
 }//affiche



  public static void main(String args[]) { 
  
     char[] tCar1 =  {'a','b','c','d','e','f'};
     char[] tCar1bis = tCar1;
     char[] tCar2 =  {'a','b','c','d','e','f'};
     char[] tCar3 =  {'a','b','c','d','e','f'};
 
     affiche("tCar1",tCar1);
      supprime1(tCar1,2);
      affiche("tCar1 apres supprime1",tCar1);
              //expliquer le resultat obtenu
      //Le dernier caractere de notre chaine , ici "f",d'indice 5, a ete affecte aux autres caractere 
      //d'indice inferieur jusqu'a l'indice 2, indice 2 compris. Donc les caractere c , d, e ont ete remplace par le caractere f.
	affiche("tCar1bis apres supprime1",tCar1bis);
              //expliquer pourquoi tCar1bis a ete modifie
	//tCarbisa ete modifie car il est lier a tCar1 a cause de la commande employe a la ligne 72.
	//Les 2 chaines partagent donc la meme adresse et donc si l'un est modifie alors l'autre aussi.

      //-----------------------------------------------------
  
      affiche("tCar2",tCar2);
      supprime2(tCar2,2);
      affiche("tCar2 apres supprime2",tCar2);
             //expliquer le resultat obtenu 
      //La fonction a supprimer le caracter d'indice 2, qu'on a entree en parametre d'entree (ici 'c').
      //Processus : La fonction affecte le caractere d'indice 2 avec celui d'indice 3(on a donc {'a','b','d','d','e','f'}),
      //  ensuite il affecte celui d'indice 3, a celle d'indice 4 ( on a donc {'a','b','d','e','e','f'},
       //et enfin il affecte celui d'indice 4 à celle d'indice 5 ( on a donc {'a','b','c','d','f','f'}.
      //On a un doublon de la derniere caractere, pour conserver la taille de notre chaine de caractere,vu qu'on a supprmier un caractere, ici 'c'.
  //
      //-----------------------------------------------------
    
      affiche("tCar3",tCar3);
      supprime3(tCar3,2);
      affiche("tCar3",tCar3);
           //pourquoi tCar3 n'est-il pas modifie ?
      //tCar3 n'est pas modifiee car la fonction supprime3 retourne une chaine de caractere, et il ne modifie donc pas tCar3 via son adresse.
      //Donc la on a que afficher tCar3 comme on l'a initialise.
      
      affiche("tableau apres supprime3",supprime3(tCar3,2));
          //pourquoi met-on l'appel à la methode supprime3 dans affiche
      //Car la fonction supprime3 retourne une chaine de caractere.
      
      //----------------------------------------------------------
     affiche("tCar3",tCar3);
      insere1(tCar3,'x',2);
           //pourquoi y-a-t-il erreur à l'execution? modifier insere1
      //Il y a une erreur d'espace memoir. On effectue des affectations sur des indices qui dépassent la taille de la chaine.
      affiche("tCar3",tCar3);
  
    }//main
  }//class
