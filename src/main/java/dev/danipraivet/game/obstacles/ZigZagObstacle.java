package dev.danipraivet.game.obstacles;

public class ZigZagObstacle extends Obstacle {
    private int direction = 1;

    public ZigZagObstacle(int x, int y, int width, int height, int speed, int dx, int dy) {
        super(x, y, width, height, speed, dx, dy);
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        x -= dx * speed;
        y -= dy * speed;

        y += 3 * direction;
        if (y < 0 || y > 400) {
            direction *= -1;
        }
    }
}
