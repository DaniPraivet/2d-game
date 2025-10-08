package dev.danipraivet.game.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HorizontalPattern extends Obstacle {
    private final List<Rectangle> cubes = new ArrayList<>();
    private final int panelWidth;
    private final int panelHeight;

    public HorizontalPattern(int panelWidth, int panelHeight, int size, int speed) {
        // Dummy initial position (not used directly)
        super(0, 0, size, size, speed, 0, 0);

        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;

        // top cube (left side → right)
        cubes.add(new Rectangle(0 - size, size, size, size));

        // middle cube (right side → left)
        cubes.add(new Rectangle(panelWidth, panelHeight / 2 - size / 2, size, size));

        // bottom cube (left side → right)
        cubes.add(new Rectangle(0 - size, panelHeight - size * 2, size, size));
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        // Move top and bottom cubes right, center cube left
        for (int i = 0; i < cubes.size(); i++) {
            Rectangle c = cubes.get(i);
            if (i == 1) { // middle one
                c.x -= speed;
            } else {
                c.x += speed;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for (Rectangle c : cubes) {
            g.fillRect(c.x, c.y, c.width, c.height);
        }
    }

    @Override
    public boolean collision(Rectangle r) {
        for (Rectangle c : cubes) {
            if (c.intersects(r)) return true;
        }
        return false;
    }

    @Override
    public boolean isOutOfBounds(int panelWidth, int panelHeight) {
        // All cubes have exited the screen
        boolean allOffScreen = true;
        for (Rectangle c : cubes) {
            if (c.x + c.width >= 0 && c.x <= panelWidth) {
                allOffScreen = false;
                break;
            }
        }
        return allOffScreen;
    }

}
