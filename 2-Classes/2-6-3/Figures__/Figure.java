package Figures__;

import java.awt.*;

public abstract class Figure{
    int x, y;
    int w, h;
    int xV[], yV[];
    float rot;
    int r, g, b;

    public Figure (int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void paint (Graphics g);
    public abstract void FillColor(Graphics g, Color color);
}