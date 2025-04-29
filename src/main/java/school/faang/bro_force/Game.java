package school.faang.bro_force;

import lombok.Data;

@Data
public class Game {
    private int score = 0;
    private int lives = 3;
    private volatile boolean gameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scored, boolean lostLife) {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (gameOver) {
                    return;
                }
                if (scored) {
                    score++;
                    System.out.println(Thread.currentThread().getName() + "increased score to " + score);
                }
                if (lostLife) {
                    lives--;
                    System.out.println(Thread.currentThread().getName() + "decreased lives to " + lives);
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        if (lives == 0) {
            gameOver = true;
        }
    }
}
