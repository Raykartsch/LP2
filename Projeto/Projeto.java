package Projeto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import Figures.*;
import Figures.Rect;

public class Projeto {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        Color g = new Color(210, 210, 210);
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
    
    
    int [] xValues = {10, 20, 30};
    int [] yValues = {100, 20, 100};
    boolean found = false;
    int d;
    int location, clickX, clickY;
    Figure focus = null;
    Figure fig_copy = null;
    
    
    Figure Colorfill = new Ellipse(550, 550, 20, 20, xValues, yValues, Color.WHITE, Color.BLACK);
    Figure Linefill = new Ellipse(550, 500, 20, 20, xValues, yValues, Color.WHITE, Color.BLACK);

    
    Color newFillColor = new Color(255, 255, 255);
    Color newLineColor = new Color(255, 255, 255);

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
                
                    //Criar retangulo
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(mouseX, mouseY, 60, 60, xValues, yValues, new Color(255, 255, 255), new Color(0, 0, 0)));
                        focus = figs.get(figs.size()-1);
                        repaint(mouseX, mouseY, 60, 60);  
                    }

                    //Criar elipse
                    else if(evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(mouseX, mouseY, 60, 60, xValues, yValues, new Color(255, 255, 255), new Color(0, 0, 0)));
                        focus = figs.get(figs.size()-1);
                        repaint(mouseX, mouseY, 60, 60);
                    }

                    //Criar triangulo
                    else if(evt.getKeyChar() == 't') {
                        int [] xValues = {mouseX, mouseX + 15, mouseX + 30};
                        int [] yValues = {mouseY, mouseY - 30, mouseY};
                        figs.add(new Triangule(mouseX, mouseY - 30, 30, 30, xValues, yValues, new Color(255, 255, 255), new Color(0, 0, 0)));

                        focus = figs.get(figs.size()-1);
                        //System.out.format("X: (%d), Y: (%d) W: (%d) H: (%d)", focus.x, focus.y, focus.w, focus.h);
                        repaint(mouseX, mouseY, 60, 60);
                    }

                    //Cria cor randômica para o fundo da figura
                    else if(evt.getKeyChar() == 'f'){
                        newFillColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                        Colorfill.cor = newFillColor;
                        //System.out.format("(%d) ", newFillColor);
                        repaint();
                    }

                    //Cria cor randômica para o contorno da figura
                    else if(evt.getKeyChar() == 'g'){
                        newLineColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
                        Linefill.cor = newLineColor;
                        System.out.format("(%d) ", newLineColor);
                        repaint();
                    }

                    //Deletar figura
                    else if((evt.getKeyChar() == 'd') && (focus != null)){
                        figs.remove(figs.get(figs.size()-1));
                        focus = null;
                        repaint(mouseX, mouseY, 60, 60);
                    }

                    //Permite aumentar o tamanho
                    else if(evt.isAltDown()){
                        canIncrease = true;
                    }

                    else if ((evt.getKeyCode() == evt.VK_UP) & (focus != null) & ((figs.get(figs.size()-1)) != null)){
                        figs.get(figs.size()-1).y -= 5;
                        repaint();
                    }

                    else if ((evt.getKeyCode() == evt.VK_DOWN) & (focus != null) & ((figs.get(figs.size()-1)) != null)){
                        figs.get(figs.size()-1).y += 5;
                        repaint();
                    }

                    else if ((evt.getKeyCode() == evt.VK_RIGHT) & (focus != null) & ((figs.get(figs.size()-1)) != null)){
                        figs.get(figs.size()-1).x += 5;
                        repaint();
                    }
                    else if ((evt.getKeyCode() == evt.VK_LEFT) & (focus != null) & ((figs.get(figs.size()-1)) != null)){
                        figs.get(figs.size()-1).x -= 5;
                        repaint();
                    }
                    else if((evt.getKeyChar() == '+') && (focus != null)){
                        figs.get(figs.size()-1).w += 5;
                        figs.get(figs.size()-1).h += 5;
                        
                        repaint();
                    }

                    else if((evt.getKeyChar() == '-') && (focus != null)){

                        figs.get(figs.size()-1).w -= 5;
                        figs.get(figs.size()-1).h -= 5;
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
                    int x = evt.getX();
                    int y = evt.getY();
                    if (evt.getButton() == evt.BUTTON1){
                        found = false;
                        focus = null;
                        for (int i = figs.size() - 1; i >= 0; i--) {
                            Figure fig = figs.get(i);
                            if(fig.clicked(x, y)){
                                Figure fig_replace = fig;
                                focus = fig_replace;
                                figs.remove(fig);
                                figs.add(fig_replace);
                                found = true;
                                System.out.println("Dentro!");
                                break;   
                            }
                            else{
                                focus = null;
                                repaint();
                            }
                        }
                        System.out.println(evt.getPoint());
                        repaint();
                    }

                    else if (evt.getButton() == evt.BUTTON2) {
                        if (focus != null){
                            figs.get(figs.size()-1).lineColor = newLineColor;
                            repaint();
                        }
                        
                    }
                    else if (evt.getButton() == evt.BUTTON3) {
                        if (focus != null){
                            figs.get(figs.size()-1).cor = newFillColor;
                            repaint();
                        }                       
                    }
                                    
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

                    if ((focus != null) && lastFig.clicked((int)evt.getX(), (int)evt.getY())){
                        focus = figs.get(figs.size()-1);
                        if (canIncrease == false){
                            lastFig.x = lastFig.x + (int)(dx);
                            lastFig.y = lastFig.y + (int)(dy);

                            lastFig.xV[0] = lastFig.xV[0] + (int)(dx);
                            lastFig.xV[1] = lastFig.xV[1] + (int)(dx);
                            lastFig.xV[2] = lastFig.xV[2] + (int)(dx);

                            lastFig.yV[0] = lastFig.yV[0] + (int)(dy);
                            lastFig.yV[1] = lastFig.yV[1] + (int)(dy);
                            lastFig.yV[2] = lastFig.yV[2] + (int)(dy);
                        }
                        else if (canIncrease == true){
                            if((clickX >= lastFig.x) && (clickY >= lastFig.y)){

                                lastFig.w = lastFig.w + dx;
                                lastFig.h = lastFig.h + dy;

                            }
                            else if((clickX <= lastFig.x) & (clickY >= lastFig.y)){
                                d = dx*(-1);
                                if(d > 0){
                                    lastFig.x = lastFig.x - d;
                                    lastFig.w = lastFig.w + d;
                                    lastFig.h = lastFig.h + dy;
                                }
                                else{
                                    lastFig.w = lastFig.w + dx;
                                    lastFig.h = lastFig.h + dy;
                                }                                
                            }

                            else if((clickX >= lastFig.x) & (clickY <= lastFig.y)){
                                d = dy*(-1);
                                if(d > 0){
                                    lastFig.y = lastFig.y - d;
                                    lastFig.w = lastFig.w + dx;
                                    lastFig.h = lastFig.h + d;
                                }
                                else{
                                    lastFig.w = lastFig.w + dx;
                                    lastFig.h = lastFig.h + dy;
                                }
                                
                            }
                            System.out.format("Figure X:(%d), Y:(%d) W:(%d)  H: (%d)", lastFig.x, lastFig.y, lastFig.w, lastFig.h);
                            System.out.format("X: (%d)  Y:(%d) ", clickX, clickY);
                            System.out.println(clickY);
                        }                
                        focus = lastFig;
                        repaint();
                    }
                    clickX += dx;
                    clickY += dy;
                }
            }
        );
        this.setTitle("Editor Grafico Java");
        this.setSize(800, 800);
    }

    public void paint (Graphics g) {
        super.paint(g);
        if(figs.size() > 0){
            for (int i = 0; i <= figs.size()-1; i++) {
                figs.get(i).FillColor(g, figs.get(i).cor);
                figs.get(i).changeLineColor(g, figs.get(i).lineColor, 3);
                figs.get(i).paint(g);
            }

            //Indicador de cor de fundo
            Colorfill.paint(g);
            Colorfill.FillColor(g, Colorfill.cor);
            Colorfill.changeLineColor(g, Color.BLACK, 2);
    
            //Indicador de cor de linha
            Linefill.paint(g);
            Linefill.FillColor(g, Linefill.cor);
            Linefill.changeLineColor(g, Color.BLACK, 2);
    

            if(focus != null){
                focus.changeLineColor(g, Color.red, 8); 
            }
        }
    }
}
