package Figures_;

import java.awt.*;

public class Line extends Figure {
    int x, y;
    int w, h;

    public Line(int x1, int x2, int y1, int y2){
        this.x = x1;
        this.y = x2;
        this.w = y1;
        this.h = y2;

    }

    public void print(){
        System.out.format("Linha de tamanho: ");
    }

    public void changeThickness(Graphics g, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.drawLine(this.x, this.y, this.w, this.h);
        g2d.setStroke(new BasicStroke(1));
    }

    public void changeLineColor(Graphics g, Color color){
        g.setColor(color);
    }

    public void paint(Graphics g){
        g.drawLine(this.x, this.y, this.w, this.h);
    }
    
}
