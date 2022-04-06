package Figures;

import java.awt.*;

public class Triangule extends Figures {

    public Triangule(int x[], int y[], int sizes){
        super(x, y, sizes);
    };
    
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.drawPolygon(x, y, sizes);
    }
}
