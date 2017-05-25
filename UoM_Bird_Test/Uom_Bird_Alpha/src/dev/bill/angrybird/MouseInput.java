package dev.bill.angrybird;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Bill on 11-May-17.
 */
public class MouseInput implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getX() >= 125 && e.getY() >= 350){
            if(e.getX() < Assets.playButton.getWidth() + 125 && e.getY() < Assets.playButton.getHeight() + 350){
                State.setCurrentState(Game.gameState);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
