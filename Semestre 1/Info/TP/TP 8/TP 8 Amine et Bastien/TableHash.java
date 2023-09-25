package fr.amine.monrpogramme;
import java.util.*;
import  java.util.Iterator;

public class TableHash<Clef,Element>implements Table<Clef,Element> {

	private class Pair <Clef,Element>{
		public Clef key;
		public Element element;
		
		Pair(Clef key, Element element){
			this.key =key;
			this.element=element;
		}
		
		public String toString() {
			return "("+key+","+element+")";
		}
		
	}//Fin classe Pair
	
	Vector <LinkedList<Pair<Clef,Element>>> tab;//Vecteur contenant des listes de coubles (clef-element)
	int count;//Nombre de coubles (clef-element) stockés
	
	//Constructeurs
	public TableHash(int lenght) {
		tab = new Vector<LinkedList<Pair<Clef,Element>>>();
		for(int i=0;i<lenght;i++) {
			tab.add(new LinkedList<Pair<Clef,Element>>());
		}
		count=0;
	}//TableHash avec paramètre
	
	public TableHash(){
		  tab=new Vector<LinkedList<Pair<Clef,Element>>>();
		  tab.add(new LinkedList<Pair<Clef,Element>>());
		  count=0;
	 }//TableHash sans paramètre
	
	public TableHash(TableHash <Clef,Element> t){
		  tab=new Vector<LinkedList<Pair<Clef,Element>>>();
		 
		  LinkedList<Pair<Clef,Element>> list;
		  count=0;
		  for(int i = 0;i<t.size();i++) {
			  list=t.tab.get(i);
			  tab.add(list);

		  }
	}//TableHash clonnage

	public int size() {
		//Retourne la taille de la table
		return tab.size();
	}//size
	public int getCount() {
		//Retourne tous les coubles (clef-element) de la table
		return count;
	}//getCount
	public double getLoadFactor() {
		//retourne la longueur moyenne des listes de la table
		return getCount()/(double)size();
	}//getLoadFactor
	
	protected final int f(Object object) {
		//appel de la méthode hashCode() de la classe Object
		return object.hashCode();
	}//f
	protected final int g (int x) {
		//projette le nombre x dans l'itervalle [0,size()]
		return Math.abs(x)%size();
	}//g
	protected final int h (Object object) {
		//fonction de hachage : h= g o f
		return g(f(object));
	}//h
	public void put(Clef key, Element e) {
		if(containsKey(key)) {
			System.out.println("TableHash : put : La clef des deja presente");
			return;
		}
		tab.get(h(key)).add(new Pair (key,e));
		count++;
	}//put
	
	
	public Element get(Clef key) {
		LinkedList<Pair<Clef,Element>> list_i=tab.get(h(key));
		for(int i=0;i<list_i.size();i++) {
			if((list_i.get(i).key).equals(key)) {
				return list_i.get(i).element;
			}
		}
		return null;
	}//get
	
	public String toString() {
		//Affiche la table de hachage
		String ch ="[";
		LinkedList<Pair<Clef,Element>>list_i;
		for(int i=0;i<size();i++) {
			list_i=tab.get(i);
			for(int j=0;j<list_i.size();j++) {
				ch+=list_i.get(j)+",";
				
			}
		}
		ch+="]";
		return ch;
	}//toString
	
	public boolean containsKey(Clef key) {
		//Retourne vraie si la clée en paramètre est dans le table de hachage
		LinkedList<Pair<Clef,Element>> list_i=tab.get(h(key));
		for(int i=0;i<list_i.size();i++) {
			if((list_i.get(i).key).equals(key)) {
				return true;
			}
		}
		return false;
	}//containsKey
	
	public Element remove(Clef key) {
		//Retourre un element de la table de hachage et le retire de celui-ci
		LinkedList<Pair<Clef,Element>> list_i=tab.get(h(key));
		for(int i=0;i<list_i.size();i++) {
			if((list_i.get(i).key).equals(key)) {
				count--;
				return list_i.remove(i).element;
			}
		}
		return null;
	}//remove

	public boolean containsValue(Element element){
		//Retourne vrai si l'element en entree est dans la table de hachage
		LinkedList<Pair<Clef,Element>>list_i;
		for(int i=0;i<size();i++) {
			list_i=tab.get(i);
			for(int j=0;j<list_i.size();j++) {
				if((list_i.get(j).element).equals(element)) {
					return true;
				}
			}
		}
		return false;
		
	}//containsValue
	
