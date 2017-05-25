package dev.bill.angrybird;

import java.awt.image.BufferedImage;


/**
 * Created by Bill on 03-May-17.
 */
public class Background {

    private int speed = 1;
    private int x = 0;

    public Background(){

    }

    public void update(){
        x -= speed;
    }

    public boolean isOffscreen(){
        return x < - Assets.backgroundDay.getWidth();
    }

    public BufferedImage getBackground(){
        return Assets.backgroundDay;
    }

    public int getX(){
        return x;
    }

    public void resetX(){
        x = 0;
    }
}
