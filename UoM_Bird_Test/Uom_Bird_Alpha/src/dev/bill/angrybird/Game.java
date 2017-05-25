package dev.bill.angrybird;


import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * Created by Bill on 02-May-17.
 */
public class Game implements Runnable{

    private Display display;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;
    public static GameState gameState;
    public static MenuState menuState;
    public static MouseInput m;

    public static KeyInput k;


    public Game(){


    }

    public void init(){

        new Assets();
        display = new Display();
        k = new KeyInput();
        m = new MouseInput();
        display.getCanvas().addMouseListener(m);
        display.getFrame().addKeyListener(k);
        gameState = new GameState();
        menuState = new MenuState(display);
        State.setCurrentState(menuState);

    }

    public void update(){

        if(State.getCurrentState() != null)
            State.getCurrentState().update();
    }

    public void render(){

        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();


        g.clearRect(0, 0, Display.WIDTH, Display.HEIGHT);
        //draw

        if(State.getCurrentState() != null)
            State.getCurrentState().render(g);

        //endDraw
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long updates = 0;

        while(running){

            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){

                update();
                render();
                updates++;
                delta--;
            }
            

            if(timer >= 1000000000){

                //System.out.println("FPS: " + updates);
                State.getCurrentState().setUpdates(updates);
                if(State.getCurrentState() == gameState) GameState.addToPipes();
                updates = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start(){

        if(running) return;

        thread = new Thread(this);
        running = true;
        thread.start();
    }

    public synchronized void stop(){

        if(!running) return;

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
