import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class EllipseApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {

    Ellipse e1, e2, e3;
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
        this.e1 = new Ellipse(120,180, 150,70);
        this.e2 = new Ellipse(90,175, 10,10);
        this.e3 = new Ellipse(50,75, 70,30);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e1.LineColor(g, Color.blue, 7);
        this.e1.FillColor(g, Color.black);

        this.e2.paint(g);
        this.e2.LineColor(g, Color.yellow, 3);
        this.e2.FillColor(g, Color.magenta);

        this.e3.paint(g);
        this.e3.LineColor(g, Color.pink, 10);
        this.e3.FillColor(g, Color.red);
    }
}

class Ellipse {
    int x, y;
    int w, h;

    Ellipse (int x, int y, int w, int h) {
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
        //Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g.drawOval(this.x,this.y, this.w,this.h);
    }

    void LineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(color);
        g.drawOval(this.x,this.y, this.w,this.h);
    }

    void FillColor(Graphics g, Color color) {
        //Graphics2D g = (Graphics2D) g;
        g.setColor(color);
        g.fillOval(this.x,this.y, this.w,this.h);
    }
}
