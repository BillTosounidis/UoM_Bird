package dev.bill.angrybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Created by Bill on 03-May-17.
 * 
 * This class represents the main menu of the game. Provides functionality to start the game.
 * Each time the player loses he returns to this state.
 */
public class MenuState extends State {

    private Bird bird;
    private static long updates;
    private int score = 0;
    private int highscore = 0;

    public MenuState(){

        bird = new Bird();
    }

    @Override
    public void update() {

        bird.menuUpdate();
        
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.backgroundDay, 0, 0, null);
        g.drawImage(Assets.ground, 0, Display.HEIGHT - Assets.ground.getHeight(), null);
        g.drawImage(Assets.title, 100, 100, null);
        g.drawImage(Assets.playButton, 125, 350, null);
        g.drawImage(Assets.bird, bird.getX(), bird.getY(), null);
        g.setColor(Color.YELLOW);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    	g.drawString("FPS: "+Long.toString(updates), 0, 20);
    	g.setColor(Color.BLUE);
    	g.drawString("Last Score: "+Integer.toString(score), 143, 520);
    	g.drawString("High Score: "+Integer.toString(highscore), 141, 550);

    }
    
    public void setScore(int s){
    	score = s;
    	if(score > highscore){
    		highscore = score;
    	}
    }
    
    public void setUpdates(long u){
    	updates = u;
    }
    
}
