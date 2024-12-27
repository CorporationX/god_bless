package school.faang.sprint3.bjs_49240;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PLAYERS = 20;
    private static final int GAME_SCORE = 0;
    private static final int GAME_LIVES = 5;
    private static final int TIME_OUT = 1;

    public static void main(String[] args) {
        Random random = new Random();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < PLAYERS; i++) {
            boolean lostLife = random.nextBoolean();
            boolean getPoints = random.nextBoolean();
            players.add(new Player("Player name " + i, lostLife, getPoints));
        }

        Game game = new Game(GAME_SCORE, GAME_LIVES);
        ExecutorService executor = Executors.newFixedThreadPool(PLAYERS);

        players.forEach(player -> executor.execute(() -> {
            if (!game.isGameOver()) {
                game.update(player);
            }
        }));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.MINUTES)) {
                log.warn("Not all threads stopped by themselves");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread forced to stopped");
            Thread.currentThread().interrupt();
        }
    }
}
