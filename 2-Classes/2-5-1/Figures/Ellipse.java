package Figures;

import java.awt.*;

public class Ellipse {
    int x, y;
    int w, h;

    public Ellipse (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, Color color) {
        //Graphics2D g2d = (Graphics2D) g;
        g.setColor(color);
        g.fillOval(this.x,this.y, this.w, this.h);
        g.setColor(Color.black);
        g.drawOval(this.x,this.y, this.w, this.h);
    }

    public void LineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(color);
        g.drawOval(this.x,this.y, this.w,this.h);
    }

    public void FillColor(Graphics g, Color color) {
        //Graphics2D g = (Graphics2D) g;
        g.setColor(color);
        g.fillOval(this.x,this.y, this.w,this.h);
    }
}
