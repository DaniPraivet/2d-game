package dev.danipraivet.game.math;

import dev.danipraivet.game.entities.Entity;

public class Velocity {
    private static final int MAX_VELOCITY = 10;
    private double x;
    private double y;

    public Velocity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(Entity e) {
        e.setX(e.getX() + this.x);
        e.setY(e.getY() + this.y);
    }

    public void setVelocityX(double x) {
        this.x = Math.max(-MAX_VELOCITY, Math.min(x, MAX_VELOCITY));
    }

    public void setVelocityY(double y) {
        this.y = Math.max(-MAX_VELOCITY, Math.min(y, MAX_VELOCITY));
    }

    public void addVelocityX(double x) {
        this.setVelocityX(this.x + x);
    }

    public void addVelocityY(double y) {
        this.setVelocityY(this.y + y);
    }

    public double getVelocityX() {
        return x;
    }

    public double getVelocityY() {
        return y;
    }
}

