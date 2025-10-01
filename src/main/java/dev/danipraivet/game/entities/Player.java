package dev.danipraivet.game.entities;

import java.awt.*;

public class Player extends Entity {
    Color color = Color.RED;

    public Player(double x, double y, Color color) {
        super(x, y, color);
    }
}
