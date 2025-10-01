package dev.danipraivet.game.window;

import dev.danipraivet.game.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel {
    private static final int FPS = 60;
    private static boolean RUNNING = true;

    public Player getPlayer() {
        return player;
    }

    private final Player player;

    public GamePanel(JFrame frame) {
        setBackground(Color.BLACK);
        setSize(frame.getSize());

        setVisible(true);
        setFocusable(true);

        player = new Player(0,0, new Color(255, 0, 0, 0));

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

    public void updateGamePanel() {
        player.update();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        try {
            player.draw(g2d);
        } catch (Exception e) {
            System.out.println("Error during paint");
        }
    }
}