	public boolean isEmpty() {
		//Retourne vrai si la table de hachage est vide
		return(count==0);
	}//isEmpty
	
	public void clear() {
		//Vide la table de hachage
		if(isEmpty()) {
			System.out.println("La table de hachage est déjà vide");
		}else {
			LinkedList<Pair<Clef,Element>>list_i;
			for(int i=0;i<size();i++) {
				list_i=tab.get(i);
				for(int j=0;j<list_i.size();j++) {
					list_i.remove(j);
				}
			}
			count=0;
		}
		
	}//clear
	
	 public Set<Clef> keySet(){
		 //Stocke tous les clés de la table de hachage et le retourne
		 Set<Clef> set = new HashSet<Clef>();
		   for(int i=0; i<size(); i++){
		    LinkedList<Pair<Clef,Element>> l = tab.get(i);
		    for(int j=0; j<l.size(); j++){
		     set.add(l.get(j).key);
		    }
		   }
		     return set;
	 }//keySet
	 
	 public void putAll(Table<Clef,Element>m) {
		 //Stocke tous les clés et les élement de la table de hachage m dans notre table de hachage
		 Set<Clef> set = new HashSet<Clef>();
		 Set<Clef> set2 = new HashSet<Clef>();
		 
		 
		 set=m.keySet();
		 set2=m.keySet();
		 Iterator<Clef> setIterator = set.iterator();
		 Iterator<Clef> setIterator2 = set2.iterator();
		
		 
		 while(setIterator.hasNext()) {
			 put(setIterator.next(),m.get(setIterator2.next()));
			
		 }
	 }//putAll
	
	
	public static void main(String[]  args) {
		
		//Constructeur avec paramètre
		  TableHash<Integer, String> t0 = new TableHash<Integer, String>(10);
		  System.out.println("Table t0 : " + t0);
		  System.out.println("taille de t0 : "+t0.size());
		  System.out.println("Valeur stocké dant t0 : "+t0.getCount());
		  System.out.println("getLoadFactor de t0 : "+t0.getLoadFactor());
		  System.out.println("t0 Vide ? : "+ t0.isEmpty());
		  System.out.println();
		  t0.put(1,"Janvier");
		  t0.put(2, "Fevrier");
		  t0.put(3,"Mars");
		  System.out.println("Table t0 : " + t0);
		  t0.remove(1);
		  System.out.println("Table t0 : " + t0);
		  System.out.println("Valeur stocké dant t0 : "+t0.getCount());
		  System.out.println("HashSet de t0 : " +t0.keySet());
		  System.out.println("Contient la valeur Fevrier dans t0 : " + t0.containsValue("Fevrier"));
		  System.out.println("t0 Vide ? : "+ t0.isEmpty());
		  System.out.println();
		  t0.clear();
		  System.out.println("Table t0 : " + t0);
		  System.out.println("HashSet de t0 : " +t0.keySet());
		 

		//Constructeur par défaut
		  System.out.println();
		  TableHash<Integer, String> t1 = new TableHash<Integer, String>();
		  System.out.println("Table t1 : " + t1);

		  t1.put(4,"Avril");
		  t1.put(5, "Mai");
		  t1.put(6,"Juin");
		  System.out.println("Table t1 : " + t1);
		  System.out.println("Valeur stocké dant t1 : "+t1.getCount());
		  System.out.println("HashSet de t1 : " +t1.keySet());
		  
		//Constructeur par copie
		  System.out.println();
		  TableHash<Integer, String> t2 = new TableHash<Integer, String>(t1);
		  System.out.println("Table t2 : " + t2);
		  System.out.println("Table t2 : " + t2);
		  System.out.println("Valeur stocké dant t2 : "+t2.getCount());
		  System.out.println("HashSet de t2 : " +t2.keySet());
		  
		  //Test de la méthode putAll
		  System.out.println();
		  t0.put(1,"Janvier");
		  t0.put(2, "Fevrier");
		  t0.put(3,"Mars");
		  System.out.println("Table t0 : " + t0);
		  System.out.println("Table t1 : " + t1);
		  t0.putAll(t1);
		  System.out.println("Nouvelle Table t0 fusionnée avec la table t1: " + t0);

		

	}
}//Classe HashTable
