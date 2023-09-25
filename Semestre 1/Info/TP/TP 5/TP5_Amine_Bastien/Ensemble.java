package fr.amine.tp5;

/**
 * Interface Ensemble.
 *
 * Cette classe permet de manipuler un ensemble d'entiers.
 * Plusieurs proc�dures permettent de rajouter, d'enlever, d'obtenir un
 * �l�ment ou bien de retourner le nombre d'�l�ments d'un ensemble.
 *
 * @author Marc Chaumont
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Ensemble { 

	/**
 	 * Retourne l'�l�ment pr�sent � l'indice 'indice'.
 	 *
 	 * @param int indice : l'indice de l'el�ment retourn�.
 	 * @return int : �lement retourn�.
 	 */ 
	public int getElement(int indice);
	
		
	/**
 	 * Retourne vrai si l'ensemble est vide et faux sinon.
 	 *
 	 * @param aucun.
 	 * @return boolean.
 	 */ 
	public boolean estVide();

	/**
 	 * Retourne vrai si l'ensemble est plein et faux sinon.
 	 *
 	 * @param aucun.
 	 * @return boolean.
 	 */ 
	public boolean estPlein();
	/**
 	 * Retourne le nombre d'�l�ments de l'ensemble.
 	 *
 	 * @param aucun.
 	 * @return int.
 	 */	 
	public int nbElement();


	/**
 	 * Retourne un �lement de l'ensemble.
 	 *
 	 * @param aucun.
 	 * @return int.
 	 */ 
	public int element(); 

	/**
 	 * La m�thode appartient retourne vrai si l'entier pass� en param�tre est 
 	 * dans l'ensemble et faux sinon.
 	 *
 	 * @param int element : entier dont on souhaite savoir s'il appartient � 
 	 * l'ensemble.
 	 * @return boolean.
 	 */ 
	public boolean appartient (int element);
	
	/**
 	 * La m�thode getIndice est une m�thode qui devrait �tre priv�e 
 	 * (elle ne doit pas �tre utilis�e depuis l'ext�rieur), elle retourne 
 	 * l'indice d'un �lement s'il est pr�sent dans le tableau T et -1 sinon.
 	 *
 	 * @param int element : entier dont on souhaite conna�tre l'indice.
 	 * @return int : indice de l'entier.
 	 */ 
     public int getIndice(int element);
	 

	/**
 	 * La m�thode ajoutelt permet d'ajouter un �l�ment dans l'ensemble. 
 	 *
 	 * @param int element : entier � ajouter.
 	 * @return aucun.
 	 */ 
	public void ajoutElt(int element);

	/**
 	 * M�thode permettant d'�ter un �l�ment pr�sent dans un ensemble.
 	 *
 	 * @param int.
 	 * @return aucun.
 	 */ 
	public void oterElt(int element);

	
	/**
 	 * M�thode retournant une cha�ne de caract�re caract�risant l'ensemble.
 	 *
 	 * @return String : cha�ne de caract�re retourn�e.
 	 */ 	
	public String toString();
	
	/**
 	 * M�thode retournant l'union de l'ensemble courant et l'ensemble pass� en 
 	 * param�tre. Exemple d'utilisation : <br>
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * Ensemble e3 = e1.union(e2); 
 	 *
 	 * @param Ensemble e : l'ensemble avec lequel est effectu�e l'union.
 	 * @return Ensemble : le r�sultat de l'union.
 	 */ 	
	public Ensemble union(Ensemble1 e);
	
	/**
 	 * M�thode retournant l'intersection de l'ensemble courant et l'ensemble 
 	 * pass� en param�tre. Exemple d'utilisation : <br>
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * Ensemble e3 = e1.intersection(e2); 
 	 *
 	 * @param Ensemble e : l'ensemble avec lequel est effectu�e l'intersection.
 	 * @return Ensemble : le r�sultat de l'intersection.
 	 */ 	
	public Ensemble intersection(Ensemble1 e);
	
	/**
 	 * M�thode retournant l'ensemble issu de la soustraction d'un ensemble � 
 	 * un autre. Exemple d'utilisation :<br> 
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * Ensemble e3 = e1.diff(e2); // e3 = e1 - e2
 	 *
 	 * @param Ensemble e : l'ensemble � soustraire.
 	 * @return Ensemble : le r�sultat de la diff�rence.
 	 */ 	
	public Ensemble diff(Ensemble1 e);

    /**
 	 * M�thode retournant vrai si l'ensemble courant et l'ensemble pass� en param�tre sont �gaux. Exemple d'utilisation : <br>
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * boolean   b = e1.egal(e2);
 	 *
 	 * @param Ensemble e : l'ensemble avec lequel on teste l'�galit�.
 	 * @return boolean : vrai si les deux ensembles sont �gaux.
 	 */ 	
	public boolean egal(Ensemble1 e);

    /**
 	 * M�thode retournant vrai si l'ensemble courant et l'ensemble pass� en param�tre ont une intersection vide. Exemple d'utilisation :<br> 
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * boolean   b = e1.disjoints(e2);
 	 *
 	 * @param Ensemble e : l'ensemble avec lequel on teste l'intersection.
 	 * @return boolean : vrai si les deux ensembles sont disjoints.
 	 */ 	
	public boolean disjoints(Ensemble1 e);

    /**
 	 * M�thode retournant vrai si l'ensemble courant est inclus ou �gal � l'ensemble pass� en param�tre. Exemple d'utilisation :<br> 
 	 * Ensemble e1 = new Ensemble();<br>
 	 * Ensemble e2 = new Ensemble();<br>
 	 * boolean   b = e1.inclus(e2);
 	 *
 	 * @param Ensemble e : l'ensemble avec lequel on teste l'intersection.
 	 * @return boolean : vrai si l'ensemble courant est inclus dans l'ensemble pass� en param�tre.
 	 */ 	
	public boolean inclus(Ensemble1 e);

} //Fin de l'interface Ensemble




