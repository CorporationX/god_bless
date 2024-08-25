package faang.school.godbless.Bro_Force;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private boolean isDeath = false;

    public Game() {
        this.score = 0;
        this.lives = 0;
    }

    public void update() {
        while (lives != 5) {
            synchronized (scoreLock) {
                score += 1;
            }
            synchronized (liveLock) {
                lives++;
            }
        }
        if (lives == 5) {
            gameOver();
        }
    }

    private void gameOver() {
        synchronized (scoreLock) {
            synchronized (liveLock) {
                System.out.println("Game Over!");
                System.out.println("Final Score: " + score);
                System.out.println("Lives Lost: " + lives);
            }
        }
    }
}
