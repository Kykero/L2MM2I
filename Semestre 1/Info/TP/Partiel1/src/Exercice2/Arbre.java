package Exercice2;

public interface Arbre<Element> {

	public Element getElement();
	public int getDegree();
	public Arbre<Element> getNode(int i);
	public boolean isEmpty();
	public boolean isLeaf();
	public void setElement(Element e);
	public void addNode(Arbre<Element> a);
	public void deleteNode(int i);
	public String toString();
	public boolean equals(Arbre<Element> a);
	public int getHeight();
	
}
