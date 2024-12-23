package school.faang.sprint3.bjs_49320;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Game {
    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        this.score = 0;
        this.lives = lives;
    }

    public void update(boolean isScorePointGot, boolean isLivePointLost) {
        synchronized (scoreLock) {
            if (isScorePointGot) {
                score++;
                log.info("Получено 1 очко. Текущий счет: {} очков", score);
            }
        }

        synchronized (livesLock) {
            if (isLivePointLost) {
                lives--;
                log.info("Вы потеряли 1 жизнь. Осталось жизней: {}", lives);
            }

            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Конец игры. Вы набрали: {} очков", score);
    }
}
