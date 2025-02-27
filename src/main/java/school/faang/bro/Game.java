package school.faang.bro;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private int score = 0;
    private int lives = 5;

    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            scoreLock.lock();
            try {
                score++;
                System.out.printf("Points increased, current score: %d%n", score);
            } finally {
                scoreLock.unlock();
            }
        }

        if (isLifeLost) {
            livesLock.lock();
            try {
                lives--;
                System.out.printf("Lives reduced, lives left: %d%n", lives);
                if (lives <= 0) {
                    gameOver();
                }
            } finally {
                livesLock.unlock();
            }
        }
    }

    private void gameOver() {
        System.out.printf("The game is over. There are no lives left. %n");
    }
}
