package dev.bill.angrybird;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Bill on 03-May-17.
 */
public class GameState extends State{

    private Bird bird;
    private static ArrayList<Pipe> pipes;		//A list of the on-screen pipes
    private static Background[] bg;				//An array for the 2 background images required for the animation cycle
    private static Ground[] g;					//An array for the 2 ground images required for the animation cycle
    private Background b1 = new Background();	//First background image
    private Background b2 = new Background();	//Second background image
    private Ground ground1 = new Ground();		//First ground image
    private Ground ground2 = new Ground();		//Second ground image
    private static long updates;				//The game state needs the updates per second so that a pipe is added every 2 seconds
    private static int count = 0;
    private int score = 0;
    

    public GameState(){

        bird = new Bird();
        pipes = new ArrayList<Pipe>();
        bg = new Background[]{b1, b2};
        g = new Ground[]{ground1, ground2};

    }

    @Override
    public void update() {

        bird.update();
        
        for(int i = 0; i < pipes.size(); i++){
            
        	pipes.get(i).update();


            /**
             * Checks if the pipe is off the screen.
             * If it is, then it gets removed from the list
             * so that there are no potential memory issues.
             */
            if(pipes.get(i).isOffscreen()){
            	
            	pipes.remove(i);
            }	
            
            /**
             * Checks if the bird hits a pipe.
             * If it does the state is set to menu,
             * the bird resets to initial position
             * and the pipes list gets cleared of
             * any pipes.
             */
            if(pipes.get(i).collision(bird) || bird.touchedGround()){
            	
            	Game.menuState.setScore(score);
            	score = 0;
            	State.setCurrentState(Game.menuState);
            	pipes.clear();
            	bird.resetBird();
            }
            
            /**
             * Checks if the pipe has passed the bird.
             * If it did then the score gets updated.
             */
            else if(pipes.get(i).passed(bird))
            	score++;
        }

        for(int i = 0; i < 2; i++){
        	
        	g[i].update();
        	bg[i].update();
        	
        	if(g[i].isOffscreen()) g[i].resetX();
        	if(bg[i].isOffscreen()) bg[i].resetX();
        }
    }

    @Override
    public void render(Graphics g) {
    	
    	//Drawing the background image moving animation
    	
        g.drawImage(b1.getBackground(), b1.getX(), 0, null);
        g.drawImage(b2.getBackground(), b2.getX() + b1.getBackground().getWidth() - 1, 0, null);
        
        //End drawing the background image moving animation
        
        
        //Drawing the bird
        
        g.drawImage(Assets.bird, bird.getX(), bird.getY(), null);
        
        //End drawing the bird
                

        //Drawing the pipes
        
        for(Pipe p: pipes){

        	g.drawImage(Assets.topPipe, p.getX(), p.getTop() - Display.HEIGHT, null);
        	g.drawImage(Assets.bottomPipe, p.getX(), p.getGround() - p.getBottom(), null);

        }
        
        //End drawing the pipes
        
        
        //Drawing the ground image moving animation
        
        g.drawImage(ground1.getGround(), ground1.getX(), ground1.getY(), null);
        g.drawImage(ground2.getGround(), ground2.getX() + ground1.getGround().getWidth() - 1, ground2.getY(), null);
        
        //End drawing the ground image moving animation
        
        
        //Drawing the FPS counter
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    	g.drawString("FPS: "+Long.toString(updates), 0, 20);
    	g.setColor(Color.GREEN);
    	g.drawString("Score: "+Integer.toString(score), 0, 50);
    	
    	//End drawing the FPS counter

    }
    
    public void setUpdates(long u){
    	updates = u;
    }

    public static void addToPipes(){
        if(count == 0){
        	pipes.add(new Pipe());
        	count++;
        }
        else{
        	count = 0;
        }
    }
}
