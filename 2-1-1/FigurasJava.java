
class Pentagon {
    int posx, posy;
    int v1, v2, v3, v4, v5;
    Pentagon (int v1, int v2, int v3, int v4, int v5, int posx, int posy) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.v5 = v5;
        this.posx = posx;
        this.posy = posy;
  }

  void print () {
    System.out.format("\n\nPentagono nos vertices\nv1: %d\nv2: %d\nv3: %d\nv4: %d\nv5: %d\nPosicao (%d,%d).\n",
        this.v1, this.v2, this.v3, this.v4, this.v5, this.posx, this.posy);
    }
}

class Circle {
    int posx, posy, radius;
    double excentricity;

    Circle(int posx, int posy, int radius, double excentricity){
        this.posx = posx;
        this.posy = posy;
        this.radius = radius;
        this.excentricity = excentricity;
    }

    
    void print(){
        System.out.format("\n\nCirculo na posicao (%d, %d)\nRaio: %d\nExcentricidade:%.2f",
        this.posx, this.posy, this.radius, this.excentricity);
    }
}


public class FigurasJava {
    public static void main (String[] args) {
        Pentagon p1 = new Pentagon(10,10, 120, 90, 60, 30, 10);
        p1.print();

        Circle c1 = new Circle(15, 15, 30, 0.8);
        c1.print();
     }
}
