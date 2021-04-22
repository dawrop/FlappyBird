import game.Highscores.Score;
import game.Highscores.ScoreComparator;
import game.logic.Bird;
import game.logic.Pipe;

import static org.junit.Assert.*;

public class Test {


    @org.junit.Test
    public void compareTest() {
        ScoreComparator scoreComparator = new ScoreComparator();
        Score sc1 = new Score("player1", 15);
        Score sc2 = new Score("player2", 10);

        int result = scoreComparator.compare(sc1, sc2);

        assertTrue(result == -1);
    }

    @org.junit.Test
    public void checkCollisionTest() {
        Bird bird = new Bird(100, 100);
        Pipe pipe1 = new Pipe(100, 400);
        Pipe pipe2 = new Pipe(100, 100);

        boolean result1 = pipe1.checkCollision(bird);
        boolean result2 = pipe2.checkCollision(bird);

        assertTrue(result1);
        assertFalse(result2);
    }

    @org.junit.Test
    public void updatePipe() {
        // x -=  SPEED * 0.033;     100 -= 300 * 0.033
        Pipe pipe = new Pipe(100, 400);
        pipe.updateEntity();

        int x = (int)pipe.getX();

        assertEquals(90, x);
    }

    @org.junit.Test
    public void updateBird() {
        // yVelocity += gravity * 0.033;    0 += 1500 * 0.033
        // y += yVelocity * 0.033;          400 += 49.5 * 0.033
        Bird bird = new Bird(50, 400);

        bird.updateEntity();

        int y = (int)bird.getY();
        assertEquals(401, y);
    }
}