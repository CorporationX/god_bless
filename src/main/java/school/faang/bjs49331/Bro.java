package school.faang.bjs49331;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode
public class Bro {
    public static final Random RANDOM = new Random();
    public static final int INIT_LIVES = 2;
    private static final Logger log = LoggerFactory.getLogger(Bro.class);

    @Getter
    private final String name;
    private final AtomicInteger lives;
    private final AtomicInteger score;
    private final AtomicBoolean eliminated;

    public Bro(String name) {
        this.name = name;
        lives = new AtomicInteger(INIT_LIVES);
        score = new AtomicInteger(0);
        eliminated = new AtomicBoolean(false);
    }

    public static void battle(Bro bro, Bro enemy) {
        if (enemy.equals(bro)) {
            log.error("{} cannot battle himself", bro.name);
        }
        boolean win = RANDOM.nextBoolean();
        if (win) {
            battleResult(enemy, bro);
        } else {
            battleResult(bro, enemy);
        }
    }

    private static void battleResult(Bro winner, Bro loser) {
        winner.score.incrementAndGet();
        int livesLeft = loser.lives.decrementAndGet();
        log.info("{} killed {}. {} score {}, {} lives {}",
                winner.name, loser.name, winner.name, winner.score, loser.name, loser.lives);
        if (livesLeft == 0) {
            loser.eliminated.getAndSet(true);
            log.info("Game over for {} with score {}", loser.name, loser.score);
        }
    }

    public boolean isEliminated() {
        return eliminated.get();
    }

    public int getScore() {
        return score.get();
    }
}
