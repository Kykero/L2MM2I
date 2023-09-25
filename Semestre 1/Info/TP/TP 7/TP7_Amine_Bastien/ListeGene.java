package fr.amine.tp7;



public class ListeGene <T>{


	private class Chainon{//Créer une classe Chainon
		public T val; //Valeur que contient le chainon
		public Chainon suiv;//Pointeur qui cible le prochain Chainon
	}
	private Chainon tete;//L'élément tête de la liste
	private Chainon queue;//L'élément queue de la liste 
	private Chainon ec; //L'élément courant de la liste, qui représente un pointeur

	public ListeGene() {//On initialise les élements de la liste à null
		tete=null;
		queue=null;
		ec=null;
	}//Constructeur de ListeChaine
	
	public static void main(String[] args) {
		ListeGene<Integer> l1 = new ListeGene<Integer>();//Création d'une liste d'entier
		ListeGene<Integer> l2 = new ListeGene<Integer>();
		
		int i=0;
		l1.ajoutd(2);
		l1.ajoutd(3);
		l1.ajoutd(4);
		System.out.println("Liste 1 \n:"+l1);
		System.out.println("La valeur de l'élément à la "+i+"-ième place de la liste 1 est :"+l1.ithelement(i));
		l1.ajoutg(5);
		System.out.println("Liste 1 après l'ajout d'un élément dans la liste :\n"+l1);
		l1.oterec();
		System.out.println("Liste 1 après avoir retiré l'élément courantde la liste :\n"+l1);
		l1.ithelement(0);//déplace le pointeur élement courant en position 0 c'est à dire sur le pointeur tete.
		l1.oterec();
		System.out.println("Liste 1 après avoir retiré l'élément courant,en tete  de la liste :\n"+l1);
		l1.ithelement(1);//déplace le pointeur élement courant en position 1, c'est à dire sur le pointeur queue dans ce cas la.
		l1.oterec();
		System.out.println("Liste 1 après avoir retiré l'élément courant, en queue  de la liste :\n"+l1);
		
		System.out.println("========================================");
		
		l1.viderListe();
		System.out.println("Liste 1 après l'avoir vidée :"+l1);
		l1.ajoutd(2);
		l1.ajoutd(5);
		System.out.println("Nouvelle Liste 1 :"+l1);
		l1.ithelement(0);
		l1.modifec(3);
		System.out.println("Liste 1 après avoir modifié la valeur de l'élément courant :\n"+l1);
		
		System.out.println("========================================");
		
		l2.ajoutd(3);
		l2.ajoutd(5);
		l2.ajoutd(4);
		System.out.println("Liste 2 :"+l2);
		
		System.out.println("========================================");
		
		System.out.println("Est-ce que les listes 1 et 2 sont égeaux ? Réponse :"+l1.egal(l2));
		
		System.out.println("========================================");
		l1.ajoutd(4);
		System.out.println("Liste 1 après l'ajout d'un élément dans la liste :\n"+l1);
		System.out.println("Liste 2 :"+l2);
		
		System.out.println("========================================");
		
		System.out.println("Est-ce que les listes 1 et 2 sont égeaux ? Réponse :"+l1.egal(l2));
		
	}
	
	public boolean listeVide() {//Renvoie vrais si une liste est vide, sinon faux.
		return (tete==null);//Renvoie vraie si l'élément tête est null.
	}//listeVide
	
	public void entete() {//Place l'élément courant en tête de la liste
		ec=tete;
	}//entete
	public void enqueue() {//Place l'élément courant en queue de la liste
		ec=queue;
	}//enqueue
	 public boolean horsListe()//Renvoie vrais/faux si l'élément courant est null, 
	 							//c'est à dire qu'il n'est plus entre la tête et la queue.
	 							//Il est donc hors de la liste
	 {
		 return (ec==null);
	 }
	 public T valec() {//Renvoie la valeur contenue dans le chainon où est placé l'élément courant.
		 if(horsListe()) {
			 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
			 System.exit(-1);
		 }
		 return ec.val;
	 }//valec
	public void modifec(T x) {//Modifie la valeur contenue, dans le chainon de l'élément courant.
		 if(horsListe()) {
			 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
			 System.exit(-1);
		 }
		 ec.val=x;
	}//modifec
	public void succ() {//L'élément courant passe à un autre chainon.
		 if(horsListe()) {
			 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
			 System.exit(-1);
		 }
		 ec=ec.suiv;
	}//succ
	public void pred() {//L'élement courant retourne au chainon qui lui précédé.
		 if(horsListe()) {
			 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
			 System.exit(-1);
		 }
		 if(ec==tete) {
			 ec=null;
		 }
		 else {
			 Chainon pt =ec;//On place un pointeur sur le chainonù est placé l'élément courant.
			 ec=tete;//On place l'élément courant au début
			 while(ec.suiv!=pt) {//Tant que le poiteur ec ne pointe pas le chainon où est placé le pointeur pt.
				 				//On fait placé le pointeur ec, au prochain chainon.
				 succ();
			 }
		 }
	}//pred
	public void ajoutd(T x) {//Ajoute un chainon contenant la valeur x, à droite du chainon où est placé le pointeur ec.
		if(listeVide()) {//Initialise les éléments de la liste sur le chainon maillon,si la liste est vide.
			Chainon maillon = new Chainon();
			maillon.val=x;
			maillon.suiv=null;
			ec=maillon;
			tete=maillon;
			queue=maillon;
			
		}else {
			 if(horsListe()) {
				 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
				 System.exit(-1);
			 }
			 Chainon maillon2=new Chainon();//On créer un chainon maillon.
			 maillon2.val=x;
			 maillon2.suiv=ec.suiv;
			 ec.suiv=maillon2;
			 if(ec==queue) {
				 queue=maillon2;
				 
			 }
			//ec=queue;
			 
		}
		 
	}
	
