
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import Figures_.*;

public class OneList {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Color> colors = new ArrayList<Color>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(rand.nextInt(700),rand.nextInt(700), rand.nextInt(50),rand.nextInt(50)));
                        repaint();  // outer.repaint()
                    }
                    else if(evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(rand.nextInt(700),rand.nextInt(700), rand.nextInt(50),rand.nextInt(50)));
                        colors.add(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                        repaint();
                    }
                    else if(evt.getKeyChar() == 'l') {
                        figs.add(new Line(rand.nextInt(700),rand.nextInt(700), rand.nextInt(50),rand.nextInt(50)));
                        colors.add(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                        repaint();
                    }
                    else if(evt.getKeyChar() == 'p') {
                        int[] xV = {rand.nextInt(700), rand.nextInt(700), rand.nextInt(700), rand.nextInt(700), rand.nextInt(700)};
                        int[] yV = {rand.nextInt(700), rand.nextInt(700), rand.nextInt(700), rand.nextInt(700), rand.nextInt(700)};
                        figs.add(new Polygonal(xV, yV, 5));
                        repaint();
                    }
                }
            }
        );

        this.setTitle("Figures Java");
        this.setSize(600, 600);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }

        // for (Ellipse e: this.ls){
        //     int idx = this.ls.indexOf(e);
        //     //System.out.println(colors.get(idx));
        //     //e.fillColor(g, colors.get(idx));
        //     //
        //     e.paint(g, colors.get(idx));
        // }

    }
}
