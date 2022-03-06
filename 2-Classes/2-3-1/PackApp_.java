import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Figures.*;

class PackApp_ {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Line l1;
    Line l2;
    Polygonal p1;

    int[] pX = {400, 350, 400, 500, 550, 500};
    int[] pY = {500, 550, 600, 600, 550, 500};

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(700, 700);
        this.r1 = new Rect(50,50, 100,30);
        this.e1 = new Ellipse(50,100, 100,30);
        this.l1 = new Line(50,150, 100, 30);
        this.l2 = new Line(200, 300, 500, 60);
        this.p1 = new Polygonal(pX, pY, 6);

        //this.p1 = new Polygon(pX, pY, 3);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.l1.DrawLine(g);
        this.l2.DrawLine(g);


        this.l2.changeThickness(g, 20);
        this.p1.DrawPolygonal(g);
        this.p1.FillPolygonal(g, Color.red);
    }
}