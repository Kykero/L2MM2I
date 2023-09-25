package fr.amine.monprogramme;
import java.util.*;


public class ArbreGene <Element> implements Arbre <Element>{
	private Element element;//Element conetenu dans les racines
	private LinkedList<ArbreGene<Element>>fils;//Liste de type ArbreGene, elle contient donc des variales de types Element
	

	public ArbreGene() {//Constructeur sans paramètre
		
		element = null;
		fils = new LinkedList<ArbreGene<Element>>();
		
	}
	
	public ArbreGene(Element e) {//Constructeur avec paramètre
		element =e;
		fils = new LinkedList<ArbreGene<Element>>();
	}
	
	public ArbreGene(Arbre <Element> a) {//Constructeur de clonnage
		element = a.getElement();
		fils = new LinkedList<ArbreGene<Element>>();
		for(int i = 0;i<a.getDegree();i++) {
			fils.add(new ArbreGene<Element>(a.getNode(i)));
		}
	}
	
	public Element getElement() {//Renvoie l'élément d'un arbre
		return element;
	}
	
	public int getDegree() {//affiche la taille de la liste fils
		return fils.size();
		
	}
	public Arbre<Element> getNode (int i){//Affiche le
		if((i<0)||(i>=fils.size())) {
			System.out.println("ArbreGene : getNode("+i+") : Erreur, l'indice n'est pas valide.");
			System.exit(-1);
		}
		return fils.get(i);
	}
	public boolean isEmpty() {//Renvoie vrai ou faux si l'arbre est vide
		return (element==null);
	}
	public boolean isLeaf() {
		//Renvoie vrai ou faux si l'arbre à une feuille c'est à dire qu'il a pas de noeud 
		return (fils.size()==0);
	}
	public void setElement(Element e) {
		//Remplace l'élement d'un arbre par l'élement "e" en paramètre d'entrée
		element=e;
	}
	public void addNode(Arbre<Element> a) {//Permet d'ajouter l'élément d'un arbre dans un autre arbre, "on les relie les 2 arbres"
		fils.add(new ArbreGene<Element>(a));
	}
	public void deleteNode (int i ) {//Retire un élément d'indice i dans la liste fils d'un arbre
		if((i<0)||(i>=fils.size())) {
			System.out.println("ArbreGene : deleteNode("+i+") : Erreur, l'indice n'est pas valide.");
			System.exit(-1);
		}
		fils.remove(i);
		
	}
	public String toString() {//Affcihe tous les élément contenus dans la liste fils d'un arbre
		String ch="";
		if(!isEmpty()) {
			ch+=getElement()+",";
			for(int i =0;i<getDegree()-1;i++) {
				ch+=getNode(i).toString();
			}
			if(getDegree()>=1) {
				ch+=getNode(getDegree()-1).toString();
			}
		}
		return ch;
	}
	
	public boolean equals(Arbre<Element>a) {//Retourne vrais ou faux si 2 arbres sont égaux
		boolean flag=true;
		 if(getDegree()==a.getDegree()) {
			 for(int i=0 ; i<getDegree() ; i++) {
				 getNode(i).equals(a.getNode(i));
				 if(getElement()!=a.getElement()) {
					 flag = false;
				 }
			 } 
		 }
		 else {
               
			 flag=false;
		 }
		 return flag;
	}
	public int getHeight() {//Affiche la hauteur de l'arbre, soit le nombre de listes "fils"
		
		int max=0;
		int h;
		if(isLeaf()) {
			return 0;
		}
		for(int i =0;i<getDegree();i++) {
			h=getNode(i).getHeight();
			if(h>max) {
				max=h;
			}
		}
		return (1+max);
		
		
	}
	

