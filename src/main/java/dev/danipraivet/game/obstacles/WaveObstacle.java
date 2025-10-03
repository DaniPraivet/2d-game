package dev.danipraivet.game.obstacles;

public class WaveObstacle extends Obstacle {
    private int baseY;
    private double angle = 0;

    public WaveObstacle(int x, int y, int width, int height, int speed, int dx,int dy) {
        super(x, y, width, height, speed, dx, dy);
        this.baseY = y;
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        x -= speed;
        y -= speed;

        angle += 0.1;
        y = baseY + (int)(Math.sin(angle) * 20);
    }
}
