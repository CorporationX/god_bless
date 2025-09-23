package school.faang.m3_2_synchronized.broforce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Game {
    private int score;
    private final Object scoreLock = new Object();
    private int lives;
    private final Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            synchronized (scoreLock) {
                score++;
                log.info("Счет увеличен, итого: {}", score);
            }
        }
        if (lostLife) {
            synchronized (livesLock) {
                if (lives <= 0) {
                    gameOver();
                } else {
                    lives--;
                    log.info("Уровень жизни уменьшен, итого: {}", lives);
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game over!");
    }
}
