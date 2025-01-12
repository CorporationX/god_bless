package bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {
    public static final int EXECUTOR_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(EXECUTOR_SIZE);
        Game game = new Game(executor);

        for (int i = 0; i <= EXECUTOR_SIZE; i++) {
            executor.submit(() -> {
                while (game.getLives() > 0) {
                    game.update();
                    try {
                        sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
