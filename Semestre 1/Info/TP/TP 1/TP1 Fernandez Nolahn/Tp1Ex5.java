package TP1;

public class Tp1Ex5 {
    int[] tab;

    public Tp1Ex5(int x) {
        tab = new int[x];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = i;
        }
    }

    public void permutation(int i, int j) {
        int temp = 0;
        temp = tab[j];
        tab[j] = tab[i];
        tab[i] = temp;
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < tab.length; i++) {
            str += tab[i] + ";";
        }
        str += "]";
        return str;
    }

    public static void main(String[] args) {

        Tp1Ex5 t1 = new Tp1Ex5(7);
        System.out.println(t1);
        t1.permutation(2, 4);
        System.out.println(t1);

    }

}
