package faang.school.BroForce;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Game {
    private int score = 0;
    private int lives = 3;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();

    public void update() {
        scoreLock.lock();
        livesLock.lock();
        if (lives > 0) {
            score++;
            lives--;
            System.out.println("Update");
        }
        if (lives == 0) {
            gameOver();
        }
        scoreLock.unlock();
        livesLock.unlock();
    }

    private void gameOver() {
        score = 0;
        System.out.println("Game Over!");
    }
}
