package dev.bill.angrybird;

import java.util.Random;

/**
 * Created by Bill on 02-May-17.
 * 
 * This class represents the top and bottom obstacles in the game called pipes.
 * Each pipe gets a random height, but each time the pipes have a 150px gap between them.
 */
public class Pipe {

    private Random rand = new Random();
    private int top;                                               //upper pipe
    private int bottom;                                            //lower pipe
    private int x = Display.WIDTH;                                 //pipe starting point
    private int speed = 2;                                         //horizontal speed
    private int w = 80;                                            //width of pipes
    private int ground = Display.HEIGHT - Assets.ground.getHeight();



    public Pipe(){

    	//Pipes get random height but this ensures they always have 130px between them
        while(top + bottom != ground - 130){

            top = rand.nextInt(ground);
            bottom = rand.nextInt(ground);
        }

    }

    public void update(){

        x -= speed;

    }

    /**
     * Checks if the pipe has gone off screen
     * @return true if it is off screen, false otherwise
     */
    public boolean isOffscreen(){
        return x < -w;
    }

    /**
     * 
     * @return the height of the top pipe (in px)
     */
    public int getTop(){
        return top;
    }

    /**
     * 
     * @return the height of the bottom pipe (in px)
     */
    public int getBottom(){
        return bottom;
    }

    /**
     * 
     * @return the horizontal position of the pipe in the screen
     */
    public int getX(){
        return x;
    }
    
    /**
     * 
     * @return the width of the pipe
     */
    public int getW(){
        return w;
    }
    
    public int getGround(){
    	return ground;
    }

    /**
     * This method checks if the bird collides with any of the pipes(top or bottom)
     * 
     * @param b is the bird that is given as parameter to the method
     * @return returns true if it collides, false otherwise
     */
    public boolean collision(Bird b){

        if(b.getY() < top || (b.getY() > ground - bottom || b.getY() + Assets.bird.getHeight() > ground - bottom)) {

            if (b.getX() + Assets.bird.getWidth() > x && b.getX() + Assets.bird.getWidth()< x + w) {

                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the bird has passed the pipes in order to update the score
     * 
     * @param b is the bird that is given as parameter to the method
     * @return true if it passed, false otherwise
     */
    public boolean passed(Bird b){
    	
    	if(b.getX() == x + w){
    		return true;
    	}
    	
    	return false;
    }
}
