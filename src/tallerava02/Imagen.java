 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerava02;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author maurici ruiz plaza
 */
public class Imagen {
    //IMAGENES TABLERO
    public static final String HARRIBA = "harriba.png";
    public static final String HIZQ = "hizquierda.png";
    public static final String HDERE = "hderecha.png";
    public static final String HABAJO = "habajo.png";
    public static final String NADA = "nada.png";
    public static final String HOJA = "hoja.png";
    
    private BufferedImage image;
    
            
    public Imagen() {   
    }
    
    //METODO A TRAVES DE STRING OBTENER IMAGEN
    public Image getImage(String s){
         try {
            image = ImageIO.read(new File(s));
        } catch (IOException e) {
            System.out.println(e);
        }
        return image;
        
    }
    

 
}
