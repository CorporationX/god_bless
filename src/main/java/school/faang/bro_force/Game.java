package school.faang.bro_force;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;

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

    public void update(Map<Parameter, Function<Integer, Integer>> updates) {
        log.debug("Thread: {}, calling update()", Thread.currentThread().getName());
        if (isGameOver) { //должно быть ок без volatile если параметр isGameOver меняется только в блоке synchronized
            gameOver();
        }
        synchronized (firstLock) {
            synchronized (secondLock) {
                for (var entry : updates.entrySet()) {
                    if (Parameter.LIVE == entry.getKey()) {
                        log.debug("Thread: {}, Modifying LIVE parameter, current value = {}",
                                Thread.currentThread().getName(), lives);
                        lives = entry.getValue().apply(lives);
                        log.debug("Thread: {}, LIVE parameter after modifying, current value = {}",
                                Thread.currentThread().getName(), lives);
                        if (lives <= 0) {
                            gameOver();
                        }
                    } else if (Parameter.SCORE == entry.getKey()) {
                        log.debug("Thread: {}, Modifying SCORE parameter, current value = {}",
                                Thread.currentThread().getName(), scores);
                        scores = entry.getValue().apply(scores);
                        log.debug("Thread: {}, SCORE parameter after modifying, current value = {}",
                                Thread.currentThread().getName(), scores);
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
