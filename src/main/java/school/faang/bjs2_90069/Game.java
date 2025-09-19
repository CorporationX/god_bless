package school.faang.bjs2_90069;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Slf4j
@Getter
public class Game {
    private static final double PROBABILITY_SCORING_POINTS = 0.7;
    private static final double PROBABILITY_LOSING_LIFE = 0.3;

    private int score = 0;
    private int lives = 0;
    private final List<Player> players = new ArrayList<>();

    private static final Object lockScope = new Object();
    private static final Object lockLives = new Object();
    private static final Random random = new Random();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void undate(Player player) {

        synchronized (lockScope) {
            if (getRandom() < PROBABILITY_SCORING_POINTS) {
                player.setScope(player.getScope() + 1);
                score++;
                log.info("The player {} scored one point. The number of points became {} ",
                        player.getName(), player.getScope());
            } else {
                log.info("The player {} failed to score any points. Current score {}",
                        player.getName(), player.getScope());
            }
        }

        synchronized (lockLives) {
            if (getRandom() < 0.25) {
                player.setLives(player.getLives() - 1);
                lives++;
                log.info("the player {} lost his one life. Lives - {}",
                        player.getName(), player.getLives());
                if (player.getLives() == 0) {
                    player.setAlive(false);
                    gameOver(player);
                }
            }
        }
    }

    private double getRandom() {
        return random.nextDouble();
    }

    private void gameOver(Player player) {
        players.remove(player);
        log.info("The player {} has been defeated! Points - {} . Lives - {}",
                player.getName(), player.getScope(), player.getLives());
    }
}
