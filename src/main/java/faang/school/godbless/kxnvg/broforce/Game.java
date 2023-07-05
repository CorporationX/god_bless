package faang.school.godbless.kxnvg.broforce;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {

    private int score;
    private int lives;
    private Lock scoreLock;
    private Lock livesLock;

    public Game() {
        score = 0;
        lives = 3;
        scoreLock = new ReentrantLock();
        livesLock = new ReentrantLock();
    }

    public boolean update(boolean isRiseScore) {
        if (isRiseScore) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Общее количество очков увеличено на 1. Итого: " + score);
            }
        } else {
            synchronized (livesLock) {
                lives--;
                System.out.println("Колличество жизней уменьшено на 1. Итого: " + lives);
                if (lives <= 0) {
                    gameOver();
                    return false;
                }
            }
        }
        return true;
    }

    private void gameOver() {
        System.out.println("===   Игра завершена   ===");
    }
}
