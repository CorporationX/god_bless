package school.faang.task49580broforce;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Getter
@Setter
public class Game {
    Random random = new Random();
    private int score;
    private int lives;
    private List<Bro> bros = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();


    public void addBro(Bro bro) {
        bros.add(bro);
    }

    public boolean update() {
        int broIndex = random.nextInt(bros.size());
        Bro bro = bros.get(broIndex);
        boolean isAlive = bro.getAlive();

        if (!isAlive) {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                lives++;
                log.info(" {}  lives {} ", bro.getName(), bro.getLives());

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
        log.info(" Game over with score: {} ", score);
        log.info("Lost lives:  {} ", lives);
        return true;
    }

}
