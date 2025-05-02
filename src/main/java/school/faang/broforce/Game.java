package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private volatile boolean isGameOver = false;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }

        if (isPointsEarned) {
            synchronized (scoreLock) {
                if (isGameOver) {
                    return;
                }
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                if (isGameOver) {
                    return;
                }
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        if (!isGameOver) {
            System.out.println("Game Over. Your scores: " + score);
            isGameOver = true;
        }
    }
}
