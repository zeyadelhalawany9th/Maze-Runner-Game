/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Game;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameStatusObserver {
    Game game;

    public GameStatusObserver(Game game) {
        this.game = game;
    }
     public void gameoverupdate(){
         game.removeListener();
         JOptionPane.showMessageDialog(new JPanel(), "Game Over", "Opss!!", JOptionPane.ERROR_MESSAGE);
     }
     public void gamewon(){
         game.removeListener();
         JOptionPane.showMessageDialog(new JPanel(), "YOU WON!!!!","CONGRATULATIONS" , JOptionPane.ERROR_MESSAGE);
     }
     
}
