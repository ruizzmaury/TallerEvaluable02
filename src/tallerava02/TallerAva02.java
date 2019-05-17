
package tallerava02;

/**
 *
 * @author mauri
 */


import java.io.IOException;
import javax.swing.*;


public class TallerAva02 extends JFrame {
    
    private Tablero tablero;
    
    public TallerAva02() throws IOException {
        tablero = new Tablero();
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

   
}
    

