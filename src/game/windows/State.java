package game.windows;

import javax.swing.*;
import java.awt.*;

public abstract class State extends JPanel {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public State(){
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setTitleAppearance(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setBounds(150,50,300, 50);
    }


}
