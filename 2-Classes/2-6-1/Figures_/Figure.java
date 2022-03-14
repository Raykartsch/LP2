package Figures_;

import java.awt.*;

public abstract class Figure{
    int x[], y[];
    int w, h;
    float rot;
    int r, g, b;
    public abstract void paint (Graphics g);
}