	public String toString() {//Affiche la liste
		String ch ="[";
		if(!listeVide()) {
			Chainon ptr =ec;
			entete();
			while(ec.suiv!=null) {
				ch+=valec()+",";
				succ();
			}
			ch+=valec()+" ";
			ec=ptr;
		}
		ch+="]";
		return ch;
	}//toString
	
	public int nbElement() {//Renvoie le nombre d'élément dans la liste.
		int cpt=0;
		Chainon pt =ec;
		entete();
		if(listeVide()) {
			System.out.println("ListeChaine : nbElement():Erreur");
			System.exit(-1);
		}
		while(ec!=queue.suiv) {
			succ();
			cpt++;
		}
		ec=pt;
		return cpt;
	}//nbElement
	
	public void ajoutg(T x) {//Ajoute un chainon contenant la valeur x, à gauche du chainon où est placé le pointeur ec.
		
		if(listeVide()) {
			Chainon maillon = new Chainon();
			maillon.val=x;
			maillon.suiv=null;
			ec=maillon;
			tete=maillon;
			queue=maillon;
			
		}else {
			 if(horsListe()) {
				 System.out.println("ListeChaine : valec() : Erreue : hors liste !");
				 System.exit(-1);
			 }
			
			 Chainon maillon = new Chainon();
			 maillon.val=x;
			 if(ec==tete) {
				maillon.suiv=ec;
				tete=maillon;
			 }else {
				 maillon.suiv=ec;
				 
				 pred();
				 ec.suiv=maillon;
			 }
			 
		}
		
	}
	
	public void oterec()  {//Brise la liaison du chainon où est placé le pointeur ec, avec la liste
		if(listeVide()) {
			System.out.println("LiseChaine : oterec() : Erreur : chaine vide");
			System.exit(-1);
		}
		if(ec==null) {
			System.out.println("LiseChaine : oterec() : Erreur : Element courant est null");
			System.exit(-1);
		}
		if(ec==tete) {
			tete=tete.suiv;
		}else if (ec==queue) {
			pred();
			queue=ec;
			queue.suiv=null;
		}else {
			Chainon p1;
			pred();
			p1=ec;
			succ();
			succ();
			p1.suiv=ec;
		}
	}//oterec
	
	public void viderListe() {//Vide la liste
		tete=null;
		queue=null;
		ec=null;
	}//viderListe
	
	public T ithelement(int i) {//déplace le pointeur ec à la position i et retourne la valeur qu'il contient.
		//Chainon pt=ec;
		entete();
		int cpt=0;
		T n;
		while(cpt!=i) {
			cpt++;
			succ();
				
		}
		n= ec.val;
		//ec=pt;
		return n;
	}
	public boolean egal(ListeGene<T> I) {//Renvoie vrais ou faux sur l'égalité de 2 listes.
		boolean flag=true;
		Chainon p1=ec;
		Chainon p2=I.ec;
		entete();
		I.entete();
		if(nbElement()!=I.nbElement()) {
			System.out.println("Les listes n'ont pas le même nombre d'éléments(ou chainons) par conséquent elles ne sont pas égaux");
			
			return flag =false;
			
		}
		while(ec.suiv!=null)
		{
			if(valec()!=I.valec())
			{
				flag=false;
			}
			
			succ();
			I.succ();
		}
		if(valec()!=I.valec()) 
		{
			
			flag=false;
		}
		ec=p1;
		I.ec=p2;
	
		return flag;
		
	}//egal


}
