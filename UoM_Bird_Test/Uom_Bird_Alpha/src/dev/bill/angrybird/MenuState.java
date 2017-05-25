package dev.bill.angrybird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Bill on 03-May-17.
 */
public class MenuState extends State {

    private JButton playButton;
    private ImageIcon playIcon;
    private Display display;
    private Bird bird;
    private static long updates;
    private int score = 0;

    public MenuState(Display d){

        display = d;
        bird = new Bird();
       //setUpButton();
    }

    private void setUpButton(){

        playButton = new JButton();
        playIcon = new ImageIcon(Assets.playButton);
        playButton.setIcon(playIcon);
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setOpaque(false);
    }

    @Override
    public void update() {

        bird.menuUpdate();
        
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.backgroundDay, 0, 0, null);
        g.drawImage(Assets.title, 100, 100, null);
        g.drawImage(Assets.playButton, 125, 350, null);
        g.drawImage(Assets.bird, bird.getX(), bird.getY(), null);
        g.setColor(Color.YELLOW);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
    	g.drawString("FPS: "+Long.toString(updates), 0, 20);
    	g.drawString("Last Score: "+Integer.toString(score), 143, 500);

    }
    
    public void setScore(int s){
    	score = s;
    }
    
    public void setUpdates(long u){
    	updates = u;
    }
    
}
