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
    private Background b1 = new Background();	//First background image
    private Background b2 = new Background();	//Second background image
    private static long updates;
    private static int count = 0;
    private int score = 0;

    public GameState(){

        bird = new Bird();
        pipes = new ArrayList<Pipe>();
        bg = new Background[]{b1, b2};

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
            if(pipes.get(i).collision(bird)){
            	
            	Game.menuState.setScore(score);
            	score = 0;
            	State.setCurrentState(Game.menuState);//System.out.println("HIT!");
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


        for(int j = 0; j < bg.length; j++){
            bg[j].update();

            if(bg[j].isOffscreen()) bg[j].resetX();
        }
    }

    @Override
    public void render(Graphics g) {
    	

        g.drawImage(b1.getBackground(), b1.getX(), 0, null);
        g.drawImage(b2.getBackground(), b2.getX() + b1.getBackground().getWidth() - 1, 0, null);
        g.drawImage(Assets.bird, bird.getX(), bird.getY(), null);

        for(Pipe p: pipes){

            g.setColor(Color.DARK_GRAY);
            g.fillRect(p.getX(), 0, p.getW(), p.getTop());
            g.fillRect(p.getX(), Display.HEIGHT - p.getBottom(), p.getW(), p.getBottom());

        }
        
        g.setColor(Color.YELLOW);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    	g.drawString("FPS: "+Long.toString(updates), 0, 20);
    	g.setColor(Color.GREEN);
    	g.drawString("Score: "+Integer.toString(score), 0, 50);

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
