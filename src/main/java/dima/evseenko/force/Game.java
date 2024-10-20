package dima.evseenko.force;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString(of = {"score", "lives"})
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score;
    private int lives;

    public void update(boolean addScore, boolean lostLive) {
        if (!isGameOver()) {
            synchronized (scoreLock) {
                if (addScore) {
                    score++;
                }
            }

            synchronized (livesLock) {
                if (lostLive) {
                    lives--;
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }

            System.out.printf("New update, score: %s lives: %s%n", score, lives);
        }
    }

    public boolean isGameOver() {
        return lives <= 0;
    }

    private void gameOver() {
        System.out.println("Game Over");
    }
}
