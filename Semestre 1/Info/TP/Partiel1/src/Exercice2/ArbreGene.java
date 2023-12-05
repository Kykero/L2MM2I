package Exercice2; //On suppose qu'on possède Tortue;

import java.util.*;

public class ArbreGene<Element> implements Arbre<Element> {

	private Element element;
	private LinkedList<ArbreGene<Element>> fils;

	//Méthode 1 Récursivité :
    private int getHeightRecursive(Arbre<Element> arbre) {
        if (arbre == null || arbre.isEmpty()) {
            return 0;
        }

        int maxHeight = 0;
        for (int i = 0; i < arbre.getDegree(); i++) {
            int height = getHeightRecursive(arbre.getNode(i));
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight + 1; // Ajoute 1 pour prendre en compte le niveau actuel
    }

    //Méthode 2 : (Préféré la méthode récursive c'est moins long)
    public int getHeight() {
        if (isEmpty()) {
            return 0;
        }

        Queue<Arbre<Element>> queue = new LinkedList<>();
        queue.add(this); // Ajouter la racine à la file
        int height = 0;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();

            // Traiter tous les nœuds du niveau actuel
            while (nodesAtCurrentLevel > 0) {
                Arbre<Element> currentNode = queue.poll();

                // Ajouter les fils du nœud à la file
                for (int i = 0; i < currentNode.getDegree(); i++) {
                    Arbre<Element> childNode = currentNode.getNode(i);
                    if (childNode != null) {
                        queue.add(childNode);
                    }
                }

                nodesAtCurrentLevel--;
            }

            height++; // Passer au niveau suivant
        }

        return height;
    }
	
	
	
	
	public static void main(String[] args) {
		
        // Création d'objets Tortue
        Tortue tortuePere = new Tortue("Père");
        Tortue tortueFils1 = new Tortue("Fils 1");
        Tortue tortueFils2 = new Tortue("Fils 2");

        // Création des arbres correspondant à chaque Tortue
        ArbreGene<Tortue> arbreTortuePere = new ArbreGene<>();
        arbreTortuePere.setElement(tortuePere);

        ArbreGene<Tortue> arbreTortueFils1 = new ArbreGene<>();
        arbreTortueFils1.setElement(tortueFils1);

        ArbreGene<Tortue> arbreTortueFils2 = new ArbreGene<>();
        arbreTortueFils2.setElement(tortueFils2);

        // Construction de l'arbre principal
        ArbreGene<Tortue> arbrePrincipal = new ArbreGene<>();
        arbrePrincipal.setElement(tortuePere);

        // Ajout des fils à la racine
        arbrePrincipal.addNode(arbreTortueFils1);
        arbrePrincipal.addNode(arbreTortueFils2);

        // Affichage de l'arbre
        System.out.println(arbrePrincipal.toString());
    }//main
	
	
	
}//class