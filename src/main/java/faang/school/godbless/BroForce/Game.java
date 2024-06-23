package faang.school.godbless.BroForce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Game {
    private static final Random random = new Random();

    @Getter
    private List<Player> players = new ArrayList<>();

    private int score;
    private int lives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update() {
        while (isAllAlive()) {
            int playerIndex = random.nextInt(players.size());
            Player player = players.get(playerIndex);

            if (player.won()) {
                synchronized (scoreLock) {
                    player.setScore(player.getScore() + 1);
                    log.info(player.getName() + " Attacks...   won! score: " + player.getScore());
                    this.score++;
                }
            } else {
                synchronized (livesLock) {
                    player.setLives(player.getLives() - 1);
                    log.info(player.getName() + " Attacks...   lose( lives: " + player.getLives());
                    this.lives++;
                    if (player.getLives() == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        log.info("Total score " + score);
        log.info("Total lives " + lives);
    }

    public boolean isAllAlive() {
        synchronized (livesLock) {
            return players.stream().allMatch((player) -> player.getLives() > 0);
        }
    }

    public Game(List<Player> players) {
        this.players = players;
    }
}