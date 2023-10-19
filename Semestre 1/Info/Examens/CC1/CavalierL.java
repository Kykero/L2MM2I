package test;

public class Cavalier implements CavalierL {
    private int _x, _y;   // Position courante
    private int dir;       // Direction courante (nord(0), ouest(1), sud(2), est(3))

    // Constructeur par défaut
    public Cavalier() {
        _x = 0;
        _y = 0;
        dir = 0; // Par défaut, la direction est nord (0)
    }

    // Constructeur par paramètre
    public Cavalier(int x, int y, int direction) {
        _x = x;
        _y = y;
        
        // Assurez-vous que la direction est valide (0, 1, 2, ou 3)
        if (direction >= 0 && direction <= 3) {
            dir = direction;
        } else {
            System.out.println("direction non valide");
            		System.exit(-1);
        }
    }

   
    
    private void deplace(int d) {
        switch (d) {
            case 0: // nord
                _y -= 1;
                _y -= 1;
                _y -= 1;
                _x -= 1;
                break;
            case 1: // ouest
                _x -= 1;
                _x -= 1;
                _x -= 1;
                _y += 1;
                break;
            case 2: // sud
            	_y += 1;
                _y += 1;
                _y += 1;
                _x += 1;
                break;
            case 3: // est
                _x += 1;
                _x += 1;
                _x += 1;
                _y -= 1;
                break;
            default:
            	System.out.println("direction non valide");
        		System.exit(-1);
        }
    }

    // Méthode pour effectuer un mouvement en fonction de la direction courante
    public void mouvement() {
        deplace(dir);
    }

    // Méthode pour tourner à gauche (G) ou à droite (D)
    public void tourne(char c) {
        if (c == 'G') {
            dir = (dir + 1) % 4; // Tourne à gauche
        } else if (c == 'D') {
            dir = (dir + 3) % 4; // Tourne à droite (équivalent à trois rotations à gauche)
        } else {
        	System.out.println("caractere non valide");
    		System.exit(-1);
        }
    }
        
        public String toString() {
            return "Cavalier [Position : (" + _x + ", " + _y + "), Direction : " + dir + "]";
        }
        
        public static void main(String[] args) {
           
            Cavalier cav1 = new Cavalier();


           
            Cavalier cav2 = new Cavalier(2, 2, 2);

           
            System.out.println("cav 1 : "+cav1);
            System.out.println("cav 2 : "+cav2);

           
            cav1.mouvement();
            System.out.println("cav 1 : "+cav1);
            cav1.tourne('D');
            cav1.mouvement();

           
            cav2.mouvement();
            System.out.println("cav 2 : "+cav2);
            cav2.tourne('G');
            cav2.mouvement();

            
            System.out.println("cav 1 : "+cav1);
            System.out.println("cav 2 : "+cav2);
        }
        
        
      
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

