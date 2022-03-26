/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Planeup extends Sprite {
    int i,j;
    BufferedImage imageup, imagedown, imageleft,imageright;
    
    public Planeup(int i , int j,String filename) {
       
        super("src/model/plane up.png");
        try {
            imageup = ImageIO.read(new File(filename));
            imagedown = ImageIO.read(new File(filename));
            imageleft = ImageIO.read(new File(filename));
            imageright = ImageIO.read(new File(filename));
        } catch (IOException ex) {
            Logger.getLogger(Planeup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.i = i;
        this.j = j;
      
       
        
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    

    
    
    

    
    
}
