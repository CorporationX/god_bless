package src.faang.BJS2_73697;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Player> players;

    private int score;
    private int lives;


    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() {
        synchronized (scoreLock) {
            for (Player player : players) {
                if (player.isAlive()) {
                    score++;
                    player.addScore(player.getScore() + 1);
                }
            }
        }

        synchronized (livesLock) {
            for (Player player : players) {
                if (player.isAlive()) {
                    player.decreaseLives();
                    lives++;
                } else {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        log.info("Game Over : score: {} lives: {}",
                score,
                lives
        );
    }
}


