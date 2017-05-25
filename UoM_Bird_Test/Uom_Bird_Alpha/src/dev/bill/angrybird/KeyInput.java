package dev.bill.angrybird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Bill on 02-May-17.
 */
public class KeyInput implements KeyListener {

    public static boolean jump;
    private boolean[] keys;

    public KeyInput() {

        keys = new boolean[256];
    }

    public void update() {
        jump = keys[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        update();
    }
}
