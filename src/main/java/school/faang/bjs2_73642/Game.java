package school.faang.bjs2_73642;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

    private static final Object LOCK_SCORE = new Object();
    private static final Object LOCK_LIVES = new Object();

    private static int score = 0;
    private static int lives = 10;

    public void update() {
        synchronized (LOCK_SCORE) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            score++;
        }
        synchronized (LOCK_LIVES) {
            lives--;
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Game has finished with score -> {}", score);
    }
}
