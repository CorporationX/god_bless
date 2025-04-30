package src.faang.BJS2_73697;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    private int lives;
    private int score;

    public Player(String name, int lives, int score) {
        this.name = name;
        this.lives = lives;
        this.score = score;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void decreaseLives() {
        lives--;
    }
}

