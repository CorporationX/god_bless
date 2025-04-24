package school.faang.stream3.broforce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Game {

    private final Object soreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives;

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(int scoresToAdd, int livesToRemove) {
        synchronized (soreLock) {
            this.score += scoresToAdd;
        }
        synchronized (livesLock) {
            this.lives -= livesToRemove;
            if (this.lives <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        log.info("Game over, the final score is {}", score);
    }

    public void addPlayer(Player player) {
        this.lives += player.getLives();
        this.score += player.getScores();
    }
}
