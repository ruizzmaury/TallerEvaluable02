
package tallerava02;

/**
 *
 * @author mauri
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;
import static tallerava02.Tablero.LADO;
import static tallerava02.Tablero.hx;
import static tallerava02.Tablero.hy;
import static tallerava02.Tablero.t;


public class TallerAva02 extends JFrame implements KeyListener {
    
    private Tablero tablero;
    
    public TallerAva02() throws IOException {
        tablero = new Tablero();
        this.getContentPane().add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        Imagen img = new Imagen();
        char ch = e.getKeyChar();

        System.out.println(e.getKeyChar());
        
        if(e.getKeyCode() == KeyEvent.VK_UP) { //hormiga ARRIBA
            
            Tablero.t[hx][hy] = new Casilla(LADO,LADO,img.getImage(Imagen.HARRIBA));
            
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                t[hy][hx] = new Casilla(LADO,LADO,img.getImage(Imagen.NADA)); 
                hy = hy-1;
                t[hy][hx] = new Casilla(LADO,LADO,img.getImage(Imagen.HARRIBA));
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
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) throws IOException {
        TallerAva02 t = new TallerAva02();
        t.setVisible(true);
    }

    

   
}
    

