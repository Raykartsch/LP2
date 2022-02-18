public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10); 
        r1.print();
        r1.drag(5, 3);
        r1.print();
        r1.drag(4, 7);
        r1.print();
        r1.drag(1, 2);
        r1.print();
        int ar = r1.area();
        System.out.format("Area: %d\n", ar);

        r1.drag(1, 2);
        r1.print();
        r1.extendSize(5, 7);
        r1.print();
        r1.drag(10, -7);
        r1.print();
        r1.drag(-7, 2);
        r1.print();

     }
     
} 

class Rect {
     int x, y;
     int w, h;
     Rect (int x, int y, int w, int h) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
     }

     int area(){
         return (this.h*this.w);
     }

     void drag(int dx, int dy){
         this.x += dx;
         this.y += dy;
     }

     void extendSize(int dw, int dh){
        this.w += dw;
        this.h += dh;
     }
     void print () {
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
       }
}
