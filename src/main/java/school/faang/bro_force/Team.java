package school.faang.bro_force;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Team {
    private int totalScore;
    private int totalLives;
    private final List<Player> players = new ArrayList<>();

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private static final double HIT_PROBABILITY = 0.33;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        ExecutorService service = Executors.newFixedThreadPool(players.size());
        totalLives = players.stream().mapToInt(Player::getLives).sum();
        players.forEach(player -> service.execute(() -> gamePlay(player)));
        service.shutdown();
        checkServiceTermination(service);
        gameOver();
    }

    private void gamePlay(Player player) {
        while (player.getLives() > 0) {
            update(player);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Thread has been interrupted " + e.getMessage());
            }
        }
        log.info("Player " + player.getName() + " is dead. His score is: " + player.getScore());
    }


    public void update(Player player) {
        if (checkIsInjured()) {
            synchronized (livesLock) {
                player.setLives(player.getLives() - 1);
                totalLives -= 1;
                log.info(player.getName() + " is under attack. Lives left: " + player.getLives() + ". Total lives left: " + totalLives);
            }
        } else {
            synchronized (scoreLock) {
                player.setScore(player.getScore() + 1);
                totalScore += 1;
                log.info(player.getName() + " earned a point. Player's score: " + player.getScore() + ". Total score: " + totalScore);
            }
        }
    }


    private boolean checkIsInjured() {
        return Math.random() < HIT_PROBABILITY;
    }


    private void gameOver() {
        log.info("Game over! Total score is: " + totalScore);
    }

    private void checkServiceTermination(ExecutorService service) {
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}