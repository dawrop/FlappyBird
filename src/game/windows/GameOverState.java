package game.windows;

import game.Highscores.HighscoreManager;
import game.main.Main;
import game.main.OwnButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameOverState extends State {
    private JLabel pageTitle = new JLabel("GAME OVER");
    private JLabel scoreLabel = new JLabel("SCORE: " + GameplayState.score);
    private JTextField nameField = new JTextField("Nickname");
    private OwnButton submitButton = new OwnButton("SUBMIT");
    private HighscoreManager highscoreManager = new HighscoreManager();

    public GameOverState() {
        super();

        this.add(Box.createVerticalStrut(100));

        this.add(pageTitle);
        setTitleAppearance(pageTitle);

        this.add(Box.createVerticalGlue());

        this.add(scoreLabel);
        setTitleAppearance(scoreLabel);

        this.add(Box.createVerticalStrut(50));

        this.add(nameField);
        setNameFieldAppearance();
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(nameField.getText().length() >= 8)
                    e.consume();
                else if (!check(e.getKeyChar())){
                    e.consume();
                    infoBox("Wprowadzono nieprawidłowy znak!", "Błąd");
                }

            }
        });

        this.add(Box.createVerticalStrut(150));

        this.add(submitButton);
        submitButton.addActionListener(e -> {
            if (nameField.getText().equals("")) {
                infoBox("Podaj nazwę gracza!", "Błąd");
            }
            else {
                highscoreManager.addScore(nameField.getText(), GameplayState.score);
                Main.setState(new MenuState());
            }
        });

        this.add(Box.createVerticalGlue());
    }



    private void setNameFieldAppearance() {
        nameField.setBackground(Color.BLACK);
        nameField.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.WHITE));
        nameField.setFont(new Font("Arial", Font.ITALIC, 25));
        nameField.setForeground(Color.WHITE);
        nameField.setMaximumSize(new Dimension(200, 50));
    }

    private boolean check(char c) {
        return ((c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z') || (c >= '0' && c<= '9') || c == KeyEvent.VK_BACK_SPACE);
    }

    private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
    }
}