package school.faang.sync.bro_force;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int MIN_SLEEP_MS = 1000;
    private static final int MAX_SLEEP_MS = 10000;
    private static final int MAX_TERMINATION_MN = 1;
    private static final double POINTS_CHANCE = 0.5;
    private static final double LIVES_CHANCE = 0.75;


    public static void main(String[] args) {
        Game game = new Game();
        ExecutorService players = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            players.submit(() -> playGame(game));
        }
        
        players.shutdown();
        try {
            if (!players.awaitTermination(MAX_TERMINATION_MN, TimeUnit.MINUTES)) {
                log.warn("Thread was not terminated, forcing shutdown");
                players.shutdownNow();
            }
        } catch (InterruptedException e) {
            players.shutdownNow();
        }
    }

    public static void playGame(Game game) {
        try {
            boolean earnedPoints = Math.random() < POINTS_CHANCE;
            boolean lostLife = Math.random() < LIVES_CHANCE;
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(MIN_SLEEP_MS, MAX_SLEEP_MS));
            game.update(earnedPoints, lostLife);
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted");
        }
    }
}
