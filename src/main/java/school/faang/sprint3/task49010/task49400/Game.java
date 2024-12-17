package school.faang.sprint3.task49010.task49400;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {
    private static final int MAX_LIVES = 100;
    private static final int MAX_SCORE = 100;
    private int score;
    private int lives;
    @Getter
    private boolean isOver;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        lives = MAX_LIVES;
        score = 0;
        isOver = false;
    }

    public void update(boolean isEarned, boolean isDamaged) {
        if (isEarned) {
            synchronized (scoreLock) {
                score++;
                log.info("Player win. His cache: " + score);
                if (score == MAX_SCORE) {
                    gameOver(true);
                    return;
                }
            }
        }

        if (isDamaged) {
            synchronized (livesLock) {
                lives--;
                log.info("Player lost. His lives: " + lives);
                if (lives == 0) {
                    gameOver(false);
                }
            }
        }
    }

    private void gameOver(boolean isWin) {
        isOver = true;
        if (isWin) {
            log.info("Player is win. Congratulations! You must to recreate, because your lives: " + lives);
        } else {
            log.info("Player is died. Sorry ... Yo may take his cache : " + score);
        }
    }

}
