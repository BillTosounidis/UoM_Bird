package dev.bill.angrybird;

/**
 * Created by Bill on 02-May-17.
 */
public class Bird {

    private int y;									//Vertical position of the bird in the screen
    private int x;									//Horizontal position of the bird in the screen
    private final double gravity = 1.2;             //force that pulls the bird downwards
    private double velocity = 0;                    //the speed at which the bird moves (upwards or downwards)
    private double lift = -25;                      //force at which the bird is pulled upwards when 'SPACE' is pressed
    private boolean pressed;                        //helps with key pressed bug

    public Bird(){

        pressed = false;

        x = (Display.WIDTH - Assets.bird.getWidth()) / 2 - 60;
        y = (Display.HEIGHT - Assets.bird.getHeight()) / 2;
    }

    public void update(){

        velocity += gravity;
        velocity *= 0.9;
        y += velocity;

        /**
         * eliminates continuous key pressing bug
         * if not for this holding down 'Space' would make the bird go up non-stop
         */
        if(KeyInput.jump){

            if(!pressed){

                velocity += lift;
            }

            pressed = true;
        }

        if(!KeyInput.jump){
        	
        	pressed = false;
        }

        /**
         * Keeps the bird from going over the screen
         */
        if(y <= 0){

            y = 0;
            velocity = 0;
        }
    }

    /**
     * This method is used in the menu state to keep the bird at
     * a fixed position.
     */
    public void menuUpdate(){

        velocity += gravity/2;
        velocity *= 0.9;
        y += velocity;

        if(y >= (Display.HEIGHT - Assets.bird.getHeight()) / 2){

            velocity -= 15;
        }

    }
    
    /**
     * 
     * @return True if the bird hits the ground.
     */
    public boolean touchedGround(){
    	
    	return y >= Display.HEIGHT - Assets.ground.getHeight();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    /**
     * Resets the bird to it's initial position
     */
    public void resetBird(){
    	
    	x = (Display.WIDTH - Assets.bird.getWidth()) / 2 - 60;
    	y = (Display.HEIGHT - Assets.bird.getHeight()) / 2;
    	velocity = 0;
    }
}
