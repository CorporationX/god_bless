package school.faang.bro_force;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class Game {
    private int scores;
    private int lives;
    private final Object firstLock = new Object();
    private final Object secondLock = new Object();
    private boolean isGameOver = false;

    public Game(int lives) {
        log.debug("initial lives: {}", lives);
        this.lives = lives;
    }

    public void update(Map<Parameter, Integer> updates) {
        log.debug("Thread: {}, calling update()", Thread.currentThread().getName());
        if (isGameOver) { //должно быть ок без volatile если параметр isGameOver меняется только в блоке synchronized
            gameOver();
        }
        for (var entry : updates.entrySet()) {
            if (Parameter.WON_SCORE == entry.getKey()) {
                synchronized (firstLock) {
                    log.debug("Thread: {}, Parameter = {},Modifying SCORE parameter, current value = {}",
                            Thread.currentThread().getName(), Parameter.WON_SCORE, scores);
                    scores += entry.getValue();
                    log.debug("Thread: {}, Parameter = {}, SCORE parameter after modifying, current value = {}",
                            Thread.currentThread().getName(), Parameter.WON_SCORE, scores);
                }
            } else if (Parameter.LOST_SCORE == entry.getKey()) {
                synchronized (firstLock) {
                    log.debug("Thread: {}, Parameter = {}, Modifying SCORE parameter, current value = {}",
                            Thread.currentThread().getName(), Parameter.LOST_SCORE, scores);
                    scores -= entry.getValue();
                    log.debug("Thread: {}, Parameter = {}, SCORE parameter after modifying, current value = {}",
                            Thread.currentThread().getName(), Parameter.LOST_SCORE, scores);
                }
            } else if (Parameter.LIVE == entry.getKey()) {
                synchronized (secondLock) {
                    log.debug("Thread: {}, Parameter = {}, Modifying LIVE parameter, current value = {}",
                            Thread.currentThread().getName(), Parameter.LIVE, lives);
                    lives -= entry.getValue();
                    log.debug("Thread: {}, Parameter = {}, LIVE parameter after modifying, current value = {}",
                            Thread.currentThread().getName(), Parameter.LIVE, lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("lives have reached 0, the game is over");
        isGameOver = true;
    }
}
