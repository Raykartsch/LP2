import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import Figures.Rect;
import Figures.Ellipse;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> ls = new ArrayList<Ellipse>();
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
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        rs.add(new Rect(x,y, w,h));
                        repaint();  // outer.repaint()
                    };

                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(600);
                        int y = rand.nextInt(600);
                        int w = rand.nextInt(100);
                        int h = rand.nextInt(100);
                        int r = rand.nextInt(255);
                        int g = rand.nextInt(255);
                        int b = rand.nextInt(255);
                        ls.add(new Ellipse(x, y, w, h));
                        colors.add(new Color(r, g, b));
                        repaint();
                    }
                }
            }
        );

        this.setTitle("Lista de Retangulos e Elipses");
        this.setSize(600, 600);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }

        for (Ellipse e: this.ls){
            int idx = this.ls.indexOf(e);
            //System.out.println(colors.get(idx));
            //e.fillColor(g, colors.get(idx));
            e.paint(g, colors.get(idx));
        }

    }
}