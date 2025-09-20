package school.faang.multithreading.sinchronized.bjs2_90079;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private static final int COUNT_LIVES = 3;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    private int score = 0;
    private int lives = COUNT_LIVES;


    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (isPointsEarned) {
            synchronized (lockScore) {
                score++;
                log.info("Очки увеличены, общий счет = {}", score);
            }
        }

        if (isLifeLost) {
            synchronized (lockLives) {
                lives--;
                log.info("Количество жизней сократилось на 1, осталось {}", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game over. Score = {}", score);
    }
}
