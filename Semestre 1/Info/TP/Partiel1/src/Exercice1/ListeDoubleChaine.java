package Exercice1;

public class ListeDoubleChaine implements Liste {

	private class Chainon {
		public int val;
		public Chainon pred;
		public Chainon suiv;
	}

	private Chainon tete;
	private Chainon queue;
	private Chainon ec;

	// Méthode 1 : (a vérifier)
	public void ajoutg(int x) {
		if (listeVide()) {
			Chainon maillon = new Chainon();
			maillon.val = x;
			maillon.suiv = null;
			ec = maillon;
			tete = maillon;
			queue = maillon;
		} else {
			if (!horsListe()) {
				Chainon tmp = new Chainon();
				tmp.val = x;
				if (ec == tete) {
					tmp.suiv = ec;
					tete = tmp;
				} else {
					tmp.suiv = ec;
					Chainon tmp2 = ec;
					entete();
					while (ec.suiv != tmp) {
						ec = ec.suiv;
					}
					ec.suiv = tmp2;

				}
			}
		}
	}

	// Méthode 2 : (a vérifier)

	public void ajoutg2(int x) {
	    if (listeVide()) {
	        Chainon maillon = new Chainon();
	        maillon.val = x;
	        maillon.suiv = null;
	        ec = maillon;
	        tete = maillon;
	        queue = maillon;
	    } else {
	        Chainon nouvelElement = new Chainon();
	        nouvelElement.val = x;

	        if (ec == tete) {
	            nouvelElement.suiv = ec;
	            ec.pred = nouvelElement;
	            tete = nouvelElement;
	        } else {
	            nouvelElement.suiv = ec;
	            nouvelElement.pred = ec.pred;
	            ec.pred.suiv = nouvelElement;
	            ec.pred = nouvelElement;
	        }
	    }
	}


}
