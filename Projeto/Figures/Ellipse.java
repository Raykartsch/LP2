package Figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
    
    int x1, y2;
    int w1, h2;

    public Ellipse (int x, int y, int w, int h) {
        super(x, y, w, h);
        x1 = x;
        y2 = y;
        w1 = w;
        h2 = h;
    };

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w1, this.h2, this.x1, this.y2);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawOval(x1, y2, w1, h2);
    }

    public void changeLineColor(Graphics g, Color color){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(color);
        g.drawOval(x1, y2, w1, h2);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(this.x1,this.y2, this.w1,this.h2);
    }
}
