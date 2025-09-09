package dev.danipraivet.game.window;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final int FPS = 60;
    private static boolean RUNNING = true;

    public GamePanel(JFrame frame) {
        setBackground(Color.BLACK);
        setSize(frame.getSize());

        setVisible(true);
        setFocusable(true);
    }
}
