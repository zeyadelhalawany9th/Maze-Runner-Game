/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Bomb;
import Model.BrickWall;
import Model.Health;
import Model.PlayingGround;
import Model.TreeWall;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    PlayingGround currentgrid;
    public GamePanel(){
        currentgrid = new PlayingGround();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        currentgrid.drawGrid(g);
       
    }

    public PlayingGround getCurrentgrid() {
        return currentgrid;
    }
    
    
}
