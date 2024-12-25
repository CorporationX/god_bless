package derschrank.sprint03.task08.bjstwo_49270;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int DEFAULT_DELAY = 100;
    private static final int DEFAULT_AWAIT_TIME_SECONDS = 10;

    public static void main(String[] args) {
        Random rnd = new Random();
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        while (game.isAlive()) {
            executor.execute(() -> update(rnd, game));
            sleep(DEFAULT_DELAY);
        }

        executorShutdown(executor);
    }

    private static void update(Random rnd, Game game) {
        if (game.isAlive()) {
            game.update(rnd.nextBoolean());
        }
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Main::update was interrupted");
        }
    }

    private static void executorShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(DEFAULT_AWAIT_TIME_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted");
        }
    }
}
