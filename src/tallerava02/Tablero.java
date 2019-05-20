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
 * @author maurici ruiz plaza
 */
public final class Tablero extends JPanel {
    
    private static final int DIMENSION = 20;
    private static final int MAXIMO = 800;
    public static final int LADO = MAXIMO / DIMENSION;
    public static Casilla t[][];
    public static int  initX, initY, sentido; //initX,initY localizacion de la hormiga en el tablero; 
    //sentido=1 arriba; sentido=2 derecha; sentido=3 abajo; sentido=4 izquierda;
    //se inicializa la hormiga en sentido 2, derecho;
    public static boolean[][] hayhojas = new boolean[20][20];

    public Tablero() throws IOException  {
        Imagen img = new Imagen();
        Random ran = new Random();
        int auJ = ran.nextInt(20); // localizacion inicial aleatoria de hormiga
        int auI = ran.nextInt(20);
        
        
        t = new Casilla[DIMENSION][DIMENSION];
        int y = 0;
        
        //generar tablero
        for (int i = 0; i < DIMENSION; i++) {
            int x = 0;
            for (int j = 0; j < DIMENSION; j++) {
                
               if(i != auI || j != auJ){
                    t[i][j] = new Casilla(x,y,img.getImage(Imagen.HOJA));
                    hayhojas[i][j] = true; //true en casilla con hoja
                    
               }else {
                   
                   sentido = 2; //inicializa la hormiga en sentido 2, derecho;
                   
                   initX = j;
                   initY = i;
                    
                   t[i][j] = new Casilla(x,y,img.getImage(Imagen.HDERE));
                   
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
                
            }
        }
    }
    
 
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIMO, MAXIMO);
    }


    
    
}
