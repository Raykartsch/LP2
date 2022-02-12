// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;


// class Hello2DFrame extends JFrame
//     public Hello2DFrame(){
//         this.dispose();
//         this.setTitle("Hello World!");
//         this.setSize(350,350);
        
//     }

//     public void paint(Graphics g){
//         super.paint(g);
        
//         Graphics2D g2d = (Graphics2D) g;
//         g2d.setStroke(new BasicStroke(3));
//         g2d.setPaint(Color.blue);
//         int w = this.getWidth();
//         int h = this.getHeight();
//         g2d.drawLine(0, 2, w, h);
//         g2d.drawLine(0, h, w, 0);
//         g2d.drawLine(100, 150, 400, 700);
//         g2d.drawLine(100, 700, 400, 150);
//     }
  
// }

// public class java2dExample {
 
//     public static void main(String[] args) {
//         Hello2DFrame frame = new Hello2DFrame();
        
//         frame.setVisible(true);
//         frame.revalidate();
//         frame.repaint();
//         //SwingUtilities.updateComponentTreeUI(frame);
//     }
   
    
// }

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class java2dExample {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(false);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
        frame.repaint();
        
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        
        //int w = getWidth();
        //int h = getHeight();
        g2d.setStroke(new BasicStroke(3));
        g.drawRect(75, 75, 200, 250);
        g.setColor(Color.gray);
        g.fillRect(75, 75, 200, 250);

        g.setColor(Color.red);
        g.drawOval(30,30,40,40);
        g.fillOval(30,30,40,40);

        g.drawOval(280,280,40, 40);
        g.fillOval(280,280,40, 40);

        g.drawOval(280,30,40, 40);
        g.fillOval(280,30,40, 40);

        g.drawOval(30, 280,40, 40);
        g.fillOval(30, 280,40, 40);


        //g2d.drawLine(0, 2, w, h);
        g2d.setPaint(Color.red);
        g2d.drawLine(120, 120, 230, 230);
        g2d.drawLine(120, 230, 230, 120);
        //g2d.drawLine(0, h, w, 0);
        //barra
        g2d.drawLine(120, 220, 200, 300);
        //contrabarra
        g2d.drawLine(230, 230, 150, 300);
        //g2d.drawLine(125, 250, 350, 0);
        g2d.drawLine(180, 80, 230, 120);
        //
        g2d.drawLine(180, 80, 120, 120);
        g2d.drawLine(177, 300, 177, 80);
    }
}

