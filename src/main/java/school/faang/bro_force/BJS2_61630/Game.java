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

    private final List<Bro> bros = new ArrayList<>();
    private int score;
    private int lives;

    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = new Random().nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.isAlive();

        if (isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                LOGGER.info("{} lives left: {}", bro.getName(), bro.getLives());
                if (bro.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                bro.setScore(bro.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        LOGGER.info("Game over");
        return true;
    }
}
