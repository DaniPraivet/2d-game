package dev.danipraivet.game.window;

import dev.danipraivet.game.ControllerGame;
import dev.danipraivet.game.window.controls.PlayerControls;

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

    public void start() {
        PANEL = new GamePanel(this);
        setContentPane(PANEL);
        addKeyListener(new ControllerGame());
        revalidate();
        repaint();
        PANEL.requestFocus();
        setFocusable(true);
        requestFocusInWindow();
    }

    public void showMenu() {
        menu = new Menu(this);
        setContentPane(menu);
        setVisible(true);
    }

    public void showControls() {
        PlayerControls pc = new PlayerControls(this, menu);
        setVisible(true);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        tabbedPane.addTab("Player", pc);
        setContentPane(tabbedPane);
    }
}
