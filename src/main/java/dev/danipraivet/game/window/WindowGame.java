package dev.danipraivet.game.window;

import javax.swing.*;

public class WindowGame extends JFrame {
    private static Menu menu;
    public static GamePanel PANEL;
    public static final int WINDOW_WIDTH = 1920;
    public static final int WINDOW_HEIGHT = 1080;

    public WindowGame() {
        setTitle("ChupiColasJuego");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        menu = new Menu(this);
        setContentPane(menu);

        setVisible(true);
    }
}
