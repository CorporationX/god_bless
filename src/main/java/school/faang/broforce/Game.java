package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean isPointsEarned, boolean isLifeLost) {

        synchronized (scoreLock) {
            if (lives >= 0) {
                if (isPointsEarned) {

                    score++;
                    log.info("Очки увеличены! текущий счет : {}", score);

                }
            } else {
                log.error("Не удалось зачислить очки! Так как у вас нет жизний!");
            }
        }

        if (isLifeLost) {
            synchronized (livesLock) {
                lives--;
                log.info("Жизни уменьшены, оставшиеся жизни: {}", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public static void gameOver() {
        log.info("Игра окончена! Все жизни потеряны.");
    }

}