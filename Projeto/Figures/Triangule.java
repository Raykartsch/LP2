package Figures;

import java.awt.*;

public class Triangule extends Figure {

    public Triangule(int x, int y, int w, int h, int xV[], int yV[], Color cor, Color lineColor){
        super(x, y, w, h, xV, yV, cor, lineColor);
    };
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(xV, yV, 3);
    }

    public void changeLineColor(Graphics g, Color color, int size){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(size));
        g.setColor(lineColor);
        g.drawPolygon(xV, yV, 3);
    }

    public void FillColor(Graphics g, Color color) {
        g.setColor(cor);
        g.fillPolygon(xV, yV, 3);
    }
}
