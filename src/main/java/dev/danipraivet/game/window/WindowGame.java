package dev.danipraivet.game.window;

import javax.swing.*;

public class WindowGame extends JFrame {
    private static GamePanel PANEL;
    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;

    public WindowGame() {
        PANEL = new GamePanel(this);
        setTitle("ChupiColasJuego");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(PANEL);
    }
}
