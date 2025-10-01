package dev.danipraivet.game.window.controls;

import dev.danipraivet.game.window.Menu;
import dev.danipraivet.game.window.WindowGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public abstract class ShowControls extends JPanel {
    private Menu menu;

    public ShowControls(WindowGame wg, Menu menu) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0x131313));

        JLabel controlsTitle = new JLabel("Controls");
        controlsTitle.setForeground(Color.WHITE);

        JButton bReturn = createButton("Return", Color.GRAY);
        bReturn.addActionListener(e -> {wg.showMenu();});

        JTextArea controls = new JTextArea("""
                Movement:
                    Move up: W
                    Move left: A
                    Move down: S
                    Move right: D
                """);
        controls.setEditable(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 15, 15, 15);

        c.gridx = 0;
        c.gridy = 1;
        add(controlsTitle, c);

        c.gridy = 2;
        add(controls, c);

        c.gridy = 3;
        add(bReturn, c);
    }

    private JButton createButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setPreferredSize(new Dimension(300, 80));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {button.setBackground(bgColor.darker());}
            public void mouseExited(MouseEvent e) {button.setBackground(bgColor);}
        });
        return button;
    }
}
