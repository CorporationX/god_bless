package school.faang.sprint4.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::skip);
        executor.submit(player::previous);

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
