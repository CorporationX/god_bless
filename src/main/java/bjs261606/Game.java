package bjs261606;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@Slf4j
public class Game implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(Player strikerPlayer, Player attackedPlayer) {
        synchronized (scoreLock) {
            if (strikerPlayer.isScoreIncrement(attackedPlayer)) {
                score++;
                LOGGER.info("Common score: {}", score);
            }
        }
        synchronized (livesLock) {
            if (strikerPlayer.isPlayerKilled(attackedPlayer)) {
                lives--;
                LOGGER.info("Common lives: {}", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        LOGGER.info("All players killed");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
