package faang.school.godbless.sprint_3.multithreading.bro_force;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private Integer score = 0;
    private Integer lives = 7;
    private final Lock SCORE_LOCK = new ReentrantLock();
    private final Lock LIVES_LOCK = new ReentrantLock();

    public void update() {
        synchronized (SCORE_LOCK) {
            if (lives > 0) {
                lives -= 1;
            } else {
                gameOver();
                return;
            }
        }
        synchronized (LIVES_LOCK) {
            score += 1;
        }
    }


    private void gameOver() {
        System.out.println("Your score " + score);
        System.out.println("Game Over");
    }
}