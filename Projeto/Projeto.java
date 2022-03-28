package Projeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.Timer;
//import org.w3c.dom.events.MouseEvent;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Figures.*;

public class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {

    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Color> colors = new ArrayList<Color>();
    Random rand = new Random();
    boolean found = false;
    
    //Color Red = new Color(255, 0, 0);

    Figure focus = null;
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
                    int mouseX = (int)MouseInfo.getPointerInfo().getLocation().getX();
                    int mouseY = (int)MouseInfo.getPointerInfo().getLocation().getY();
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(mouseX, mouseY, 20, 20));
                        System.out.format("X: (%d) | Y: (%d)\n", mouseX,mouseY);
                        repaint();  
                    }
                    else if(evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(mouseX, mouseY, 20, 20));
                        repaint();
                    }
                }
            }
        );
        
        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    found = false;
                    focus = null;
                    //for (Figure fig: figs){
                    for (int i = figs.size() - 1; i >= 0; i--) {
                        Figure fig = figs.get(i);
                        if((evt.getX() >= fig.x && evt.getX() <= fig.x + fig.w) && (evt.getY() >= fig.y && evt.getY() <= fig.y + fig.h)){
                            Figure fig_replace = fig;
                            focus = fig;
                            figs.remove(fig);
                            figs.add(fig_replace);
                            found = true;
                            System.out.println("Dentro!");
                            System.out.format("X: (%d), Y: (%d) | w: (%d), h: (%d)", fig.x, fig.y, fig.w, fig.h);
                            break;
                            
                        }
                    }
                    System.out.println(evt.getPoint());
                    repaint();
                   
                }
            }

        );

        this.addMouseMotionListener(
            new MouseAdapter(){
                public void mouseDragged(MouseEvent evt){
                    
                    int dx = evt.getX();
                    int dy = evt.getY();
                }
            }
        );
        this.setTitle("Editor Grafico Java");
        this.setSize(400,400);
    }

    public void paint (Graphics g) {
        super.paint(g);
        //for (Figure fig: this.figs)
        // if(found == true){
        //     figs.get(figs.size()-1).changeLineColor(g, Color.red);
        // }
        for (int i = figs.size() - 1; i >= 0; i--) {
            figs.get(i).paint(g);
        }

        focus.changeLineColor(g, Color.red);
        found = false;
    }
}
