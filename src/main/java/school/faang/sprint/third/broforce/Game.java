package school.faang.sprint.third.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 300;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(int earnedScores, int loseLives) {
        synchronized (scoreLock) {
            if (lives == 0) {
                log.info("Game over, scores not earned");
                return;
            }
            score += earnedScores;
        }

        synchronized (livesLock) {
            if (lives == 0) {
                log.info("Game already done");
                return;
            }

            lives -= loseLives;
            if (lives <= 0) {
                lives = 0;
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Game Over, total score is {}", score);
    }
}
