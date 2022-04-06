package Projeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.Timer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Figures.*;

public class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        Color g = new Color(98, 82, 82);
        frame.getContentPane().setBackground(g);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class ListFrame extends JFrame {

    public ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Color> colors = new ArrayList<Color>();
    Random rand = new Random();
    boolean canIncrease = false;

    int [] xValues = {50, 50, 50};
    int [] yValues = {50, 50, 50};
    boolean found = false;

    int location, clickX, clickY;
    Figure focus = null;
    Figure fig_copy = null;
    
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
                    Figure aditional;

                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(mouseX, mouseY, 60, 60));
                        focus = figs.get(figs.size()-1);
                        repaint(mouseX, mouseY, 60, 60);  
                    }

                    else if(evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(mouseX, mouseY, 60, 60));
                        focus = figs.get(figs.size()-1);
                        repaint(mouseX, mouseY, 60, 60);
                    }

                    else if((evt.getKeyChar() == 'd') && (focus != null)){
                        figs.remove(figs.get(figs.size()-1));
                        focus = null;
                        
                        repaint(mouseX, mouseY, 60, 60);
                    }

                    else if(evt.isAltDown()){
                        canIncrease = true;
                        System.out.println("Clicked!");
                    }

                    else if((evt.getKeyChar() == '+') && (focus != null)){
                        figs.get(figs.size()-1).w += 2;
                        figs.get(figs.size()-1).h += 2;

                        repaint();
                    }

                    else if((evt.getKeyChar() == '-') && (focus != null)){

                        figs.get(figs.size()-1).w -= 2;
                        figs.get(figs.size()-1).h -= 2;

                        repaint();
                    }
                    
                }

                public void keyReleased(KeyEvent evt){
                    if (evt.getKeyCode() == evt.VK_ALT){
                        canIncrease = false;
                    }
                    repaint();
                }
                

            }
        );
        
        this.addMouseListener(
            new MouseAdapter(){
                public void mouseClicked(MouseEvent evt){
                    found = false;
                    focus = null;
                    for (int i = figs.size() - 1; i >= 0; i--) {
                        Figure fig = figs.get(i);
                        if((evt.getX() >= fig.x && evt.getX() <= fig.x + fig.w) && (evt.getY() >= fig.y && evt.getY() <= fig.y + fig.h)){

                            Figure fig_replace = fig;
                            focus = fig;
                            location = i;
                            figs.remove(fig);
                            figs.add(fig_replace);
                            found = true;
                            break;
                            
                        }
                        else{
                            focus = null;
                        }
                    }
                    System.out.println(evt.getPoint());
                    repaint(60, 60, 60, 60);                
                }
                public void mousePressed(MouseEvent evt){
                    clickX = evt.getX();
                    clickY = evt.getY();
                }
            }
        );

        this.addMouseMotionListener(
            new MouseAdapter(){
                public void mouseDragged(MouseEvent evt){

                    int dx = evt.getX() - clickX;
                    int dy = evt.getY() - clickY;

                    Figure lastFig = figs.get(figs.size()-1);

                    if ((focus != null) && ((evt.getX() >= lastFig.x && evt.getX() <= lastFig.x + lastFig.w) && (evt.getY() >= lastFig.y && evt.getY() <= lastFig.y + lastFig.h))){

                        
                        if (canIncrease == false){
                            lastFig.x = lastFig.x + dx;
                            lastFig.y = lastFig.y + dy;
                        }
                        else if (canIncrease == true){
                            lastFig.w = lastFig.w + dx;
                            lastFig.h = lastFig.h + dy;
                        }
                        
                        
                        focus = lastFig;

                        repaint();



                        // figs.remove(figs.get(figs.size()-1));

                        // if(lastFig instanceof Rect){
                        //      figs.add(new Rect(lastFig.x, lastFig.y, lastFig.w, lastFig.h));
                        //     repaint();
                        // }

                        // if(lastFig instanceof Ellipse){
                        //     figs.add(new Ellipse(lastFig.x, lastFig.y, lastFig.w, lastFig.h));
                        //     repaint();
                        //     //System.out.println("Pertence!");
                        // }

                        //repaint();
                        
                       // System.out.format("\nFocus Coordenadas X: (%d), Y: (%d)\n", focus.x, focus.y);
                    
                    
                    }
                    clickX += dx;
                    clickY += dy;
                }
            }
        );
        this.setTitle("Editor Grafico Java");
        this.setSize(600, 600);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (int i = figs.size() - 1; i >= 0; i--) {
            figs.get(i).paint(g);
            figs.get(i).FillColor(g, Color.white);

        }
        if(focus != null){
            focus.changeLineColor(g, Color.red); 
        }

        focus = figs.get(figs.size()-1);
        g.dispose();
    }
}
