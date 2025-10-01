package dev.danipraivet.game;

import dev.danipraivet.game.entities.Player;
import dev.danipraivet.game.window.WindowGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControllerGame implements KeyListener {
    private static final int SPEED = 5;
    private static boolean a, d, w, s;
    private static final Player player = WindowGame.PANEL.getPlayer();


    public static void update() {
        playerKeybindsListener();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        checkPressedKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        checkReleasedKey(e);
    }

    public static void checkPressedKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65 -> a = true; // A
            case 68 -> d = true; // D
            case 87 -> w = true; // W
            case 83 -> s = true; // S
        }
    }

    public static void checkReleasedKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65 -> a = false;
            case 68 -> d = false;
            case 87 -> w = false;
            case 83 -> s = false;
        }
    }

    public static void playerKeybindsListener() {
        if (a) {
            player.move(-SPEED, 0);
        }
        if (d) {
            player.move(SPEED, 0);
        }
        if (w) {
            player.move(0, SPEED);
        }
        if (s) {
            player.move(0, -SPEED);
        }
    }
}
