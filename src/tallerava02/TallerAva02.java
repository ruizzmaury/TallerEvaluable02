
package tallerava02;

/**
 *
 * @author maurici ruiz plaza
 */


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import static tallerava02.Tablero.hayhojas;
import static tallerava02.Tablero.initX;
import static tallerava02.Tablero.initY;
import static tallerava02.Tablero.sentido;


import static tallerava02.Tablero.t;



public class TallerAva02 extends JFrame implements KeyListener {
    
    Tablero tablero;
    int cuentaHojas = 1; //inicializacion de comida de hojas
    
    public TallerAva02() throws IOException {
        super("Joc de la formiga");
        this.setTitle("Joc de la formiga");
        tablero = new Tablero(); //crea tablero
        addKeyListener(this);
        this.getContentPane().add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) throws IOException {
        TallerAva02 t = new TallerAva02();
        t.setVisible(true);
    }
    
    
   
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) { //ORIENTACIÓN Y MOVIMIENTO HORMIGA AL ACCIONAR TECLA
        Imagen img = new Imagen();       
        int code = e.getExtendedKeyCode();
        
        //ROTACIÓN HORMIGA
        if(code == KeyEvent.VK_UP) { //hormiga ARRIBA
            sentido = 1;
            t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HARRIBA)); //se indica el dibujo de la hormiga hacia arriba
            repaint();   
        }
        
        if(code == KeyEvent.VK_DOWN) { //hormiga ABAJO
            sentido = 3;
            t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HABAJO)); //se indica el dibujo de la hormiga hacia abajo
            repaint(); 
        }
       
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) { //hormiga DERECHA
            sentido = 2;
            t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HDERE)); //se indica el dibujo de la hormiga hacia derecha
            repaint(); 
        }
       
        if(e.getKeyCode() == KeyEvent.VK_LEFT) { //hormiga IZQUIERDA
            sentido = 4;
            t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HIZQ)); //se indica el dibujo de la hormiga hacia izquierda
            repaint(); 
        }  
        
        //AVANCE HORMIGA
        if(code == KeyEvent.VK_SPACE) {
            
                switch(sentido) {
                    
                    case 1: //AVANCE HORMIGA ARRIBA
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.NADA));
                        
                        hayHojas();
                        
                        initY = initY-1;
                        
                        if(initY < 0) {
                            initY = 19;
                            
                        }
                        
                        if(initY > 19) {
                            initY = 0;
                        }
                        
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HARRIBA));
                        
                        repaint();
                        
                        endGame();
                        
                        break;
                        
                        
                    case 2: //AVANCE HORMIGA DERECHA
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.NADA));
                        
                        hayHojas();
                        
                        initX = initX + 1;
                        
                        if(initX < 0) {
                            initX = 19;
                        }
                        
                        if(initX > 19) {
                            initX = 0;
                        }
                        
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HDERE));
                        repaint();
                        
                        endGame();
                        
                        break;
                        
                        
                    case 3: //AVANCE HORMIGA ABAJO
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.NADA));
                        
                        hayHojas();
                        
                        initY = initY + 1;
                        
                        
                        
                        if(initY < 0) {
                            initY = 19;
                            
                        }
                        
                        if(initY > 19) {
                            initY = 0;
                        }
                        
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HABAJO));
                        repaint();
                        
                        endGame();
                        
                        break;
                        
                        
                    case 4: //AVANCE HORMIGA IZQUIERDA
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.NADA));
                         
                        hayHojas();
                        
                        initX = initX-1;
                        
                        if(initX < 0) {
                            initX = 19;
                        }
                        
                        if(initX > 19) {
                            initX = 0;
                        }
                        
                        t[initY][initX]= new Casilla(initX*40,initY*40,img.getImage(Imagen.HIZQ));
                        repaint();
                        
                        endGame();
                        
                        break;
                }
                
            }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    public void hayHojas() {//metodo contabilizar hojas comidas
        
        if (hayhojas[initY][initX] == true) { 
                hayhojas[initY][initX] = false;
                cuentaHojas++;
                            
        }
    }
    
    public void endGame() { //Metodo para finalizar juego con mensaje al comerse todas las hojas
        
        if (cuentaHojas == 399) {
            
            showMessageDialog(null, "                       ENHORABUENA\n" +
                                "         ¡¡¡has completado el juego!!!\n" +
                                " LA HORMIGA SE HA COMIDO TODAS LAS HOJAS");
            setVisible(false); //you can't see me!
            dispose();

        }
    }
    
   
}
    

