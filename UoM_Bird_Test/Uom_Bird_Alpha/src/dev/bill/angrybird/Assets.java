package dev.bill.angrybird;

import java.awt.image.BufferedImage;

/**
 * Created by Bill on 05-May-17.
 * Loads the sprite sheet and crops every object
 */
public class Assets {

    public static BufferedImage bird, topPipe, bottomPipe, backgroundDay, backgroundNight, ground, playButton, title, sprite;

    public Assets(){

        sprite = ImageLoader.loadImage("/Images/sprite_sheet.png");
        cropAssets();
    }

    public void cropAssets(){

        //backgroundNight = sprite.getSubimage(0,0, 400, 600);
        backgroundDay = sprite.getSubimage(402, 0, 400, 600);
        ground = sprite.getSubimage(394, 602, 400, 133);
        topPipe = sprite.getSubimage(804, 0, 59, 600);
        bottomPipe = sprite.getSubimage(867, 0, 59, 600);
        bird = sprite.getSubimage(356, 602, 36, 26);
        playButton = sprite.getSubimage(0, 602, 152, 85);
        title = sprite.getSubimage(154, 602, 200, 59);
    }
}
