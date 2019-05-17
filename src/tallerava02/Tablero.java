/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerava02;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author mauri
 */
public final class Tablero extends JPanel {
    
    private static final int DIMENSION = 20;
    private static final int MAXIMO = 800;
    public static final int LADO = MAXIMO / DIMENSION;
    public static Casilla t[][];
    public static int hx;
    public static int hy;

    public Tablero() throws IOException  {
        Imagen img = new Imagen();
        Random ran = new Random();
        int auX = ran.nextInt(20);
        int auY = ran.nextInt(20);
        
        t = new Casilla[DIMENSION][DIMENSION];
        int y = 0;
        for (int i = 0; i < DIMENSION; i++) {
            int x = 0;
            for (int j = 0; j < DIMENSION; j++) {
               if(i != auY || j != auX){
                    t[i][j] = new Casilla(x,y,img.getImage(Imagen.HOJA));
                    
               }else {
                    t[i][j]= new Casilla(x,y,img.getImage(Imagen.HDERE));
                    hx = j;
                    hy = i;
               }
                x += LADO;
            }
            y += LADO;
        } 
    }
    

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {                
                t[i][j].paintComponent(g);
                t[hy][hx].paintComponent(g);
            }
        }
    }
    
 
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIMO, MAXIMO);
    }

    
}
