package dev.danipraivet.game.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WavePattern extends Obstacle {
    private final List<Point> points = new ArrayList<>();
    private double angle = 0;

    public WavePattern(int startX, int startY, int speed, int dx, int dy) {
        super(startX, startY, 20, 20, speed, dx, dy);

        for (int i = 0; i < 6; i++) {
            points.add(new Point(startX + i * 25, startY));
        }
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        angle += 0.1;
        for (Point p : points) {
            p.x += dx * speed;
            p.y += dy * speed + (int)(Math.sin(angle + p.x * 0.05) * 2);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        for (Point p : points) {
            g.fillRect(p.x, p.y, width, height);
        }
    }

    @Override
    public boolean collision(Rectangle r) {
        for (Point p : points) {
            if (r.intersects(new Rectangle(p.x, p.y, width, height))) return true;
        }
        return false;
    }

    @Override
    public boolean isOutOfBounds(int panelWidth, int panelHeight) {
        for (Point p : points) {
            if (p.x + width > 0 && p.x < panelWidth && p.y + height > 0 && p.y < panelHeight)
                return false;
        }
        return true;
    }
}
