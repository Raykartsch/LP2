package Figures;

import java.awt.*;

public class Polygonal {
    int xValues[];
    int yValues[];
    int sizes;
    public Polygonal(int x[], int y[], int sizes){
        this.xValues = x;
        this.yValues = y;
        this.sizes = sizes;
    }
    
    public void DrawPolygonal(Graphics g){
        g.drawPolygon(xValues, yValues, sizes);
    }

    public void FillPolygonal(Graphics g, Color color){
        g.setColor(color);
        g.fillPolygon(xValues, yValues, sizes);
    }
}
