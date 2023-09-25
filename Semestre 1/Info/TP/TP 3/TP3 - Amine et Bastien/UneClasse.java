package fr.amine.tp3_objets_et_classes;

public class UneClasse {

	 private Etudiant[] tabEtd; //tableau contenant les étudiants de la classe
	  private Groupe[]  tabGroupe; //Tableau contenant les groupes qui vont définir la répartition des étudiants
	  
	  public UneClasse(int nbEtudiant,int nbGroupe) {//Défini le tableau des étudiants et le tableau de groupe.
		  											//Ces tableaux sont vides, il faudra ensuite remplir le tableau des étudiants avec des étudiants
	   tabEtd = new Etudiant [nbEtudiant];
	   tabGroupe = new Groupe [nbGroupe];
	   if(nbEtudiant%nbGroupe!=0) { //Vérifie si le nombre d'étudiant est divisible par le nombre de groupe.
		   System.out.println("Il faut que le nombre d'étudiant soit divisible par le nombre de groupes");
		   System.exit(-1);
	   }else {
		   for(int i=0;i<tabGroupe.length;i++) {
			   tabGroupe[i]= new Groupe (nbEtudiant/nbGroupe);
		   }

	   }
	   	  }//Constructeur UneClasse
	  
	  public UneClasse(String[] tabNom, int[][] tabChoix) {//Créer une classe d'étudiant
															//à partir d'un tableau de nom et d'un tableau de choix
		  
		  tabEtd=new Etudiant [tabNom.length];
		  tabGroupe = new Groupe[tabChoix[0].length];
		  for(int i=0;i<tabNom.length;i++) {
	    	  tabEtd[i]= new Etudiant (tabNom[i],tabChoix[i]);
	    	  
	      }
		  
		  if(tabEtd.length%tabGroupe.length!=0) {//Vérifie si le nombre d'étudiant est divisible par le nombre de groupe.
			   System.out.println("Il faut que le nombre d'étudiant soit divisible par le nombre de groupes");
			   System.exit(-1);
		   }else {
			   for(int i=0;i<tabGroupe.length;i++) {
				   tabGroupe[i]= new Groupe (tabEtd.length/tabGroupe.length);
			   }
		   }
		  
		  
		  
	     
	  }//Constructeur UneClasse
	  
	  public void repartir() { //Réparti les étudiants de la classe dans les groupes en respectant leur choix
		  					//tant que le groupe demandé n'est pas plein.
		  
		
		  
		  for(int i =0;i<tabEtd.length;i++) {
			  boolean add = false;// On initialise le boolean à false pour que !add = true au début.
			  for(int j=0;j<tabEtd[i].getChoix().length && !add;j++) {
				  //Généralement la condition d'arrêt d'une boucle renvoie un booléen.
				  //Si c'est vrai alors j incrémente, et si c'est faux alors la boucle j s'arrête.
				  //Et on incrémente la boucle i (car la boucle j est dans la boucle i, 
				  //sinon on arrête juste la boucle j).
				  
				  //Ici la boucle j incrémente ssi j< nombre de choix et add= true.
				  //Et la boucle j s'arrête ssi j= nombre de choix OU add = false à cause du connecteur logique && 
				  //qui renvoie false si au moins un booléen est false.
				  //Et dans ce cas on incrémente i pour passer au prochain étudiant.
				  
				  //Donc concrètement.
				  //Une fois que un étudiant est ajouté, add = true.
				  //et donc !add = false.
				  //Par conséquent la condition de fin de la boucle :
				  //"j<tabEtd[i].getChoix().length && !add" renvoie false, 
				  //et on sort de la boucle j.
				  //Puis on incrémente la boucle de i.
				  //Si le groupe est plein, pour le choix d'un étudiant. 
				  //Alors add= false, et donc !add= true.
				  //Par conséquent la condition de fin de la boucle renvoie true si j< nombre de choix.
				  //Et si c'est le cas alors c'est j qui incrémente, 
				  //cad qu'on passe aux prochain choix de l'étudiant.
				  
				  
				  if(tabEtd[i].getChoix()[j]>tabGroupe.length) {
					  System.out.println("Le Groupe "+tabEtd[i].getChoix()[j]+" n'existe pas");
					  System.out.println("Entrer un groupe compris entre 0 et "+(tabGroupe.length-1));
					  System.exit(-1);
					  
				  }else {
					  
					  add=tabGroupe[tabEtd[i].getChoix()[j]].ajoute(tabEtd[i]);
					  
				  }
				  
				   //Remarque : On utilise la fonction getChoix si on protège l'attribut choix de la classe Etudiant.
				  //Sinon on écrit tabEtd[i].choix[]
				  
			  	}

		  }  
		  
	  }//repartir

	  
	  
	  public void affiche() {

	    for(int i=0;i<tabGroupe.length;i++) {//affiche les étudiants de la classe par groupe
	    	System.out.println("Groupe "+i+" :");
	    	tabGroupe[i].affiche();
	    }
	    System.out.println();
	  }//affiche
	  
	  public static void main (String args[]) {
	                 
	    // premier type d'initialisation possible
	    // en definissant les etudiants par lecture au clavier
	    
	   System.out.println("premier type d'initialisation");
	    
	    UneClasse C1 = new UneClasse(4,2);

	    String[] nomC1 = {"e1","e2","e3","e4"};
		int[][] choixC1 = { {0,1}, {1,0}, {0,1}, {1,0} };
		
		for(int i = 0; i<nomC1.length; i++) {
			C1.tabEtd[i] = new Etudiant(nomC1[i], choixC1[i]);
		}
		
		C1.repartir();
		C1.affiche();
	    
	    // 2nd type d'initialisation possible
	    // en definissant les etudiants les uns apres les autres
	      
	    System.out.println("deuxieme type d'initialisation");
	     UneClasse C2 = new UneClasse(6,3);
	     String[] nomC2 = {"e1","e2","e3","e4","e5","e6"};
	     int [][]choixC2 = {{0,1,2},{0,2,1},{1,2,0},{1,0,2},{2,0,1},{1,0,2},};
	     for(int i=0;i<nomC2.length;i++) {
	    	 C2.tabEtd[i]=new Etudiant(nomC2[i],choixC2[i]);
	     }
	     C2.repartir();
	     C2.affiche();
	     
	    
	   
		   
	        
	  
	     // 3ème type d'initialisation possible
	     // a partir d'un tableau de noms et de choix
	    
	    System.out.println("troisieme type d'initialisation");
	      
	     String[] nom = {"e1","e2","e3","e4","e5","e6","e7","e8","e9","e10"};
	     int[][] choix={   {0,1,2,3,4} , {1,2,3,4,0}, {0,2,4,3,1} ,{0,2,3,4,1} , {0,1,2,3,4}  
	                     , {1,2,4,3,0} , {0,2,4,3,1} ,{4,2,3,1,0} ,{1,4,3,2,0} , {0,1,2,3,4}};
	                    
	     // ... a completer ....
	     UneClasse C3 = new UneClasse(nom,choix);
	     
	     C3.repartir();
	     C3.affiche();
	    
	     
	  }

	}