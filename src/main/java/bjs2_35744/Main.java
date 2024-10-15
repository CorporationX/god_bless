package bjs2_35744;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);
        Game game = new Game(0, 10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> game.update(true, true));
        }
        executorService.shutdown();
    }
}
