package game.windows;

import game.main.Main;
import game.main.OwnButton;

import javax.swing.*;

public class MenuState extends State {
    private JLabel title = new JLabel("Flappy Bird 2.0");
    private OwnButton start = new OwnButton("START");
    private OwnButton hScores = new OwnButton("HIGHSCORES");
    private OwnButton exit = new OwnButton("EXIT");

    public MenuState(){
        super();

        this.add(Box.createVerticalStrut(100));

        this.add(title);
        setTitleAppearance(title);

        this.add(Box.createVerticalGlue());

        this.add(start);
        start.addActionListener(e -> {
            Main.setState(new GameplayState());
        });

        this.add(Box.createVerticalStrut(50));

        this.add(hScores);
        hScores.addActionListener(e -> {
            Main.setState(new HighscoreState());
        });

        this.add(Box.createVerticalStrut(50));

        this.add(exit);
        exit.addActionListener(e -> {
            System.exit(0);
        });

        this.add(Box.createVerticalGlue());
    }
}