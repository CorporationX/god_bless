package school.faang.multithreading.synchronize.bjs2_90310;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        Object lock = new Object();

        Player playerOne = new Player(lock);
        Player playerTwo = new Player(lock);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(playerOne::play);
        executorService.execute(playerTwo::pause);
        executorService.execute(playerOne::skip);
        executorService.execute(playerTwo::previous);
        executorService.execute(playerTwo::play);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}