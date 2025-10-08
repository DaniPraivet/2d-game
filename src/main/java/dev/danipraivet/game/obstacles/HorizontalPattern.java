package dev.danipraivet.game.obstacles;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HorizontalPattern extends Obstacle {
    private final List<Rectangle> blocks = new ArrayList<>();
    private final int blockCount = 4;

    public HorizontalPattern(int startX, int startY, int blockSize, int initialSpeed, int dx) {
        super(startX, startY, blockSize, blockSize, initialSpeed, dx, 0);

        for (int i = 0; i < blockCount; i++) {
            blocks.add(new Rectangle(x + (blockSize + 10) * i, startY, blockSize, blockSize));
        }
    }

    @Override
    public void move(int dx, int dy) {

    }

    @Override
    public void update() {
        for (Rectangle block : blocks) {
            block.x += dx * speed;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for (Rectangle block : blocks) {
            g.fillRect(block.x, block.y, block.width, block.height);
        }
    }

    @Override
    public boolean collision(Rectangle r) {
        for (Rectangle block : blocks) {
            if (block.intersects(r)) return true;
        }
        return false;
    }

    @Override
    public boolean isOutOfBounds(int panelWidth, int panelHeight) {
        for (Rectangle block : blocks) {
            if (block.x + block.width > 0 && block.x + block.width < panelWidth)
                return false;
        }
        return true;
    }

}
