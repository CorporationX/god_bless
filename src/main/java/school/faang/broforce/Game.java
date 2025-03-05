package school.faang.broforce;

import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private int score = 0;
    private int lives = 10;
    private boolean isGameOver = false;

    private final ReentrantLock scoreLock = new ReentrantLock();
    private final ReentrantLock livesLock = new ReentrantLock();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }

        if (isPointsEarned) {
            scoreLock.lock();
            try {
                if (!isGameOver) {
                    score++;
                    System.out.println("Очки увеличены, текущий счёт: " + score);
                }
            } finally {
                scoreLock.unlock();
            }
        }

        if (isLifeLost) {
            livesLock.lock();
            try {
                if (lives > 0) {
                    lives--;
                    System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Игра окончена! Все жизни потеряны.");
    }
}