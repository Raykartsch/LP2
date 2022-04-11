package Figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
    
    int x1, y2;
    int w1, h2;

    public Ellipse (int x, int y, int w, int h, int xV[], int yV[], Color cor, Color lineColor) {
        super(x, y, w, h, xV, yV, cor, lineColor);
    };

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            w, h, x, y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawOval(x, y, w, h);
    }

    public void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(lineColor);
        g.drawOval(x, y, w, h);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(cor);
        g.fillOval(x, y, w, h);
    }
}
