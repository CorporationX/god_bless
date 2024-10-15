package school.faang.multithreading.synchron.bro.force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(10);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < 100; i++) {
            boolean randomIncreaseScore = Math.random() < 0.5;
            boolean randomReduceLive = Math.random() < 0.5;
            service.submit(() -> game.update(randomIncreaseScore, randomReduceLive));
        }

        service.shutdown();
        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}