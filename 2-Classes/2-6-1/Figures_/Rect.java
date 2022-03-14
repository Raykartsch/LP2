package Figures_;

import java.awt.*;

public class Rect extends Figure{

    int x, y;
    int w, h;
    
    public Rect(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void print(){
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
        this.w, this.h, this.x, this.y);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

    public void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(color);
        g.drawRect(this.x,this.y, this.w,this.h);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(this.x,this.y, this.w,this.h);
    }
}
