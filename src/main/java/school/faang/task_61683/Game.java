package school.faang.task_61683;

import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final ReentrantLock scoreLock = new ReentrantLock();
    private final ReentrantLock livesLock = new ReentrantLock();
    private boolean isGameOver = false;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            scoreLock.lock();
            try {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            } finally {
                scoreLock.unlock();
            }
        }

        if (isLifeLost) {
            livesLock.lock();
            try {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра закончена! Все жизни потеряны.");
        isGameOver = true;
        score = 0;
        lives = 10;
    }
}
