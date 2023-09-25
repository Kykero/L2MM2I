package fr.amine.tp6;

public class FileArray implements File {
	private int[] mem; //tableau de mémoire représentant la file
	private int tete; //tête/début de la file
	private int queue;//queue/fin de la file

	private int suivant(int i) { //retourne l'index dans le tableau mem
		return (i+1)%mem.length;//Permet à i de faire un cycle dans le tableau mémoire
	}

	public FileArray() { 
		mem=new int [1000];//Créer le tableau de mémoire 
		tete=0;			// initialise la tête et la queue de la file à 0
		queue=0;
	}
	
	public FileArray(int n) {
		mem=new int[n+1];//Créer le tableau de mémoire dont la taille est de n+1, avec n un paramètre en entrée
		tete=0; // initialise la tête et la queue de la file à 0
		queue=0;
	}
	
	public FileArray(FileArray f) {
		mem=new int[f.mem.length]; //Créer le tableau de mémoire dont la taille, 
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
			return mem.length-tete+queue; //Retourne taille de la memoire-tete+queue
		}
	}
	
	public void ajoutFile(int o) {//Ajoute un élément dans la file
		if(filePleine()) {
			System.out.println("File pleine");
			System.exit(-1);
		}else {
			mem[queue]=o; //Quand on ajoute un élément dans la file, celui-ci devient le dernier élement de la file
						  //Donc cet élément ajouter est d'indice queue
			queue=suivant(queue); //queue = queue+1, on incrémente la queue pour pouvoir ajouter un élément après
		}
		
			
	}
	
	public int oteFile() {//Retourne l'élément qu'on souhaite enlever
		if(fileVide()) {
			System.out.println("File vide");
			System.exit(-1);
			return -1;
		}
		else {	//Dans une file c'est l'élément d'indice tete qui part 
			int val=mem[tete];//on stock l'élementt qu'on souhaite enlever dans une variable
			
			tete=suivant(tete);//tete=tete+1,on passe au nouveau élément qui sera d'indice tete
			
			return val;//on retourne la variable qui contient l'élément qu'on souhaite enlever
			
		}
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
			
		
		ch+="]\n";
		return ch;
	}
	public int ithelement(int i) {//Retourne un élément de la file en donnant son index
		return mem[i];
	}
	public boolean egal(FileArray f) {//Retourne (Vrais/Faux) si 2 files sont égaux
		for(int i =f.tete;i!=f.queue;i=suivant(i)) {
			if(mem[i+tete]!=f.mem[i]) {
				return false; //Faux si les éléments des 2 files ne sont pas égaux
			}
		}
		return true;//Vrais sinon
	}
	
	public static void main(String [] args) {
		FileArray f0= new FileArray();
		FileArray f1 = new FileArray(3);
		
		f1.ajoutFile(1);
		f1.ajoutFile(2);
		f1.ajoutFile(3);
		f0.ajoutFile(4);
		f0.ajoutFile(5);
		
		System.out.println("File 0 :");
		System.out.println(f0);
		
		System.out.println("Le 1er élément de la file f0 est : "+f0.ithelement(0));
		System.out.println("File 1 :");
		System.out.println(f1);
		System.out.println("Nombre d'éléments dans la file 1 = "+f1.nbElement());
		
		FileArray f2 = new FileArray(f1);
		System.out.println("Les files 0 et sont 1 égaux ? Réponse : "+f0.egal(f1));
		System.out.println("Les files 1 et sont 2 égaux ? Réponse : "+f1.egal(f2));
		
		f1.oteFile();
		System.out.println("File 1 :");
		System.out.println(f1);
		System.out.println("File 2 :");
		System.out.println(f2);
		System.out.println("Les files 1 et sont 2 égaux ? Réponse : "+f1.egal(f2));
		
		
		
	}

	
	
	

}
