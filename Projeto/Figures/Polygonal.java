package Figures;

import java.awt.*;

public class Polygonal extends Figure{
    int xValues[];
    int yValues[];
    int sizes;
    public Polygonal(int x[], int y[], int sizes){
        super(x, y);
        this.xValues = x;
        this.yValues = y;
        this.sizes = sizes;
    }
    

    public void paint(Graphics g){
        g.drawPolygon(this.xValues, this.yValues, this.sizes);
    }

    public void changeLineColor(Graphics g, Color color){
        g.drawPolygon(this.xValues, this.yValues, this.sizes);
    }


    public void FillColor(Graphics g, Color color){
        g.setColor(color);
        g.fillPolygon(xValues, yValues, sizes);
    }
}
