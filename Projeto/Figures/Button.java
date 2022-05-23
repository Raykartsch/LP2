package Figures;

import java.awt.*;

import ivisible.IVisible;


public class Button implements IVisible{
    public int x, y;
    public int w, h;
    public int idx;
    private Figure fig;

    public Button (int idx, Figure fig){
        this.fig.x = x;
        this.fig.y = y;
        this.fig.w = w;
        this.fig.h = h;
        this.idx = idx;
        this.fig = fig;
    }

    public boolean clicked (int x, int y){
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    };

    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        this.fig.paint(g);

    }
}
