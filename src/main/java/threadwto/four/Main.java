package threadwto.four;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int EXECUTORS_COUNT = 5;

    public static void main(String[] args) {
        Game game = new Game(0, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(EXECUTORS_COUNT);

        for (int i = 0; i < EXECUTORS_COUNT; i++) {
            executorService.execute(game::update);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
