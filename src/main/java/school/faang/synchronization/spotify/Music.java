package school.faang.synchronization.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::skip);
        executor.execute(player::previous);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
