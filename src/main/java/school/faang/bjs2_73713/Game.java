package school.faang.bjs2_73713;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Game {
    private int score = 0;
    private int hp = 10;
    private int winCondition = 10;
    private int deathCondition = 0;
    private AtomicBoolean gameOver = new AtomicBoolean(false);
    private final Lock scoreLock = new ReentrantLock();
    private final Lock hpLock = new ReentrantLock();

    public void update(boolean hpChanged, boolean scoreChanged) {
        if (gameOver.get()) {
            return;
        }
        if (hpChanged) {
            hpLock.lock();
            try {
                hp--;
                System.out.printf("Player lost 1 hp. %d hp remaining\n", hp);
                if (hp <= deathCondition) {
                    if (gameOver.compareAndSet(false, true)) {
                        System.out.println("You died!");
                    }
                    return;
                }
            } finally {
                hpLock.unlock();
            }
        }
        if (scoreChanged) {
            scoreLock.lock();
            try {
                score++;
                System.out.printf("Player score changed. Current score = %d\n", score);
                if (score >= winCondition) {
                    if (gameOver.compareAndSet(false, true)) {
                        System.out.println("You won!");
                    }
                    return;
                }
            } finally {
                scoreLock.unlock();
            }
        }
    }
}