package dev.danipraivet.game.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Objects;

public class Menu  extends JPanel {
    public Menu(WindowGame wg) {
        Color bg = new Color(19,19,19);
        setLayout(new GridBagLayout());
        setBackground(bg);
        try {
            File fontFile = new File(Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("/Font/BigBlueTermPlusNerdFont-Regular.ttf")).getFile()));
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(44f);
            setFont(font);

            JButton bPlay = createButton("PLAY", bg, font);
            JButton bExit = createButton("EXIT", bg, font, new Color(220, 20, 60));
            JButton bControls = createButton("CONTROLS", bg, font);

            bExit.addActionListener(e -> System.exit(0));

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(15, 15, 15, 15);

            gbc.gridx = 0;
            gbc.gridy = 0;
            add(bPlay, gbc);

            gbc.gridy = 1;
            add(bControls, gbc);

            gbc.gridy = 2;
            add(bExit, gbc);

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private JButton createButton(String text, Color bgColor, Font font) {
        JButton b = new JButton(text);
        b.setFont(font);
        b.setBackground(bgColor);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b.setPreferredSize(new Dimension(300, 60));

        //Hover effect
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(bgColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(bgColor);
            }
        });
        return b;
    }

    private JButton createButton(String text, Color bgColor, Font font, Color hoverColor) {
        JButton b = new JButton(text);
        b.setFont(font);
        b.setBackground(bgColor);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        b.setPreferredSize(new Dimension(300, 60));

        //Hover effect
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(bgColor);
            }
        });
        return b;
    }
}
