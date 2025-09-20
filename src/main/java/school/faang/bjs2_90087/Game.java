package school.faang.bjs2_90087;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    public int score = 0;
    public int lives;
    public boolean isGameInProgress = true;

    public Game(int lives) {
        this.lives = lives;
    }

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isScoreEarned, boolean isLiveLost) {
        synchronized (scoreLock) {
            if (isScoreEarned) {
                score++;
                log.info("Заработано одно очко, текущее количество общих очков: {}", score);
            }
        }
        synchronized (livesLock) {
            if (isLiveLost && lives > 0) {
                lives--;
                log.info("Жизни пользователей уменьшились на 1. Оставшиеся жизни: {}", lives);
            }
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Игра окончена");
        isGameInProgress = false;
    }
}
