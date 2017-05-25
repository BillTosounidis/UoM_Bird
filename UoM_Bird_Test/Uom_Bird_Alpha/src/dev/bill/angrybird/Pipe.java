package dev.bill.angrybird;

import java.util.Random;

/**
 * Created by Bill on 02-May-17.
 */
public class Pipe {

    private Random rand = new Random();
    private int top;                                               //upper pipe
    private int bottom;                                            //lower pipe
    private int x = Display.WIDTH;                                 //pipe starting point
    private int speed = 2;                                         //horizontal speed
    private int w = 80;                                            //width of pipes



    public Pipe(){

        while(top + bottom != Display.HEIGHT - 150){

            top = rand.nextInt(Display.HEIGHT);
            bottom = rand.nextInt(Display.HEIGHT);
        }

    }

    public void update(){

        x -= speed;

    }

    public boolean isOffscreen(){
        return x < -w;
    }

    public int getTop(){
        return top;
    }

    public int getBottom(){
        return bottom;
    }

    public int getX(){
        return x;
    }
    public int getW(){
        return w;
    }

    public boolean collision(Bird b){

        if(b.getY() < top || b.getY() > Display.HEIGHT - bottom) {

            if (b.getX() + Assets.bird.getWidth() > x && b.getX() + Assets.bird.getWidth()< x + w) {

                return true;
            }
        }
        return false;
    }
    
    public boolean passed(Bird b){
    	
    	if(b.getX() == x + w){
    		return true;
    	}
    	
    	return false;
    }
}
