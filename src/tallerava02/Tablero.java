/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerava02;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author mauri
 */
public final class Tablero extends JPanel implements KeyListener {
    
    private static final int DIMENSION = 20;
    private static final int MAXIMO = 800;
    public static final int LADO = MAXIMO / DIMENSION;
    public static Casilla t[][];
    private static int hx, hy, uptablero, downtablero, rightablero, leftablero;
    

    public Tablero() throws IOException  {
        Imagen img = new Imagen();
        Random ran = new Random();
        int auX = ran.nextInt(20);
        int auY = ran.nextInt(20);
        
        t = new Casilla[DIMENSION][DIMENSION];
        int y = 0;
        
        //generar tablero
        for (int i = 0; i < DIMENSION; i++) {
            int x = 0;
            for (int j = 0; j < DIMENSION; j++) {
               if(i != auY || j != auX){
                    t[i][j] = new Casilla(x,y,img.getImage(Imagen.HOJA));
                    
               }else {
                    t[i][j]= new Casilla(x,y,img.getImage(Imagen.HDERE));
                    getAntLocation(i,j);
               }
                x += LADO;
            }
            y += LADO;
        } 
    }
    
    
    public void getAntLocation(int x, int y) {
        hx = x;
        hy = y;
        
        downtablero = 20 - hy;
        uptablero = 20 - downtablero;
        rightablero = 20 - hx;
        leftablero = 20 - rightablero;
        
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        t[hy][hx].paintComponent(g); 
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {                
                t[i][j].paintComponent(g);
                
            }
        }
    }
    
 
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIMO, MAXIMO);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Imagen img = new Imagen();
        
        
        if(e.getKeyCode() == KeyEvent.VK_UP) { //hormiga ARRIBA
            
            t[hy][hx] = new Casilla(LADO,LADO, img.getImage(Imagen.HARRIBA));
                
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                
                repaint();
            }
            repaint();
        }
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN) { //hormiga ABAJO
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
           
            }
        }
       
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) { //hormiga DERECHA
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
           
            }
        }
       
        if(e.getKeyCode() == KeyEvent.VK_LEFT) { //hormiga IZQUIERDA
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
           
            }
        }   
       
    }
    

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
