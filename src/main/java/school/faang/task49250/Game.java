package school.faang.task49250;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();

    @Getter
    private int score = 0;
    @Getter
    private int lives = 5;

    public void update(boolean earnedScore, boolean losingLive) {
        synchronized (scoreLock) {
            if (earnedScore && lives != 0) {
                score++;
                log.info("Игрок заработал очки, очки на данный момент {}", score);
            }
        }

        synchronized (liveLock) {
            if (losingLive) {
                lives--;
                log.info("Игрок теряет жизнь");
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена. Финальный счёт: {}", score);
    }
}
