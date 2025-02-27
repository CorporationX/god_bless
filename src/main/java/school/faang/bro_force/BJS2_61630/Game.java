package school.faang.bro_force.BJS2_61630;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

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
                log.info("{} lives left: {}", bro.getName(), bro.getLives());
                if (bro.getLives() == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        synchronized (livesLock) {
            if (!isTheGameOver) {
                log.info("Game over");
                isTheGameOver = true;
            }
        }
    }
}
