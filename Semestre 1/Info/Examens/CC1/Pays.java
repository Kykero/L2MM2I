package test;



public class Pays {
	private String nom;
    private Ville capitale;

    public Pays(String nom, Ville capitale) {
        this.nom = nom;
        this.capitale = capitale;
    }

    public String getNom() {
        return nom;
    }

    public Ville getCapitale() {
        return capitale;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapitale(Ville capitale) {
        this.capitale = capitale;
    }

    @Override
    public String toString() {
    	String ch ; 
        ch= "Pays{" +
               "nom='" + nom + '\'' +
               ", capitale=" + capitale +
               '}';
        return ch; 
    }

    public static void main(String[] args) {
        Ville paris = new Ville("Paris");
        Pays france = new Pays("France", paris);

        Ville berlin = new Ville("Berlin");
        Pays allemagne = new Pays("Allemagne", berlin);
        
        france.setNom("France");
        france.getCapitale().setNom("Paris");
        

        System.out.println(france);
        System.out.println(allemagne);
        
        System.out.println(france.getNom());  // Affiche le nom du pays
        System.out.println(france.getCapitale().getNom());
    }
}
