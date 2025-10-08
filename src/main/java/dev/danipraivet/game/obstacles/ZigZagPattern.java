package dev.danipraivet.game.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ZigZagPattern extends Obstacle {
    private final List<Point> blocks = new ArrayList<>();
    private int direction = 1;

    public ZigZagPattern(int startX, int startY, int speed, int dx) {
        super(startX, startY, 25, 25, speed, dx, 0);

        for (int i = 0; i < 5; i++) {
            blocks.add(new Point(startX + i * 30, startY + i * 30));
        }
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        for (Point p : blocks) {
            p.x += dx * speed;
            p.y += direction * 2;
        }

        if (blocks.get(0).y < 0 || blocks.get(0).y > 500) {
            direction *= -1;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        for (Point p : blocks) {
            g.fillRect(p.x, p.y, width, height);
        }
    }

    @Override
    public boolean collision(Rectangle r) {
        for (Point p : blocks) {
            if (r.intersects(new Rectangle(p.x, p.y, width, height))) return true;
        }
        return false;
    }

    @Override
    public boolean isOutOfBounds(int panelWidth, int panelHeight) {
        for (Point p : blocks) {
            if (p.x + width > 0 && p.x < panelWidth && p.y + height > 0 && p.y < panelHeight)
                return false;
        }
        return true;
    }
}
