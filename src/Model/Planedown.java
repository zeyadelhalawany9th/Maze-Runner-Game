/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mabady
 */
public class Planedown extends Sprite{
    
    int i,j;
    
    public Planedown(int i , int j) {
       
        super("src/model/plane down.png");
       
        
        
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
