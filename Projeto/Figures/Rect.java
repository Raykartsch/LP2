package Figures;

import java.awt.*;
import java.awt.MouseInfo;


public class Rect extends Figure{

    int x1, y2; 
    int w1, h2;
    public Rect (int x, int y, int w, int h, int xV[], int yV[], Color cor, Color lineColor) {
        super(x, y, w, h, xV, yV, cor, lineColor);
    };
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x, y, w, h);
    }

    private void print(){
        System.out.format("Retangulo de tamanho (%d, %d) na posicao (%d, %d).\n",
        w, h, x, y);
    }
    
    public void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(lineColor);
        g.drawRect(x, y, w, h);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(cor);
        g.fillRect(x, y, w, h);
    }
}
