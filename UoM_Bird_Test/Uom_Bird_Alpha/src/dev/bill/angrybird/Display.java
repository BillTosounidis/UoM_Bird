package dev.bill.angrybird;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Bill on 02-May-17.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;
    private BufferedImage frameIcon;

    private final String title = "Flappy Bird - Pre Alpha 0.0.1";
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    public Display(){

        createDisplay();
    }

    private void createDisplay(){

        frame = new JFrame(title);
        canvas = new Canvas();
        frameIcon = ImageLoader.loadImage("/Images/icon.png");

        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(frameIcon);
        frame.setVisible(true);

        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public JFrame getFrame(){
        return frame;
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
