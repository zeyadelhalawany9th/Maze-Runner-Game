/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bullet;
import Model.PlayingGround;
import Model.Planedown;
import Model.Planeup;
import Model.PlayingGround;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author mabady
 */
public class MovementObserver {

    PlayingGround grid;
    String lastdirection;
    GameStatusObserver gameStatusObserver;
    HealthState state;
    Bullet bullet;
    

    public MovementObserver(PlayingGround grid, GameStatusObserver gameStatusObserver, HealthState state) {
        this.grid = grid;
        this.lastdirection = "up";
        this.gameStatusObserver = gameStatusObserver;
        this.state = state;
    }

    @SuppressWarnings("empty-statement")
    public void movementupdate(int keycode) {
        if (state.health <= 0) {
            gameStatusObserver.gameoverupdate();
        }
                
        int oldI = grid.getPlane().getI();
        int oldJ = grid.getPlane().getJ();

        switch (keycode) {

            case KeyEvent.VK_DOWN:
                lastdirection = "Down";
                if (oldI >= 29) {
                    return;
                } else if (grid.isBomb(oldI + 1, oldJ)) {
                    ;
                    state.sethealth(state.health -= 20);

                    grid.deletebomb(oldI + 1, oldJ);

                } else if (grid.isBomb2(oldI + 1, oldJ)) {

                    
                    state.sethealth(state.health -= 50);

                    grid.deleteBomb2(oldI + 1, oldJ);

                } else if (grid.isBrickWall(oldI + 1, oldJ) || grid.isTreeWall(oldI + 1, oldJ)) {
                    return;
                } else if (grid.isGift(oldI + 1, oldJ)) {
                    if (state.health == 100) {
                        return;
                    } else {
                        
                        state.sethealth(state.health += 20);

                        grid.deleteGift(oldI + 1, oldJ);
                    }
                }

                grid.getPlane().setI(oldI + 1);
                break;

            case KeyEvent.VK_UP:
                lastdirection = "up";

                if (oldI <= 0) {
                    gameStatusObserver.gamewon();
                } else if (grid.isBomb(oldI - 1, oldJ)) {

                    
                    state.sethealth(state.health -= 20);

                    grid.deletebomb(oldI - 1, oldJ);

                } else if (grid.isBomb2(oldI - 1, oldJ)) {

                    
                    state.sethealth(state.health -= 50);

                    grid.deleteBomb2(oldI - 1, oldJ);

                } else if (grid.isBrickWall(oldI - 1, oldJ) || grid.isTreeWall(oldI - 1, oldJ)) {
                    return;
                } else if (grid.isGift(oldI - 1, oldJ)) {
                    if (state.health == 100) {
                        return;
                    } else {
                       
                        state.sethealth( state.health += 20);

                        grid.deleteGift(oldI - 1, oldJ);
                    }
                }
                grid.getPlane().setI(oldI - 1);

                break;

            case KeyEvent.VK_LEFT:
                lastdirection = "left";

                if (oldJ <= 0) {
                    return;

                } else if (grid.isBomb(oldI, oldJ - 1)) {

                    
                    state.sethealth(state.health -= 20);

                    grid.deletebomb(oldI, oldJ - 1);

                } else if (grid.isBomb2(oldI, oldJ - 1)) {

                    
                    state.sethealth(state.health -= 50);

                    grid.deleteBomb2(oldI, oldJ - 1);

                } else if (grid.isBrickWall(oldI, oldJ - 1) || grid.isTreeWall(oldI, oldJ - 1)) {
                    return;
                } else if (grid.isGift(oldI, oldJ - 1)) {
                    if (state.health == 100) {
                        return;
                    } else {
                       
                        state.sethealth( state.health += 20);

                        grid.deleteGift(oldI, oldJ - 1);
                    }
                }
                grid.getPlane().setJ(oldJ - 1);
                break;

            case KeyEvent.VK_RIGHT:
                lastdirection = "right";
                if (oldJ >= 29) {
                    return;
                } else if (grid.isBomb(oldI, oldJ + 1)) {

                    
                    state.sethealth(state.health -= 20);
                    grid.deletebomb(oldI, oldJ + 1);

                } else if (grid.isBomb2(oldI, oldJ + 1)) {
                    
                    state.sethealth(state.health -= 50);
                    grid.deleteBomb2(oldI, oldJ + 1);
                } else if (grid.isBrickWall(oldI, oldJ + 1) || grid.isTreeWall(oldI, oldJ + 1)) {
                    return;
                } else if (grid.isGift(oldI, oldJ + 1)) {
                    if (state.health == 100) {
                        return;
                    } else {
                        
                        state.sethealth(state.health += 20);
                        grid.deleteGift(oldI, oldJ + 1);
                    }
                }
                grid.getPlane().setJ(oldJ + 1);
                break;
                
            case KeyEvent.VK_SPACE:
                
                
                    
                    if (grid.isBomb(oldI - 1, oldJ)) {
                        
                        grid.deletebomb(oldI - 1, oldJ);
                        grid.deleteBullet(oldI - 1, oldJ);
                    } else if (grid.isBomb2(oldI - 1, oldJ)) {
                        
                        grid.deleteBomb2(oldI - 1, oldJ);
                        grid.deleteBullet(oldI - 1, oldJ);
                    } else if (grid.isBrickWall(oldI - 1, oldJ)) {
                        return;
                    } else if (grid.isTreeWall(oldI - 1, oldJ)) {
                        
                        
                        grid.deletetree(oldI - 1, oldJ);
                        grid.deleteBullet(oldI - 1, oldJ);
                    } else if (grid.getshapesongrid()[oldI - 1][oldJ] == null) {
                        grid.setbullet(oldI - 1, oldJ);
                        grid.changebullet(oldI-1, oldJ);
                    }
                    else if(grid.isGift(oldI-1,oldJ)){
                        return;
                    }
                
                         
               
        }
    }

}
