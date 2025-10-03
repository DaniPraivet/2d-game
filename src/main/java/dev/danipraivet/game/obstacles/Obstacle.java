package dev.danipraivet.game.obstacles;

import java.awt.*;

public abstract class Obstacle implements Avoidable {
    protected int x,y;
    protected int width, height;
    protected int speed;
    protected int dx, dy;

    public Obstacle(int x, int y, int width, int height, int speed, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.x = dx;
        this.y = dy;
    }

    public void update() {
        x += dx * speed;
        y += dy * speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public boolean collision(Rectangle r) {
        return new Rectangle(x, y, width, height).intersects(r);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isOutOfBounds(int panelWidth, int panelHeight) {
        return x + width < 0 || x > panelWidth || y + height < 0 || y > panelHeight;
    }
}
