package faang.school.godbless.broForce;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score;
    private int lives;

    public Game(int initialLives) {
        this.score = 0;
        this.lives = initialLives;
    }

    public void update() {
        synchronized (scoreLock) {
            if (lives > 0) {
                score++;
            }
        }

        synchronized (livesLock) {
            if (lives > 0) {
                lives--;
            } else {
                gameOver();
            }
        }
    }

    void gameOver() {
        System.out.println("Game Over");
    }
}
