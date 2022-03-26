/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author mabady
 */
public class KeyBoardController extends KeyAdapter{
    
    MovementObserver movementobserver;

    public KeyBoardController(MovementObserver movementobserver) {
        this.movementobserver = movementobserver;
    }
        
    @Override
    public void keyPressed(KeyEvent ke){
        int keycode = ke.getKeyCode();
        movementobserver.movementupdate(keycode);
    }
    
}
