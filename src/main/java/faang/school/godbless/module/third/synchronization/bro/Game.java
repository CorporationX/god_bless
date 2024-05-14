package faang.school.godbless.module.third.synchronization.bro;

import java.util.Random;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Game {
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;
    
    public Game(int lives) {
        this.lives = lives;
    }
    
    public void update() {
        if (gameOver) {
            return;
        }
        synchronized (scoreLock) {
            score++;
            log.info("Score + 1");
        }
        
        synchronized (livesLock) {
            if (lives == 0) {
                gameOver();
            } else {
                Random random = new Random();
                switch (random.nextInt(3) + 1) {
                    case 1:
                        synchronized (livesLock) {
                            if (lives > 0) {
                                lives++;
                                log.info("Live + 1");
                            }
                        }
                        break;
                    case 2:
                        synchronized (livesLock) {
                            if (lives > 0) {
                                lives--;
                                log.info("Live - 1");
                                if (lives == 0) {
                                    gameOver();
                                }
                            }
                        }
                        break;
                    case 3:
                        synchronized (scoreLock) {
                            score++;
                            log.info("Score + 1");
                        }
                }
            }
        }
    }
    
    private void gameOver() {
        log.info("Game over! Score {}", score);
        gameOver = true;
    }
}
