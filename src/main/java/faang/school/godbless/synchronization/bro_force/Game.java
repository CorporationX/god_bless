package faang.school.godbless.synchronization.bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Slf4j
@Getter
public class Game {
    private int score;
    private int lives;
    private List<Player> players = new ArrayList<>();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final int MAX_RANDOM_SCORE = 3;
    private Random random = new Random();
    private int countActivePlayer = 0;

    public void update() {
        Player player = getRandomPlayer();
        increaseLives(player);
        scoring(player);
    }

    public void addPlayer(Player player) {
        players.add(player);
        countActivePlayer++;
    }

    private Player getRandomPlayer() {
        if (!players.isEmpty()) {
            return players.get(random.nextInt(players.size()));
        } else {
            throw new NoSuchElementException("No player selected");
        }
    }

    private void gameOver(Player player) {
        log.info(String.format("%s game over! Current all score: %d. All lost players lives: %d",
                player.getName(), this.getScore(), this.getLives()));
    }

    private int getRandomScore() {
        return (int) (Math.random() * MAX_RANDOM_SCORE);
    }

    private void scoring(Player player) {
        synchronized (scoreLock) {
            if (player.isAlive()) {
                int randomScore = getRandomScore();
                player.setScore(player.getScore() + randomScore);
                score += randomScore;
                log.info(String.format("%s earned score:%d", player.getName(), player.getScore()));
            }
        }
    }

    private void increaseLives(Player player) {
        synchronized (livesLock) {
            if (player.isAlive()) {
                player.setLives(player.getLives() - 1);
                lives++;
                log.info(player.getName() + " lives: " + player.getLives());
                if (player.getLives() == 0) {
                    player.setAlive(false);
                    countActivePlayer--;
                    gameOver(player);
                }
            }
        }
    }
}
