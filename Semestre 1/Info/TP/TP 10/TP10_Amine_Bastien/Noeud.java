package fr.monprogramme.amine;

public class Noeud<K,V> {
	private K key;
	private V valeur;
	private Noeud<K,V> fils_g;
	private Noeud<K,V> fils_d;
	private Noeud<K,V> pere;
	private int hauteur;

	public Noeud(K cle,V element,Noeud<K,V>gauche,Noeud<K,V>droite,Noeud<K,V>pere) {
		this.key=cle;
		this.valeur=element;
		this.fils_d=droite;
		this.fils_g=gauche;
		this.pere=pere;
		this.hauteur=1;
		majHauteur();
	}
	
	private void equilibreFrom(Noeud<K,V> X) {
		int diffNoeud= X.getDifference();
		int diffDroite= X.getFils_d().getDifference();
		int diffGauche = X.getFils_g().getDifference();
		System.out.println("X = "+diffNoeud+" XD : "+diffDroite+" XG : "+diffGauche);
		
	}
	
	public String toString() {
		String ch="";
		if(fils_g!=null) {
			ch+=fils_g.toString();
		}
		ch+= "("+key+","+valeur;
		if(fils_d!=null) {
			ch+=fils_d.toString();
		}
		return ch+=")";
	}
	

	
	
	
	private void majHauteur() {//Met à jour la hauteur du noeud en fonction de la hauteur de ses enfants
        
        this.hauteur = 1 + Math.max(hauteur(this.fils_g), hauteur(this.fils_d));

        // Appelle récursivement la méthode sur le noeud parent
        if (this.pere != null) {
            this.pere.majHauteur();
        }
    }

    
    private int hauteur(Noeud<K,V> x) {//Méthode pour calculer la hauteur d'un noeud
        // Si le noeud est null, sa hauteur est 0
        if (x == null) {
            return 0;
        }
        return x.hauteur;
    }
    public int getDifference() {//Retourne la différence de hauteur entre les sous arbres gauche et droite du noeud courant.
    	int diff;
    	if(fils_g==null) {
    		fils_g.setHauteur(0);
    	}
    	if(fils_d==null) {
    		fils_d.setHauteur(0);
    	}
    	
    	diff=fils_d.hauteur-fils_g.hauteur;
    	return diff;
    }
   

    
    //Setter et Getter
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValeur() {
		return valeur;
	}

	public void setValeur(V valeur) {
		this.valeur = valeur;
	}

	public Noeud<K,V> getFils_g() {
		return fils_g;
	}

	public void setFils_g(Noeud<K,V> fils_g) {
		this.fils_g = fils_g;
		majHauteur();
	}

	public Noeud<K,V> getFils_d() {
		return fils_d;
	}

	public void setFils_d(Noeud<K,V> fils_d) {
		this.fils_d = fils_d;
		majHauteur();
	}

	public Noeud<K,V> getPere() {
		return pere;
	}

	public void setPere(Noeud<K,V> pere) {
		this.pere = pere;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int h) {
		this.hauteur=h;
	}

	

}
