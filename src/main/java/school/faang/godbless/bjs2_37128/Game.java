package school.faang.godbless.bjs2_37128;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Game {
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();
    private final Set<Player> players = new HashSet<>();
    private int score;
    private int lives;

    public void addPlayer(@NonNull Player player) {
        players.add(player);
        lives += player.getLives();
    }

    public void update(Player player, UpdateType type) {
        if (!players.contains(player) || player.getLives() == 0) {
            log.error("Can not use update on the player that is not in the game or is dead");
            return;
        }

        if (type == UpdateType.LOOSE_LIFE) {
            livesLock.lock();
            try {
                player.setLives(player.getLives() - 1);
                lives--;
                log.info("Player {} looses their life. Total lives of the team: {}", player.getName(), lives);
            } finally {
                livesLock.unlock();
            }
        } else {
            scoreLock.lock();
            try {
                player.setScore(player.getScore() + 1);
                score++;
                log.info("Player {} scored a point", player.getName());
            } finally {
                scoreLock.unlock();
            }
        }

        if (lives == 0) {
            gameOver();
        }
    }

    private void gameOver() {
        log.info("All players have died. The final score is {}", score);
    }

    public enum UpdateType {
        SCORE_POINT, LOOSE_LIFE
    }
}
