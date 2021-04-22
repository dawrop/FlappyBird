package game.Highscores;

import java.io.Serializable;

public class Score implements Serializable {
    private final int score;
    private final String nickname;

    public Score(String nickname, int score) {
        this.score = score;
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }
}
