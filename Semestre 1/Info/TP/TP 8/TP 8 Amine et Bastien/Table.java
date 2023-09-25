package fr.amine.monrpogramme;

import java.util.*;

public interface Table<Clef, Element> {

  public void put(Clef key, Element element); 
  public Element get(Clef key);
  public Element remove(Clef key);
  
  public boolean containsKey(Clef key);
  public boolean containsValue(Element element);
  public int size();
  public boolean isEmpty();
  
  public void putAll(Table<Clef, Element> m);
  public void clear();
  public String toString();
  
  public Set<Clef> keySet();

} //Interface Table (calqu�e sur l'interface Map de Java)
