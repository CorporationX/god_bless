package school.faang.bro_force;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PLAYER_COUNT = 3;
    private static final int TIME_TO_TERMINATE = 1;
    private static final int LIFE_COUNT = 10;
    private static final ExecutorService fixedPool = Executors.newFixedThreadPool(PLAYER_COUNT);

    public static void main(String[] args) {
        Game game = new Game(LIFE_COUNT);
        List<Future<?>> futures = createGameTasks(game);
        waitForTasksToComplete(futures);
        endGame();
    }

    private static List<Future<?>> createGameTasks(Game game) {
        List<Future<?>> futures = new ArrayList<>();

        futures.add(fixedPool.submit(createLifeLosingTask(game)));
        futures.add(fixedPool.submit(createPointEarningTask(game)));
        futures.add(fixedPool.submit(createLifeLosingTask(game)));
        futures.add(fixedPool.submit(createPointEarningTask(game)));
        futures.add(fixedPool.submit(createLifeLosingTask(game)));
        futures.add(fixedPool.submit(createPointEarningTask(game)));
        futures.add(fixedPool.submit(createPointEarningTask(game)));

        return futures;
    }

    private static Runnable createLifeLosingTask(Game game) {
        return () -> {
            while (game.getLife() > 0) {
                game.update(false, true);
            }
        };
    }

    private static Runnable createPointEarningTask(Game game) {
        return () -> {
            while (game.getLife() > 0) {
                game.update(true, false);
            }
        };
    }

    private static void waitForTasksToComplete(List<Future<?>> futures) {
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Exception with message {} was thrown", e.getMessage());
                Thread.currentThread().interrupt();
            }
        });
    }

    private static void endGame() {
        fixedPool.shutdown();
        try {
            if (!fixedPool.awaitTermination(TIME_TO_TERMINATE, TimeUnit.MINUTES)) {
                log.info("Some tasks were not successfully completed, shutting down!");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Tasks were interrupted, shutting down! Error: {}", e.getMessage());
            fixedPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}