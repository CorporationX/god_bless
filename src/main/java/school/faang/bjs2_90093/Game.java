package school.faang.bjs2_90093;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private int score = 0;
    private int lives;
    public boolean isGameInProgress = true;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int lives) {
        this.lives = lives;
    }

    public void update(boolean isPlayerEarningPoints, boolean isPlayerLosingLive) {
        synchronized (scoreLock) {
            if (isPlayerEarningPoints) {
                score++;
                log.info("игрок зарабатывает очко -- текущие очки: {}", score);
            }
        }
        synchronized (livesLock) {
            if (isPlayerLosingLive && lives > 0) {
                lives--;
                log.info("игрок теряет жизнь -- текущие жизни: {}", lives);
            }
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        isGameInProgress = false;
        log.info("игрок потерял последнюю жизнь - игра окончена");
    }
}

// if (!isGameInProgress) {
//                gameOver();
//            }