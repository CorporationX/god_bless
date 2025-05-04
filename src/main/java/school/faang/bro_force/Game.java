package school.faang.bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Game {
    private int score;
    private int life;
    private final Object scoreMonitor = new Object();
    private final Object lifeMonitor = new Object();
    private volatile boolean gameOver = false;

    public Game(int life) {
        this.life = life;
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        if (gameOver) {
            return;
        }

        if (isLifeLost) {
            synchronized (lifeMonitor) {
                if (life > 0 && !gameOver) {
                    life--;
                    if (life == 0) {
                        gameOver();
                    } else {
                        log.info("You got damage! {} life(s) left.", life);
                    }
                }
            }
        }

        if (isPointsEarned && !gameOver) {
            synchronized (scoreMonitor) {
                score++;
                log.info("You've got a point! Current score is {}.", score);
            }
        }

    }

    private void gameOver() {
        gameOver = true;
        log.info("Game over! Total score: {}.", score);
    }

}