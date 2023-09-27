package TP1;

public class Tp1Ex1c {
    public static void main(String[] args) {
        int x;
        long y;
        boolean c, b;
        c = true;
        x = 987654321;
        System.out.println("La valeur de x est: " + x);
        y = (long) 3 * x;
        b = x == y;
        b = b && c;
        System.out.println("La valeur de y est: " + y);
        System.out.println("La valeur de b est: " + b);

    }

}