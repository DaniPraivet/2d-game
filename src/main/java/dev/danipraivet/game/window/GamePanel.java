package dev.danipraivet.game.window;

import dev.danipraivet.game.ControllerGame;
import dev.danipraivet.game.entities.Player;
import dev.danipraivet.game.obstacles.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel {
    private static final int FPS = 60;
    private static boolean RUNNING = true;
    private final List<Obstacle> obstacles = new ArrayList<>();
    private static final int SAFE_RADIUS = 100;

    public Player getPlayer() {
        return player;
    }

    private final Player player;

    public GamePanel(JFrame frame) {
        setBackground(Color.BLACK);
        setSize(frame.getSize());

        setVisible(true);
        setFocusable(true);

        player = new Player(0, 0);

        new Thread(()->{
            while (RUNNING) {
                long time = System.currentTimeMillis();
                updateGamePanel();
                repaint();

                long elapsed = System.currentTimeMillis() - time;
                long frameTime = 1000 / FPS;
                long sleepTime = frameTime - elapsed;

                try {
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                } catch (InterruptedException e) {
                    System.out.println("Error during frame generation.");
                }
            }
        }).start();
    }

    private void displayUIGamePanel(Graphics2D g) {
        // Blank rn
    }

    private void spawnObstacle() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Rectangle safeZone = new Rectangle(
                (int) player.getX() - SAFE_RADIUS,
                (int) player.getY() - SAFE_RADIUS,
                SAFE_RADIUS * 2,
                SAFE_RADIUS * 2
        );

        boolean valid = false;
        int x = 0, y = 0;
        while (!valid) {
            x = (int) (Math.random() * panelWidth);
            y = (int) (Math.random() * panelHeight);
            Rectangle obstacleArea = new Rectangle(x, y, 80, 80);
            valid = !safeZone.intersects(obstacleArea);
        }

        int pattern = (int) (Math.random() * 3);
        switch (pattern) {
            case 0 -> obstacles.add(new HorizontalPattern(getWidth(), getHeight(), 60, 4));
            case 1 -> obstacles.add(new WavePattern(x, y, 2, Math.random() < 0.5 ? 1 : -1, 0));
            case 2 -> obstacles.add(new ZigZagPattern(x, y, 2, Math.random() < 0.5 ? 1 : -1));
        }
    }

    public void updateGamePanel() {
        player.update();
        ControllerGame.update();
        for (Obstacle o : obstacles) {
            o.update();
            if (o.collision(player.getHitbox())) {
                System.out.println("Collision");
            }
        }
        obstacles.removeIf(o -> o.isOutOfBounds(getWidth(), getHeight()));

        while (obstacles.size() < 5) {
            spawnObstacle();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            player.draw(g2d);
            for (Obstacle o : obstacles) {
                o.draw(g2d);
            }
        } catch (Exception e) {
            System.out.println("Error during paint");
        }
    }
}
