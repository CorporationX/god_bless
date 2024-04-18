package faang.school.godbless.synchronization.broForce;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Getter
public class Game {
    private int score;
    private int lives; //Loosed lives counter
    private boolean gameOver;
    private final List<Player> players;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();


    public Game(List<Player> players) {
        if (players == null) {
            throw new IllegalArgumentException("Players lis can't be null-valued.");
        }

        this.players = players;
        score = 0;
        lives = 0;
        gameOver = false;
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        players.add(new Player("Rambro"));
        players.add(new Player("Brommando "));
        players.add(new Player("Brodell Walker"));
        players.add(new Player("Bro Hard"));

        Game game = new Game(players);

        ExecutorService gameThreads = Executors.newFixedThreadPool(players.size() + 1);

        log.info("Game begins!");

        gameThreads.submit(() -> {
            while (!game.isGameOver()) {
                game.update();
            }
        });

        players.forEach(player -> gameThreads.submit(player::simulateGame));

        gameThreads.shutdown();

        try {
            gameThreads.awaitTermination(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Game was interrupted.", e);
        }
    }

    public void update() {
        synchronized (livesLock) {
            var deadPlayers = players.stream()
                    .filter(player -> !player.isAlive())
                    .toList();

            if (deadPlayers.size() > 0) {
                lives = deadPlayers.size();
            }

            if (lives == players.size()) {
                gameOver();
            }
        }

        synchronized (scoreLock) {
            score = 0;
            players.forEach(player -> score += player.getScore());
        }
    }

    private void gameOver() {
        log.info("Game over! Total score of all players is " + score);
        gameOver = true;
    }
}
