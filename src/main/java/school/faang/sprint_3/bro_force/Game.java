package school.faang.sprint_3.bro_force;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@AllArgsConstructor
public class Game {
    private Integer score;
    private Integer lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final AtomicBoolean isGameOver = new AtomicBoolean(false);

    public void update(String updatePoint) {
        switch (updatePoint) {
            case "score" -> {
                synchronized (scoreLock) {
                    score++;
                    log.info("Score +1");
                }
            }
            case "lives" -> {
                synchronized (livesLock) {
                    lives--;
                    log.info("Lives -1");
                    if (lives <= 0 && isGameOver.compareAndSet(false, true)) {
                        log.info("Game over, final score: {}", score);
                    }
                }
            }
            default -> throw new IllegalArgumentException("Invalid update point");
        }
    }

    public boolean gameOver() {
        return isGameOver.get();
    }
}
