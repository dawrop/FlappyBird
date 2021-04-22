package game.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OwnButton extends JButton {
    public OwnButton(String s){
        super(s);

        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setFont(new Font("Arial", Font.BOLD, 25));
        setForeground(Color.WHITE);
        setAlignmentX(CENTER_ALIGNMENT);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.GRAY);
                setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.WHITE);
                setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        });

        setMinimumSize(new Dimension(200, 50));
        setPreferredSize(new Dimension(200, 50));
        setMaximumSize(new Dimension(200, 50));
    }
}
