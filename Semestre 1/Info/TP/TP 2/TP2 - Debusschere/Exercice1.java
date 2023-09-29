package Semestre 1. Info.TP.TP 2. TP2-Debusschere;

public class Exercice1 {

    public static boolean estRange(int[] tabCar) {
        boolean range = true;
        for (int i = 0; i < tabCar.length - 1; i++) {
            System.out.println("i= " + i);
            range = range && (tabCar[i] <= tabCar[i + 1]);
        }
        return range;
    }

    public static int nbPositifs(int[] tab){
        int nb = 0;
        for(int i = 0; i < tab.length ; i++){
            if(tab[i] > 0){
                nb += 1;
                i += 1;
            }
        }
        return nb;
    }

    public static void main(String[] args) {

    }
}
