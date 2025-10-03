package dev.danipraivet.game.obstacles;

public interface Avoidable {
    void move(int dx, int dy);

    void update();
}
