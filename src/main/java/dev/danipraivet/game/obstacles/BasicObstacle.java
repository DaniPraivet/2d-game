package dev.danipraivet.game.obstacles;

public class BasicObstacle extends Obstacle {
    public BasicObstacle(int x, int y, int width, int height, int speed, int dx, int dy) {
        super(x, y, width, height, speed, dx, dy);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx *  speed;
        y += dy *  speed;
    }
}
