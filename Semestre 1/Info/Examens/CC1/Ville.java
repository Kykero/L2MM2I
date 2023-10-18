package test;

public class Ville {

	 private String nom;

	    public Ville(String nom) {
	        this.nom = nom;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    @Override
	    public String toString() {
	    	String ch;
	        ch= "Ville{" +
	               "nom='" + nom + '\'' +
	               '}';
	        return ch;
	    }

	    public static void main(String[] args) {
	        Ville rome = new Ville("Rome");
	        Ville athenes = new Ville("Athènes");

	        System.out.println(rome);
	        System.out.println(athenes);
	    }
	
}