	public static void main(String[] args) {
		ArbreGene<String> re = new ArbreGene<String>();
		ArbreGene<String> r = new ArbreGene<String>("Roi");
		ArbreGene<String> na = new ArbreGene<String>("Noble A");
		ArbreGene<String> nb = new ArbreGene<String>("Noble B");
		ArbreGene<String> ta = new ArbreGene<String>("Troupe A");
		ArbreGene<String> c1 = new ArbreGene<String>("Chevalier 1");
		ArbreGene<String> c2 = new ArbreGene<String>("Chevalier 2");
		ArbreGene<String> tb = new ArbreGene<String>("Troupe B");
		
		ArbreGene<String> l1 = new ArbreGene<String>("L1 maths");
		ArbreGene<String> l2 = new ArbreGene<String>("L2 maths");
		ArbreGene<String> li = new ArbreGene<String>("L2 maths-informatique");
		ArbreGene<String> lp = new ArbreGene<String>("L2 maths-physique");
		ArbreGene<String> lm = new ArbreGene<String>("L2 maths-mécanique");
		ArbreGene<String> ln = new ArbreGene<String>("L2 maths-neuro-science");
		
		
		
		//Arbre 1
		ta.addNode(c1);
		ta.addNode(c2);
		tb.addNode(c1);
		tb.addNode(c2);
		na.addNode(ta);
		nb.addNode(tb);
		r.addNode(na);
		r.addNode(nb);
		
		//Arbre 2
		l2.addNode(ln);
		l2.addNode(lm);
		l2.addNode(lp);
		l2.addNode(li);
		l1.addNode(l2);
		
		System.out.println("Arbre 0 :"+re);
		System.out.println();
		System.out.println("L'arbre 0 est vide ? Réponse :"+re.isEmpty());
		System.out.println("getHeight de re :"+re.getHeight());
		System.out.println();
		re.setElement("Reine");
		System.out.println("Arbre 0 :\n"+re);
		System.out.println();
		System.out.println("====================================================");
		System.out.println();
		System.out.println("Arbre 1 :\n"+r);
		System.out.println();
		System.out.println("getHeight de r :"+r.getHeight());
		System.out.println();
		System.out.println("getElement de r :"+r.getElement());
		System.out.println();
		System.out.println("getDegree de r :"+r.getDegree());
		System.out.println();
		System.out.println("getNode(0) de r : "+r.getNode(0));
		System.out.println("getNode(1) de r : "+r.getNode(0));
		System.out.println();
		System.out.println("c1 est une feuille ? Réponse : "+c1.isLeaf());
		System.out.println("====================================================");
		System.out.println();
		ArbreGene<String> R = new ArbreGene<String>(r);
		System.out.println("Arbre 1 (clone):\n"+R);
		System.out.println();
		System.out.println("L'arbre 1 et l'arbre 1 (clone) sont-ils égaux ? Réponse :"+r.equals(R));
		System.out.println();
		System.out.println("====================================================");
		System.out.println();
		R.deleteNode(1);
		System.out.println();
		System.out.println("Arbre 1 (clone) après modification:\n"+R);
		System.out.println();
		System.out.println("L'arbre 1 et l'arbre 1 (clone modifié) sont-ils égaux ? Réponse :"+r.equals(R));
		System.out.println();
		System.out.println("getElement de R : "+R.getElement());
		System.out.println();
		System.out.println("getDegree de R : "+R.getDegree());
		System.out.println();
		System.out.println("getNode(0) de R : "+R.getNode(0));
		System.out.println("getNode(1) de R : "+R.getNode(0));
		System.out.println();
		System.out.println("====================================================");
		System.out.println();
		System.out.println("Arbre 2 :\n"+l1);
		System.out.println();
		System.out.println("L'arbre 1 et l'arbre 2 sont-ils égaux ? Réponse :"+r.equals(l1));
		System.out.println();
		System.out.println("getElement de l1 : "+l1.getElement());
		System.out.println();
		System.out.println("getDegree de l1 : "+l1.getDegree());
		System.out.println();
		System.out.println("getNode(0) de l1 : "+l1.getNode(0));
		System.out.println();
		System.out.println("====================================================");
		
		
		
		
		

	}

}
