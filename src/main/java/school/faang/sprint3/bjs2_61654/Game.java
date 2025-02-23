package school.faang.sprint3.bjs2_61654;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score = 0;
    private int lives = 5;
    private boolean isGameOver = false;
    private final Object scoreLocker = new Object();
    private final Object livesLocker = new Object();


    public void update(boolean isScoreGot, boolean isLifeLost) {
        if (isGameOver) {
            return;
        }
        if (isScoreGot) {
            synchronized (scoreLocker) {
                if (isGameOver) {
                    return;
                }
                score++;
                log.info(String.format("Выполнен удар, количество очков %d", getScore()));
            }
        }

        if (isLifeLost) {
            synchronized (livesLocker) {
                if (isGameOver) {
                    return;
                }
                lives--;
                log.info(String.format("Пропущен удар, количество жизней %d", getLives()));
                if (lives < 1) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        synchronized (scoreLocker) {
            if (!isGameOver) {
                isGameOver = true;
                log.info("Потрачено");
            }
        }
    }
}
