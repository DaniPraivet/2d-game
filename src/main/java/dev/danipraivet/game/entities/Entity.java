package dev.danipraivet.game.entities;

import dev.danipraivet.game.math.Velocity;
import dev.danipraivet.game.window.WindowGame;

import java.awt.*;

public abstract class Entity implements Character{
    private static int WIDTH = 40;
    private static int HEIGHT = 40;
    protected double x;
    protected double y;
    protected Color color;
    protected int hp = 80;
    protected Rectangle hitbox;
    private boolean showHitbox = false;
    protected Velocity velocity;
    Image sprite;

    static {
        calculateEntitySize(WindowGame.WINDOW_WIDTH, WindowGame.WINDOW_HEIGHT);
    }

    public Entity(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        velocity = new Velocity(x, y);
        hitbox = new Rectangle(WIDTH, HEIGHT);
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Entity.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Entity.HEIGHT = HEIGHT;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isShowHitbox() {
        return showHitbox;
    }

    public void setShowHitbox(boolean showHitbox) {
        this.showHitbox = showHitbox;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void update() {
        velocity.update(this);
    }

    public static void calculateEntitySize(int w, int h) {
        int windowDefaultWidth = 1280;
        int windowDefaultHeight = 720;

        WIDTH = (WIDTH * w) / windowDefaultWidth;
        HEIGHT = (HEIGHT * h) / windowDefaultHeight;
    }

    public void draw(Graphics2D g) {
        if (sprite != null) {
            g.drawImage(sprite,(int) x, (int) y, WIDTH, HEIGHT, null);
        } else {
            g.setColor(color);
            g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
        }
    }
}
