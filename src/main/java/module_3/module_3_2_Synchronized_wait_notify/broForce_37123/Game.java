package module_3.module_3_2_Synchronized_wait_notify.broForce_37123;

import lombok.Data;

@Data
public class Game {
    private int score = 0;
    private int lives;
    private int scoreToWin;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives, int scoreToWin) {
        this.lives = lives;
        this.scoreToWin = scoreToWin;
    }

    public void update(boolean isScoredPoints, boolean lostLives) {
        synchronized (scoreLock) {
            if (isScoredPoints) {
                ++score;
                System.out.println("Игрок получает 1 очко! Итого: " + this.score);
            }
            if (score >=  scoreToWin) {
                gameOver();
            }
        }
        synchronized (livesLock) {
            if (lostLives) {
                --lives;
                System.out.println("Игрок потратил 1 жизнь! Осталось: " + this.lives);
            }
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private synchronized void gameOver() {
        if (lives <= 0) {
            System.out.println("Игрок потерял все жизни! Игрок проиграл.");
        }else {
            System.out.println("Игрок выиграл!");
        }
        System.exit(0);
    }
}
