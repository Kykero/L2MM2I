package TP1;

public class Tp1Ex1e {
    static boolean pair(int u) {
        return ((u % 2) == 0);
    }

    static int g(int u, int v) {
        int val = 0;
        if (u <= v && pair(u)) {
            val = 14;
        } else {
            val = 25;
        }
        return val;
    }

    public static void main(String[] args) {
        int x;
        float y;
        boolean c;
        x = (int) 5.0;
        y = (float) 7.5;
        c = pair(8);
        x = g(x, (int) 8.0);
        System.out.println("c = " + c);
        System.out.println("y = " + y);
        System.out.println("x = " + x);

    }

}
