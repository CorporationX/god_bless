package school.faang.bjs273609;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private static final int MAX_LIVES = 10;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private int score = 0;
    private int lives = 0;
    private volatile boolean gameOver = false;


    public void update(boolean winner, boolean loose) {
        synchronized (lockScore) {
            if (gameOver) {
                return;
            }
            if (winner) {
                score++;
                System.out.printf("Score was increased by %d (%s)\n", score, Thread.currentThread().getName());
            }
            if (loose) {
                lives++;
                System.out.printf("Life lost, total lives lost: %d (%s)\n", lives, Thread.currentThread().getName());
                if (lives == MAX_LIVES) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        this.gameOver = true;
        System.out.println("GAME OVER");
    }
}