package game.windows;

import game.logic.Bird;
import game.logic.Pipe;
import game.main.Main;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameplayState extends State implements KeyListener {
    private BufferedImage buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
    private Bird bird;
    private ArrayList<Pipe> pipes = new ArrayList<>();

    public static int score;
    private boolean gameState;

    public GameplayState(){
        super();
        JFrame parentJFrame = Main.frame;
        parentJFrame.addKeyListener(this);
        parentJFrame.requestFocus();
        this.gameState = false;
        score = 0;

        bird = new Bird(50, 400);

        pipes.add(new Pipe(500, (float) (Math.random() * (575 - 225) + 225)));
        pipes.add(new Pipe(400 + 500, (float) (Math.random() * (575 - 225) + 225)));
        pipes.add(new Pipe(800 + 500, (float) (Math.random() * (575 - 225) + 225)));
        pipes.add(new Pipe(1200 + 500, (float) (Math.random() * (575 - 225) + 225)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D buffG = buffer.createGraphics();

        if(gameState)
            update();
        draw(buffG);

        g.drawImage(buffer, 0, 0, WIDTH, HEIGHT, null);

        try {
            Thread.sleep(33);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.repaint();
    }

    public void update(){
        bird.updateEntity();

        for (Pipe p : pipes) {
            p.updateEntity();
            checkIfCollided(p);
        }

    }

    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());


        for (Pipe p : pipes) {
            p.drawEntity(g);
        }

        bird.drawEntity(g);

        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.setColor(Color.WHITE);

        if (!gameState) {
            String startText = "Press space to start";
            g.drawString(startText, (WIDTH - g.getFontMetrics().stringWidth(startText)) / 2, HEIGHT / 2 );
        } else {
            g.drawString(String.valueOf(score), (WIDTH - g.getFontMetrics().stringWidth(String.valueOf(score))) / 2, 100);
        }

    }

    public void checkIfCollided(Pipe p){
        if(p.checkCollision(bird) || bird.getY() < 0 || bird.getY() + bird.getHEIGHT() > 800) {
            Main.setState(new GameOverState());
        }
        else if(!p.isScored() && p.getX() < bird.getX()){
            p.setScored(true);
            score++;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
            gameState = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
