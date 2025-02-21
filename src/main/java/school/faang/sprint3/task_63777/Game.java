package school.faang.sprint3.task_63777;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives = 10;
    private boolean isGameOver;

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        synchronized (scoreLock) {
            if (isPointsEarned && !isGameOver) {
                score++;
                log.debug("Очки увеличены, текущий счёт: " + score);
            }
        }

        synchronized (livesLock) {
            if (isLifeLost && !isGameOver) {
                lives--;
                log.debug("Жизни уменьшены, оставшиеся жизни: " + lives);

                if (lives == 0) {
                    isGameOver = true;
                    log.debug("Game Over");
                }
            }
        }
    }
}