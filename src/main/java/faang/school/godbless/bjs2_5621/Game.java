package faang.school.godbless.bjs2_5621;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Getter
public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private final List<Player> players = new ArrayList<>();
    private final Random random = new Random();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void update() {
        //Get random player and change him live status
        int index = random.nextInt(players.size());
        Player player = players.get(index);
        boolean isAlive = random.nextBoolean();

        if (!isAlive) {
            synchronized (lockLives) {
                player.setLives(player.getLives() - 1);
                lives++;
                log.info("{} was killed! {} lives left", player.getName(), player.getLives());
                if (player.getLives() == 0) {
                    player.setAlive(false);
                    gameOver(player);
                    synchronized (players) {
                        players.remove(player);
                    }
                }
                player.setAlive(true);
            }
        } else {
            synchronized (lockScore) {
                log.info("{} earn one score!", player.getName());
                player.setScore(player.getScore() + 1);
                score++;
            }
        }
    }

    public void gameOver(Player player) {
        log.info("{} Game over", player.getName());
        log.info("Total score: {}", score);
        log.info("Total lives: {}", lives);
    }
}
