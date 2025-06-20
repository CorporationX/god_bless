package school.faang.forcebro;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    @Getter
    private boolean isGameOver = false;
    private final Object scoreSynchronized = new Object();
    private final Object livesSynchronized = new Object();
    private int score = 0;
    private int lives = 10;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        synchronized (scoreSynchronized) {
            if (isPointsEarned) {
                try {
                    score++;
                    log.info("Очки увеличены, текущий счёт: {}", score);
                } finally {
                    scoreSynchronized.notifyAll();
                }
            }
        }

        synchronized (livesSynchronized) {
            if (isLifeLost) {
                try {
                    if (lives <= 0) {
                        gameOver();
                        return;
                    }
                    lives--;
                    log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                } finally {
                    livesSynchronized.notifyAll();
                }
            }
        }
    }

    private void gameOver() {
        this.isGameOver = true;
        log.info("Игра окончена");
    }

}
