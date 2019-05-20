
package tallerava02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author maurici ruiz plaza
 */
public class Casilla {
    
    //ATRIBUTOS CASILLA
    private Image image;
    private int x;
    private int y;
    

    public Casilla(int x, int y, Image img) {
        this.image = img;
        this.x = x;
        this.y = y;
    }

    void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, x, y, Tablero.LADO, Tablero.LADO, null);
        
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
    
    
    
}
