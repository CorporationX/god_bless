package school.faang.BJS2_61694;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Getter
public class Game {

    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Bro> players = new ArrayList<>();
    private final Random random = new Random();

    public void addPlayer(@NonNull Bro bro) {
        synchronized (players) {
            players.add(bro);
            log.info("A new player {} has been added to the game", bro.getName());
        }
    }

    public void update() {
        Bro bro;
        synchronized (players) {
            if (players.size() <= 1) {
                return;
            }
            bro = players.get(random.nextInt(players.size()));
        }
        boolean isWinnerAttack = bro.isWinnenAttack();
        if (isWinnerAttack) {
            synchronized (scoreLock) {
                bro.setScore(bro.getScore() + 1);
                log.info("The player {} got points. Current score: {}", bro.getName(), bro.getScore());
                score++;
                log.info("Current game score: {}", score);
            }
        } else {
            synchronized (livesLock) {
                bro.setLives(bro.getLives() - 1);
                log.info("The player {} lost his life. His current count lives: {}", bro.getName(), bro.getLives());
                lives++;
                log.info("Current game count lost lives: {}", lives);
                if (bro.getLives() == 0) {
                    gameOver(bro);
                }
            }
        }
    }

    private void gameOver(Bro bro) {
        synchronized (players) {
            players.remove(bro);
            log.info("The game is over for the player {}", bro.getName());
        }
    }
}
