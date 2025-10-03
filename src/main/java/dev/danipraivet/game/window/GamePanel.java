package dev.danipraivet.game.window;

import dev.danipraivet.game.ControllerGame;
import dev.danipraivet.game.entities.Player;
import dev.danipraivet.game.obstacles.BasicObstacle;
import dev.danipraivet.game.obstacles.Obstacle;
import dev.danipraivet.game.obstacles.WaveObstacle;
import dev.danipraivet.game.obstacles.ZigZagObstacle;

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

    private void initObstacles() {
        obstacles.add(new WaveObstacle(100,50,30,30,2, 1, 0));
        obstacles.add(new ZigZagObstacle(200,150,40,40,3, -1, 0));
    }

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

        initObstacles();

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

        if (panelWidth <= 0 || panelHeight <= 0) return;

        int size = 30;
        int speed = 2;

        int x, y, dx = 0, dy = 0;
        boolean valid = false;

        Rectangle safeZone = new Rectangle(
                (int) player.getX() - SAFE_RADIUS,
                (int) player.getY() - SAFE_RADIUS,
                SAFE_RADIUS * 2,
                SAFE_RADIUS * 2
        );

        while (!valid) {
            int edge = (int)(Math.random() * 4);

            switch (edge) {
                case 0 -> { // left edge
                    x = 0;
                    y = (int) (Math.random() * panelHeight);
                    dx = 1;
                    dy = 0;
                }
                case 1 -> { // right edge
                    x = panelWidth - size;
                    y = (int) (Math.random() * panelHeight);
                    dx = -1; dy = 0;
                }
                case 2 -> { // top edge
                    x = (int)(Math.random() * panelWidth);
                    y = 0;
                    dx = 0; dy = 1;
                }
                default -> { // bottom edge
                    x = (int)(Math.random() * panelWidth);
                    y = panelHeight - size;
                    dx = 0; dy = -1;
                }
        }
        Rectangle obstacle = new Rectangle(x, y, size, size);

            if (!safeZone.intersects(obstacle)) {
                valid = true;
                obstacles.add(new BasicObstacle(x,y,size,size,speed,dx, dy));
            }
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
