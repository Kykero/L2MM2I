package TP1;

public class Mediane {
    public static void main(String[] args) {
        int x, y, z;
        int m = 0;
        x = 4;
        y = 30;
        z = 2;
        System.out.println("Valeurs: x = " + x + "; y = " + y + "; z = " + z);

        if (x < y && y > z) {
            m = x;
        }
        if (y < x && y > z) {
            m = y;
        }
        if (z < x && z > y) {
            m = z;
        }
        System.out.println("Valeur médiane = " + m);
    }

}
