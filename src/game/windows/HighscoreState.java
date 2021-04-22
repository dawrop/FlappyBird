package game.windows;

import game.Highscores.HighscoreManager;
import game.main.Main;
import game.main.OwnButton;

import javax.swing.*;
import java.awt.*;

public class HighscoreState extends State {
    private JLabel pageTitle = new JLabel("HIGHSCORES");
    private OwnButton mainMenu = new OwnButton("MAIN MENU");

    private HighscoreManager highscoreManager = new HighscoreManager();

    private JPanel[] list = new JPanel[10];
    private JLabel[] highscorePosition = new JLabel[10];
    private JLabel[] highscoreNickname = new JLabel[10];
    private JLabel[] highscoreScore = new JLabel[10];

    public HighscoreState(){
        super();

        this.add(Box.createVerticalStrut(25));

        this.add(pageTitle);
        setTitleAppearance(pageTitle);

        this.add(Box.createVerticalGlue());

        int pos = highscoreManager.getScores().size();
        if (pos > 10) {
            pos = 10;
        }

        for (int i = 0; i < pos; i++) {

            list[i] = new JPanel(new GridLayout(1, 3));

            highscorePosition[i] = new JLabel(String.valueOf(i + 1));
            highscoreNickname[i] = new JLabel(highscoreManager.getScores().get(i).getNickname());
            highscoreScore[i] = new JLabel(String.valueOf(highscoreManager.getScores().get(i).getScore()));

            this.add(list[i]);
            list[i].setBackground(Color.BLACK);

            list[i].add(highscorePosition[i]);
            list[i].add(highscoreNickname[i]);
            list[i].add(highscoreScore[i]);

            setTitleAppearance(highscorePosition[i]);
            setTitleAppearance(highscoreNickname[i]);
            setTitleAppearance(highscoreScore[i]);
        }

        this.add(Box.createVerticalStrut(25));

        this.add(mainMenu);
        mainMenu.addActionListener(e -> {
            Main.setState(new MenuState());
        });

        this.add(Box.createVerticalGlue());
    }
}
