package dev.danipraivet.game.entities;

import java.awt.*;

public class Player extends Entity {
    public Player(double x, double y) {
        super(x, y , Color.RED);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, getWIDTH(), getHEIGHT());
    }
}
