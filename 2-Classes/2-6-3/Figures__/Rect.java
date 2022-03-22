package Figures__;

import java.awt.*;

public class Rect extends Figure{

    int x1, y2, w1, h2;
    public Rect (int x, int y, int w, int h) {
        super(x, y, w, h);
        x1 = x;
        y2 = y;
        w1 = w;
        h2 = h;
    };
    

    public void print(){
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
        w1, h2, x1, y2);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x1, y2, w1, h2);
    }



    public void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(color);
        g.drawRect(this.x1,this.y2, this.w1,this.h2);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(this.x1,this.y2, this.w1,this.h2);
    }
}
