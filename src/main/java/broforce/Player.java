package broforce;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Player {
    private final String name;
    private int lives;
    private int score = 0;

    public Player(@NonNull String name, int lives) {
        this.name = name;
        this.lives = lives;
    }

    public void addScore(int scoreToAdd) {
        score += scoreToAdd;
        System.out.printf("%s get %d score%n", name, scoreToAdd);
    }

    public void reduceLives() {
        lives--;
        System.out.printf("%s lost live! %d remining%n", name, lives);
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
