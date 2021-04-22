package game.main;

import game.windows.MenuState;
import game.windows.State;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final JFrame frame = new JFrame("Flappy Bird");

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setSize(State.WIDTH, State.HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setState(new MenuState());
    }

    public static void setState(State s){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(s);
        frame.getContentPane().revalidate();
    }
}
