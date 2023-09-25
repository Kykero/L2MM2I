package fr.amine.tp5;
import java.util.*;
public class Set {

	public static void main(String[] args) {
		HashSet<Integer>E1=new HashSet<Integer>();
		E1.add(1);
		E1.add(2);
		HashSet<Integer>E3=new HashSet<Integer>();
		E3.add(4);
		E3.add(5);
		System.out.println(E1);
		TreeSet<Integer>E2=new TreeSet<Integer>();
		/*E2.add(3);
		E2.add(2);
		E2.comparator();*/
		E2.subSet(E1, E3);
		System.out.print(E2);
		

	}

}
