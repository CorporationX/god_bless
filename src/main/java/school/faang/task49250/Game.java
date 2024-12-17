package school.faang.task49250;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private int score = 0;
    @Getter
    private int lives = 5;

    public void update(boolean earnedScore, boolean losingLive) {
        synchronized (lock1) {
            if (earnedScore && lives != 0) {
                score++;
                log.info("Игрок заработал очки, очки на данный момент {}", score);
            }
        }

        synchronized (lock2) {
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
        log.info("Игра окончена");
    }
}
