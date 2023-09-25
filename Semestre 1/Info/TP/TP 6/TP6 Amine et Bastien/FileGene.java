package fr.amine.tp6;

public class FileGene<T> {
	private T[] mem;
	private int tete;
	private int queue;

	private int suivant(int i) { //retourne l'index dans le tableau mem
		return (i+1)%mem.length;//Permet à i de faire un cycle dans le tableau mémoire
	}

	public FileGene() { 
		mem=(T[])new Object [1000];//Créer le tableau de mémoire 
		tete=0;			// initialise la tête et la queue de la file à 0
		queue=0;
	}
	
	public FileGene(int n) {
		mem= (T[])new Object[n+1];//Créer le tableau de mémoire dont la taille est de n+1, avec n un paramètre en entrée
		tete=0; // initialise la tête et la queue de la file à 0
		queue=0;
	}
	
	public FileGene(FileGene<T> f) {
		mem=(T[])new Object[f.mem.length]; //Créer le tableau de mémoire dont la taille, 
									//est egal à la taille de la file f mis en paramètre d'entrée
		for(int i=0;i<mem.length;i++) {//Copie/colle les élement de la file f dans notre file 
			mem[i]=f.mem[i];
			
		}
		tete=f.tete; //initialise la tête à la tête de la file f
		queue=f.queue;	//initialise la queue à la queue de la file f
	}
	
	public boolean fileVide() {//La file est vide si la métode retourne vrai
		return(queue==tete); //Retourne vrai si les indices queue et tete sont confondus
		
	}
	
	public boolean filePleine() {//La file est pleine si la métode retourne vrai
		return suivant(queue)==tete;//Retourne vrai si l'indice tete=queue+1
	}
	
	public int nbElement() {//Retourne le nombre d'élément de la file
		if(queue>=tete) { 
			return queue-tete;
		}else {	//Si tete>queue
			return mem.length-tete+queue; //Retourne taille du tableau memoire-tete+queue
		}
	}
	
	public void ajoutFile(T o) {//Ajoute un élément dans la file
		if(filePleine()) {
			System.out.println("File pleine");
			System.exit(-1);
		}else {
			mem[queue]=o; //Quand on ajoute un élément dans la file, celui-ci devient le dernier élement de la file
						  //Donc cet élément ajouter est d'indice queue
			queue=suivant(queue); //queue = queue+1, on incrémente la queue pour pouvoir ajouter un élément après
		}
		
			
	}
	
	public T oteFile() {//Retourne l'élément qu'on souhaite enlever
		T val=mem[tete];
		if(fileVide()) {
			System.out.println("File vide");
			System.exit(-1);
			
		}
		else {	//Dans une file c'est l'élément d'indice tete qui part 
			 val=mem[tete];//on stock l'élementt qu'on souhaite enlever dans une variable
			
			tete=suivant(tete);//tete=tete+1,on passe au nouveau élément qui sera d'indice tete
			
			
		}
		return val;//on retourne la variable qui contient l'élément qu'on souhaite enlever
		//Attention cette méthode ne supprime pas l'élément dans le tableu de mémoir.
		//Il retourne juste un élément.
		//C'est grace à l'incrémentation de la tete, et de la méthode toString
		//qu'à l'affichage on ne voit plus l'élément qu'on souhaitez enlevé.
		
		
		
	}
	
	public String toString() {//Affiche les éléments de l'ensemble
		String ch="[";
		
			int cpt=0;//On initialise un compteur à 0.
					  //Ce compteur comptera le nombre de fois qu'on affiche un élement dans la file.
			for(int i=tete;cpt<nbElement();i=suivant(i)) {//Pour i partant de tete. i=i+1 ou tete=tete+1 
														  //jusqu'à que compteur<nombre d'élément de la file
														//On utilise i=suivant(i) au lieu de i++, car on veut que i=tete face un cycle grace à la méthode suivant()
															
				cpt++;//incrémente le compteur pour chaque élement affiché
				ch+=mem[i]+",";//Affiche un élément de la file
			}
	
			ch+=(mem[queue]);//Affiche l'élément d'indice queue, dernier élément de la file
		
			
		
		ch+="]\n";
		return ch;
	}
	
	public T ithelement(int i) {//Retourne un élément de la file en donnant son index
		return mem[i];
	}
	public boolean egal(FileGene<T> f) {//Retourne (Vrais/Faux) si 2 files sont égaux
		
		
			for(int i =f.tete;i!=f.queue;i=suivant(i)) {
				
					if(mem[i+tete]!=f.mem[i]) {
						return false; //Faux si les éléments des 2 files ne sont pas égaux
					}	
				
				
					
				
			}
			
		return true;//Vrais sinon
		
	}
	
	

	public static void main(String[] args) {
		FileGene<Integer> I0 =new FileGene<Integer>();
		FileGene<Integer> I1 =new FileGene<Integer>(3);
		
		I0.ajoutFile(3);
		I0.ajoutFile(2);
		I0.ajoutFile(1);
		System.out.println("File 0 :");
		System.out.println(I0);
		System.out.println("Le 1er élément de la file f0 est : "+I0.ithelement(0));
		I1.ajoutFile(1);
		I1.ajoutFile(2);
		I1.ajoutFile(3);
		System.out.println("File 1 :");
		System.out.println(I1);
		System.out.println("Nombre d'éléments dans la file 1 = "+I1.nbElement());
		FileGene<Integer> I2 =new FileGene<Integer>(I1);
		System.out.println("Les files 0 et sont 1 égaux ? Réponse : "+I0.egal(I1));
		System.out.println("Les files 1 et sont 2 égaux ? Réponse : "+I1.egal(I2));
		I1.oteFile();
		System.out.println("File 1 :");
		System.out.println(I1);
		System.out.println("File 2 :");
		System.out.println(I2);
		System.out.println("Les files 1 et sont 2 égaux ? Réponse : "+I1.egal(I2));
		
		
		
		
		
		

	}

}
