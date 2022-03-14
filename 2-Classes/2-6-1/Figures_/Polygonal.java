package Figures_;

import java.awt.*;



public class Polygonal extends Figure{
    int xValues[];
    int yValues[];
    int sizes;
    public Polygonal(int x[], int y[], int sizes){
        this.xValues = x;
        this.yValues = y;
        this.sizes = sizes;
    }
    
    public void paint(Graphics g){
        g.drawPolygon(this.xValues, this.yValues, this.sizes);
    }

    public void FillPolygonal(Graphics g, Color color){
        g.setColor(color);
        g.fillPolygon(xValues, yValues, sizes);
    }
}
