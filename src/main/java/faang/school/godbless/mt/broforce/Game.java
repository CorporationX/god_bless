package faang.school.godbless.mt.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    @Getter
    private boolean isOver = false;
    private int scores = 0;
    private int lives = 5;

    public void update(boolean newScore, boolean lostLive) {
        synchronized (scoreLock) {
            if (newScore) {
                scores++;
                log.info("Add score. Scores = {}", scores);
            }
        }

        synchronized (liveLock) {
            if (lostLive) {
                lives--;
                log.info("Loss live. Lives = {}", lives);
            }
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        isOver = true;
        log.info("Game over");
    }
}
