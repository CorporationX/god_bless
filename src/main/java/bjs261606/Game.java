package bjs261606;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
public class Game implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);
    private static int score = 0;
    private static int lives = 6;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(Player strikerPlayer, Player attackedPlayer) {
        synchronized (scoreLock) {
            if (strikerPlayer.isScoreIncrement(attackedPlayer)) {
                score++;
            }
            synchronized (livesLock) {
                if (strikerPlayer.isPlayerKilled(strikerPlayer, attackedPlayer)) {
                    lives--;
                    if (lives == 0) {
                        gameOver();
                    }
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
