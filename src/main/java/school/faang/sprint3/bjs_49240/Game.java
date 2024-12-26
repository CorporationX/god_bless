package school.faang.sprint3.bjs_49240;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Game {
    private int totalScore;
    private int totalLives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final AtomicBoolean isGameOver = new AtomicBoolean(false);

    public Game(int totalScore, int totalLives) {
        this.totalScore = totalScore;
        this.totalLives = totalLives;
    }

    public void update(Player player) throws GameOverException {
        if (player.lostLife()) {
            synchronized (lockLives) {
                if (!isGameOver.get()) {
                    totalLives--;
                    if (totalLives <= 0) {
                        log.info("No lives left in current game");
                        isGameOver.set(true);
                        throw new GameOverException();
                    }
                    log.info("Lives left {}", totalLives);
                }
            }
        }
        if (player.getPoints()) {
            synchronized (lockScore) {
                if (!isGameOver.get()) {
                    totalScore++;
                    log.info("Total score of the game : {}", totalScore);
                }
            }
        }
    }
}
