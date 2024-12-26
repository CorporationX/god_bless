package school.faang.bjs249590;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private Long score;
    private Long lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameOver = false;

    public Game(Long lives, Long score) {
        this.lives = lives;
        this.score = score;
    }

    public void update(boolean earnedPoints, boolean lostLife) {
        if (isGameOver) {
            return;
        }

        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                log.info("Earned points! score: {}", score);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                log.info("Lost life! lives: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Game over! score: {}", score);
    }
}
