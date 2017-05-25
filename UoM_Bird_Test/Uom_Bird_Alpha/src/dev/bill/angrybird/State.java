package dev.bill.angrybird;

import java.awt.*;

/**
 * Created by Bill on 03-May-17.
 */
public abstract class State {

    private static State currentState = null;

    public static void setCurrentState(State newState){
        currentState = newState;
    }

    public static State getCurrentState(){
        return currentState;
    }

    public abstract void update();

    public abstract void render(Graphics g);
    
    public abstract void setUpdates(long u);
    
}
