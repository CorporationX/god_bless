package school.faang.stream3.broforce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
public class Player {
    private final String name;
    private final Game game;
    private int lives;
    private int scores;

    public Player(String name, Game game, int lives, int scores) {
        this.name = name;
        this.game = game;
        this.lives = lives;
        this.scores = scores;
        game.addPlayer(this);
    }

    public void earnScores(int earnedScores) {
        scores += earnedScores;
        game.update(earnedScores, 0);
        log.info("{} just earned {} scores", name, earnedScores);
    }

    public void looseLives(int livesLives) {
        lives -= livesLives;
        game.update(0, livesLives);
        log.info("{} just loose {} live(s)", name, livesLives);

    }

    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("{} Interrupted during delay {}", name, e.getMessage());
        }
    }

    public void playCycle() {
        earnScores(ThreadLocalRandom.current().nextInt(0, 5));
        delay(ThreadLocalRandom.current().nextInt(5, 50));
        if (ThreadLocalRandom.current().nextBoolean()) {
            looseLives(ThreadLocalRandom.current().nextInt(1, 3));
        }
    }

}
