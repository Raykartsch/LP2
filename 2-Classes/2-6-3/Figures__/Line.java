package Figures__;

import java.awt.*;

public class Line extends Figure {
    
    int x1, y2, w1, h2;
    public Line (int x, int y, int w, int h) {
        super(x, y, w, h);
        x1 = x;
        y2 = y;
        w1 = w;
        h2 = h;
    };

   
    public void print(){
        System.out.format("Linha de tamanho: ");
    }

    public void changeThickness(Graphics g, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.drawLine(this.x1, this.y2, this.w1, this.h2);
        g2d.setStroke(new BasicStroke(1));
    }

    public void FillColor(Graphics g, Color color){
        g.setColor(color);
    }

    public void paint(Graphics g){
        g.drawLine(this.x1, this.y2, this.w1, this.h2);
    }
    
}
