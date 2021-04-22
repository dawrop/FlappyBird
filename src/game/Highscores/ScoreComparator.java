package game.Highscores;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        int score1 = o1.getScore();
        int score2 = o2.getScore();

        return Integer.compare(score2, score1);
    }
}
