package school.faang.bjs2_82033_bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Game {
    private int livesToLoose;
    private int score = 0;
    private final Object livesLock = new Object();
    private final Object scoreLock = new Object();

    @Getter
    private boolean isOver;

    public Game(int livesToLoose) {
        this.livesToLoose = livesToLoose;
    }

    public void update() {
        boolean isSuccessAction = ThreadLocalRandom.current().nextBoolean();
        if (isSuccessAction) {
            gainScore();
        } else {
            looseLife();
        }
    }

    private void gameOver() {
        log.info("Enough lives lost, game over");
        isOver = true;
    }

    private void gainScore() {
        synchronized (scoreLock) {
            score++;
            log.info("Successful action, score = {}", score);
        }
    }

    private void looseLife() {
        synchronized (livesLock) {
            if (isOver) {
                log.info("Game over, action cancelled");
                return;
            }

            livesToLoose--;
            log.info("Bad action, lives remaining = {}", livesToLoose);
            if (livesToLoose <= 0) {
                gameOver();
            }
        }
    }
}
