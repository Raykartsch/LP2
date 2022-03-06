package Figures;

import java.awt.*;

public class Line {
    int x1, x2;
    int y1, y2;

    public Line(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public void print(){
        System.out.format("Linha de tamanho: ");
    }

    public void changeThickness(Graphics g, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
        g2d.setStroke(new BasicStroke(1));
    }

    public void changeLineColor(Graphics g, Color color){
        g.setColor(color);
    }

    public void DrawLine(Graphics g){
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
    
}
