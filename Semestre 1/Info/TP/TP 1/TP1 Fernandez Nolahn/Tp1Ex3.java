package TP1;

public class Tp1Ex3 {
    static int code(int a, int b, int c) {
        int v = -1;
        if (a == b) {
            v = a;
        }
        if (a == c) {
            v = a;
        }
        if (b == c) {
            v = b;
        }
        if (a != b && b != c) {
            v = -1;
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(code(1, 2, 3));
        System.out.println(code(2, 2, 3));
    }

}
