/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Controller.HealthState;
import java.awt.Graphics;

/**
 *
 * @author mabady
 */
public class PlayingGround {
    
    private Sprite [][] shapesongrid;
    
    int dimensions;
    Planeup plane;
    Planedown planedown;
    Bullet bullet;
    HealthState state;
    

    public PlayingGround() {
       
        dimensions = 30;
        shapesongrid = new Sprite[dimensions][dimensions];
        
        
        for(int i = 0; i<dimensions*140/150;i++){
            for(int j =0;j<dimensions ;j++){
                double randomnumber = Math.random();
                if(randomnumber>0.8)
                    shapesongrid[i][j]= WallFactory.creatbrickwall();
                else if(randomnumber<0.06)
                    shapesongrid[i][j]= WallFactory.creattreewall();
                else if(randomnumber<0.099){
                    shapesongrid[i][j] = BombFactory.creatbomb();
                }
                else if(randomnumber<0.103){
                    shapesongrid[i][j]= GiftFactory.creatHealth();                    
                }
                else if(randomnumber<0.106){
                    shapesongrid[i][j] = BombFactory.creatBomb2();
                }
                else if(randomnumber<0.109){
                    shapesongrid[i][j] = ArmorFactory.creatArmor();
                }
                
            }
        }
        for(int i =(dimensions-(dimensions*10/150)+1);i<dimensions;i++){
            for(int j =0;j<dimensions;j++){
                double randomnumber = Math.random();
                if(randomnumber>0.7)
                    shapesongrid[i][j]= WallFactory.creatbrickwall();
                else if(randomnumber<0.029){
                    shapesongrid[i][j] = BombFactory.creatbomb();
                }
                
            }
        }
       
        int i = dimensions-1;
        for (int j = 0; j < dimensions; j++) {
            if(shapesongrid[i][j]== null){
                plane = new Planeup(i,j,"src/model/plane up.png");
             break;
            }
        }
       
    }
     public void drawGrid(Graphics g){
            for(int i = 0; i<dimensions;i++){
            for(int j =0;j<dimensions;j++){
              if(shapesongrid[i][j]!= null){
                  g.drawImage(shapesongrid[i][j].image,j*600/dimensions , i*600/dimensions,600/30,600/30, null);
              }
                }
            }
            int i = plane.i;
            int j = plane.j;
             g.drawImage(plane.image,j*600/dimensions , i*600/dimensions,600/30,600/30, null);
        }

    public Planeup getPlane() {
        return plane;
    }
    public Planedown getPlanedown() {
        return planedown;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
     public boolean isBomb(int i , int j){
         return shapesongrid[i][j] instanceof Bomb;
     } 
     public boolean isBrickWall(int i , int j){
         return shapesongrid[i][j] instanceof BrickWall;
     }
     public boolean isTreeWall(int i, int j){
         
         return shapesongrid[i][j] instanceof TreeWall; 
     }
     public boolean isGift(int i,int j){
         return shapesongrid[i][j] instanceof Health;
     }
     public Sprite deletebomb(int i,int j){
         return shapesongrid[i][j] = null; 
     }
     public Sprite deleteGift(int i,int j){
         return shapesongrid[i][j]= null;
     }
     public Sprite deleteBomb2(int i,int j){
         return shapesongrid[i][j]= null;
     }
     public boolean isBomb2(int i,int j){
         return shapesongrid[i][j] instanceof Bomb2;
     }
     public Sprite[][] getshapesongrid(){
         return shapesongrid;
     }

    public Sprite deletetree(int i , int j ) {
        return shapesongrid[i][j] = null; 
    }
    
    public Sprite deleteBullet(int i , int j){
        return shapesongrid[i][j] = null;
    }
   
    public Sprite setbullet(int i , int j )
    {
        
         Bullet b = new Bullet(i , j,6);
         return shapesongrid[i][j] = b;   
    }
    public void changebullet(int i , int j){
        
        while(i!=0){    
        if(this.isBrickWall(i-1, j)||this.isGift(i-1, j)){
           break;
        }
        
        else if(this.isBomb(i-1, j)) {
           this.deletebomb(i-1, j);
           break;
                }
        else if(this.isBomb2(i-1, j)) {
           this.deleteBomb2(i-1, j);
           break;
                }
       
        else if(this.isTreeWall(i-1, j)){
            this.deletetree(i-1, j);
           break;
        }
       
        
        i--;
        }
        
        
        
    }
    public boolean isBullet(int i,int j){
         return shapesongrid[i][j] instanceof Bullet;
     }
    public Sprite setplanedown(int i , int j){
        Planedown down = new Planedown(i ,j);
        return shapesongrid[i][j] = down;
    }
    public Sprite deletePlaneup(int i , int j){
        return shapesongrid[i][j] = null;
    }
    
    
}
