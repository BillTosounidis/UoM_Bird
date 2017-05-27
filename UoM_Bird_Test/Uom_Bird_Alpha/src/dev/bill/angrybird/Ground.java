package dev.bill.angrybird;

import java.awt.image.BufferedImage;

/**
 * Created by Bill on 04-May-17.
 */
public class Ground {

    private int speed = 2;
    private int x = 0;
    private int y;

    public Ground(){

    	y = Display.HEIGHT - Assets.ground.getHeight();
    }
    
    public void update(){
    	
    	x -= speed;
    }
    
    public boolean isOffscreen(){
        
    	return x < - Assets.backgroundDay.getWidth();
    }
    
    public void resetX(){
    	
    	x = 0;
    }
    
    public BufferedImage getGround(){
    	return Assets.ground;
    }
    
    public int getX(){
        
    	return x;
    }
    
    public int getY(){
    	
    	return y;
    }

}
