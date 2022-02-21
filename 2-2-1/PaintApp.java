import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {

    Rect r1, r2, r3;
    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30);
        this.r2 = new Rect(90,175, 20,50);
        this.r3 = new Rect(120,150, 50,60);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r1.changeLineColor(g, Color.red, 7);
        this.r1.FillColor(g, Color.blue);

        this.r2.paint(g);
        this.r2.changeLineColor(g, Color.yellow, 3);
        this.r2.FillColor(g, Color.green);

        this.r3.paint(g);
        this.r3.changeLineColor(g, Color.green, 4);
        this.r3.FillColor(g, Color.pink);
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

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }

    void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(color);
        g.drawRect(this.x,this.y, this.w,this.h);
    }

    void FillColor(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(this.x,this.y, this.w,this.h);
    }
}