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
    private boolean isPlaying = true;
    private List<Player> players = new ArrayList<>();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final int MAX_RANDOM_SCORE = 3;


    public void update() {
        Player player = getRandomPlayer();
        int numberOfActivePlayers = players.size();
        if (player.isAlive()) {
            synchronized (livesLock) {
                player.setLives(player.getLives() - 1);
                lives++;
                log.info(player.getName() + " lives: " + player.getLives());
            }
            if (player.getLives() == 0) {
                player.setAlive(false);
                -- numberOfActivePlayers;
                gameOver(player);
                if (numberOfActivePlayers  == 0) {
                    isPlaying = false;
                }
            }
            synchronized (scoreLock) {
                int randomScore = getRandomScore();
                player.setScore(player.getScore() + randomScore);
                score+= randomScore;
                log.info(player.getName() + " score: " + player.getScore());
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private Player getRandomPlayer() {
        if (!players.isEmpty()) {
            return players.get(new Random().nextInt(players.size()));
        } else {
            throw new NoSuchElementException("No player selected");
        }
    }

    private void gameOver(Player player) {
        log.info(String.format("%s game over! Score: %d. Lost lives: %d", player.getName(), this.getScore(), this.getLives()));
    }
    private int getRandomScore() {
        return (int) (Math.random()*MAX_RANDOM_SCORE);
    }


}
