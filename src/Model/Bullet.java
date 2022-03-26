/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Sprite;

public class Bullet extends Sprite {
    
    int i,j;
    int ammo = 6;
    public Bullet(int i , int j, int ammo) {
        
        super("src/model/Bullet.png");
        this.i = i;
        this.j = j;
        this.ammo = ammo;
    }
    
    
    
    public void changebullte(int i , int j ){
        while(i!=0){
            this.setI(i-1);
            i--;
        }
    }
    public int getammo(){
        return ammo;
    }
    public void decreasebullet(){
       ammo-=1;
    }

    public void setI(int i) {
        this.i = i-1;
    }
    
    
    
}
