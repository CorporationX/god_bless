package school.faang.BJS2_61703;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Game {

    private int score;
    private int lives = 3;
    private final Object countScores = new Object();
    private final Object countLives = new Object();
    private boolean isGameOver = false;

    public void update() {
        synchronized (countScores) {
            if (!isGameOver()) {
                score++;
                log.info("Игрок набрал очки. Сумма набранных очков {}", getScore());
            }
        }

        synchronized (countLives) {
            if (getLives() <= 0) {
                if (!isGameOver) {
                    isGameOver = true;
                    gameOver();
                }
                return;
            }
            lives--;
            log.info("Игрок потерял жизнь, осталось {} жизней", getLives());
        }
    }

    private void gameOver() {
        log.info("Игра закончена, Количество очков за игру {}", getScore());
    }
}
