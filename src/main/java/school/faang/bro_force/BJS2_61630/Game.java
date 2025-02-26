package school.faang.bro_force.BJS2_61630;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class);

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Object GameOverLock = new Object();

    private final List<Bro> bros = new ArrayList<>();
    private int score;
    private int lives;
    private boolean isTheGameOver = false;

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public void update() {
        int broIndex = new Random().nextInt(bros.size());
        Bro bro = bros.get(broIndex);

        synchronized (scoreLock) {
            bro.setScore(bro.getScore() + 1);
            score++;
        }

        if (bro.isAlive()) {
            synchronized (livesLock) {
                if (isTheGameOver) {
                    return;
                }

                bro.setLives(bro.getLives() - 1);
                lives++;
                LOGGER.info("{} lives left: {}", bro.getName(), bro.getLives());
                if (bro.getLives() == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        LOGGER.info("Game over");
        isTheGameOver = true;
    }
}
