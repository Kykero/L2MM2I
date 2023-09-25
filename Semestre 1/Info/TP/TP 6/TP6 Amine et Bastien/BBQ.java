package fr.amine.tp6;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class BBQ {

	public static void main(String[] args)throws InterruptedException {//InterruptedException permet d'utiliser la methode put()
		int capacity=5;
		
		PriorityQueue<String>bbqLine =new PriorityQueue<String>(capacity); //On créer une variable de type Queue dont on utilise l'implémentation LinkedList
		BlockingQueue<Integer>queue=new ArrayBlockingQueue<Integer>(10);
		bbqLine.add("Amine");
		bbqLine.add("Bastien");
		bbqLine.add("Hugo");
		bbqLine.add("Lucas");
		
		System.out.println("Dans la file d'attente pour le BBQ il y a : \n"+bbqLine);
		System.out.println("Le prochain à partir est :"+bbqLine.peek());
		bbqLine.poll();//Retire l'element qui est en tete
		System.out.println("Dans la file d'attente pour le BBQ il y a : \n"+bbqLine);
		System.out.println("La personne qui est en tete est : "+bbqLine.element()); 
		//Les méthodes element() et peek() retournent l'element qui est à la tete de la file, 
		//la seul différence est que elemen() retourne une erreur si la file est vide, 
		//tandis que peek() retourne null
		bbqLine.poll();
		bbqLine.poll();
		bbqLine.poll();
		//System.out.println("La personne qui est en tete est : "+bbqLine.element());  
		System.out.println("Le prochain à partir est :"+bbqLine.peek());
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.offer(5); //offer() ajoute un element à la queue de la file,
						//si il y a de l'espace
		queue.put(6);//put() ajoute un element à la queue de la file,
					//mais il atted d'abord qu'il y ait de l'espace
		System.out.println("Elements :");
		for(int i: queue) {
			System.out.println(i);
		}
		
	}

}
