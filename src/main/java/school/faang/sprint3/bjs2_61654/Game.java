package school.faang.sprint3.bjs2_61654;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives = 5;
    private final Object scoreLocker = new Object();
    private final Object livesLocker = new Object();


    public void update(boolean isScoreGot, boolean isLifeLost) {
        synchronized (scoreLocker) {
            if (isScoreGot) {
                score++;
                log.info(String.format("Выполнен удар, Ваше количество очков %d", getScore()));
            }
        }
        synchronized (livesLocker) {
            if (isLifeLost) {
                if (lives == 0) {
                    gameOver();
                }
                lives--;
                log.info(String.format("Пропущен удар, Ваше количество жизней %d", getLives()));
            }
        }
    }

    private void gameOver() {
        log.info("Потрачено");
    }
}
