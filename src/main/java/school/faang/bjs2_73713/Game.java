package school.faang.bjs2_73713;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Game {
    private int score = 0;
    private int hp = 10;
    private int winCondition = 10;
    private int deathCondition = 0;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock hpLock = new ReentrantLock();

    public void update(boolean hpChanged, boolean scoreChanged) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (hpChanged) {
            hpLock.lock();
            try {
                if (hp <= deathCondition) {
                    gameOver();
                }
                hp--;
                System.out.printf("Player lost 1 hp. %d hp remaining\n", hp);

            } finally {
                hpLock.unlock();
            }
        }

        if (scoreChanged) {
            scoreLock.lock();
            try {
                if (score >= winCondition) {
                    gameOver();
                }
                score++;
                System.out.printf("Player score changed. Current score = %d\n", score);

            } finally {
                scoreLock.unlock();
            }
        }
    }

    public void gameOver() {
        if (score >= winCondition) {
            System.out.println("Player won!");
        }
        if (hp <= deathCondition) {
            System.out.println("You Lost");
        }
        Thread.currentThread().interrupt();
    }
}

