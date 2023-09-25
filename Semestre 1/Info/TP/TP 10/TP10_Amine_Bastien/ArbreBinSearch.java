package fr.monprogramme.amine;

public class ArbreBinSearch<K extends Comparable <K>,V>{
	Noeud<K,V> racine;
	
	public ArbreBinSearch() {
		Noeud<K,V> n = new Noeud<K,V> (null,null,null,null,null);
		this.racine=null;
		
	}//ArbreBinSearch
	
	
	public void ajout(K key, V valeur) {//Ajoute un couple (clé-valeur)
		
		Noeud<K,V> noeud_courant;
		Noeud<K,V> noeud_pere=new Noeud<K,V>(null,null,null,null,null);
		Noeud<K,V> new_noeud;
		if(racine==null) {
			racine= new Noeud<K,V>(key,valeur,null,null,null);
			
		}else {
			noeud_courant=racine;
			while(noeud_courant!=null) {
				if(noeud_courant.getKey().compareTo(key)>0) {
					noeud_pere=noeud_courant;
					noeud_courant=noeud_courant.getFils_d();
				}else {
					noeud_pere=noeud_courant;
					noeud_courant=noeud_courant.getFils_g();
				}
			}
				new_noeud = new Noeud<K,V>(key,valeur,null,null,noeud_pere);
				if(noeud_pere.getKey().compareTo(new_noeud.getKey())>0) {
					noeud_pere.setFils_d(new_noeud);
				}
				else {
					noeud_pere.setFils_g(new_noeud);
				}
				
		}
		
		
	}
	
	public V get (K cle) {//Retourne la valeur qui contient la cle
		if(racine==null) {
            System.out.println("Arbre vide.");
            return racine.getValeur();
     }
	     return getFrom(racine,cle);
		
	}
	
	private V getFrom(Noeud<K,V>x, K cle) {//Parcours l'arbre, en partant du noeud x et retourne sa valeur.
		
        if(x==null) {
        	return null;
        }
    
        if (x.getKey().compareTo(cle)< 0) {
            return getFrom(x.getFils_g(),cle);
        }
   
        else if (x.getKey().compareTo(cle) > 0) {
            return getFrom(x.getFils_d(),cle);
        }
        
        else {
            return x.getValeur();
        }
	
	}//getFrom
  
	
	public String toString() {

		return racine.toString();
	}
	
	
	public String prefixe() {
        StringBuilder sb = new StringBuilder();
        toStringPrefixe(racine, sb);
        return sb.toString();
    }
    // méthode récursive pour parcourir l'arbre et construire la chaîne de caractères préfixée

	public void toStringPrefixe(Noeud<K,V> x, StringBuilder sb) {
	        if (x == null) {
	            return;
	        }

	        // ajoute la la clé et la valeur du noeud courant à la chaîne sb
	        sb.append("(").append(x.getKey()).append(", ").append(x.getValeur()).append(")");

	        // appelle récursivement la méthode sur les enfants
	        toStringPrefixe(x.getFils_g(), sb);
	        toStringPrefixe(x.getFils_d(), sb);
	   }
	

	
	
	public static void main ( String [] args ) {
		ArbreBinSearch<Integer , String> dico = new ArbreBinSearch<Integer , String >() ;
		ArbreBinSearch<Integer , String> dico2 = new ArbreBinSearch<Integer , String >() ;
		dico.ajout (10 , "def_10 " ) ;
		dico.ajout (2 , "def_02 " ) ;
		dico.ajout (2 , "def_02_bis " ) ;
		dico.ajout (30 , "def_30 " ) ;
		dico.ajout (04 , "def_04 " ) ;
		dico.ajout (50 , "def_50 " ) ;
		dico.ajout (06 , "def_06 " ) ;
		
		System.out.println ("Préfixe "+dico.prefixe () ) ;
		System.out.println ("Infixe "+dico ) ;
		System.out.println("Hauteur arbre "+dico.racine.getHauteur());
		System.out.println("Différence Hauteur sous arbre : "+dico.racine.getDifference());
		System.out.println("Valeur de la cle 2 : "+dico.get(2));
		System.out.println("Valeur de la cle 999 : "+dico.get(999));
		
		
		ArbreBinSearch<String ,String> dico_string = new ArbreBinSearch<String , String >();
		dico_string.ajout (" java " , " langage de programmation qu'on adore " ) ;
		dico_string.ajout ("mathematiques " , "matiere qu' on adore " ) ;
		dico_string.ajout (" anglais " , "matiere qu' on aime bien " ) ;
		dico_string.ajout (" algebre " , " branche des maths qu�on prefere " ) ;
		dico_string.ajout (" fac " , " la ou on etudie " ) ;
		dico_string.get (" anglais " ) ;
		System.out.println ("Infixe : "+ dico_string ) ;
		System.out.println ("Prefixe : "+ dico_string.prefixe () ) ;
		}
}
