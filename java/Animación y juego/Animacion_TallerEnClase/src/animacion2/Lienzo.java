/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacion2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Lienzo extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form Lienzo
     */
    Pelota p;
    Thread hilo;
    Random random=new Random();
    public Lienzo() {
        initComponents();
        p=new Pelota(100, 100, 50, 50,randomColor(),random.nextInt(100),random.nextInt(100));
        hilo=new Thread(this);
        hilo.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
       g.setColor(Color.WHITE);
       g.fillRect(0, 0,getWidth(), getHeight());       
       p.dibujar(g);
    }

    
    
    @Override
    public void run() {
        while (true) {            
            p.x+=p.dx;
            p.y+=p.dy;      
            if( p.x<=0 ||p.x+p.w>=getWidth()){
                p.dx=-p.dx;
                 p.color=randomColor();
            }
            if( p.y<=0 ||p.y+p.h>=getHeight()){
                p.dy=-p.dy;
                p.color=randomColor();
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    public Color randomColor(){
      int red=random.nextInt(256);
      int green=random.nextInt(256);
      int blue=random.nextInt(256);
      return new Color(red, green, blue);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
