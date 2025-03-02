package bjs2_61639;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives;

    private final Object scoreLocker = new Object();
    private final Object livesLocker = new Object();

    @Getter
    private boolean isGameOver = false;

    public Game(int lives) {
        this.lives = lives;
    }

    public boolean update(boolean isScoreIncremented, boolean isLiveLost) {
        if (isScoreIncremented) {
            synchronized (scoreLocker) {
                score++;
                log.info("Очки увеличены. Текущий счёт: {}", score);
            }
        }

        if (isLiveLost && !isGameOver) {
            synchronized (livesLocker) {
                lives--;
                log.info("Жизнь потеряна. Осталось: {}", lives);
                if (lives == 0) {
                    gameOver();
                    return false;
                }
            }
        }

        return true;
    }

    private void gameOver() {
        isGameOver = true;
        log.info("Игра закончена");
    }
}
