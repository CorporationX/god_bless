package school.faang.bjs273199;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int MAX_PLAYBACK_TIME_SECONDS = 10;

    public static void main(String[] args) {

        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::pause);
        executor.submit(player::play);
        executor.submit(player::skip);
        executor.submit(player::previous);
        executor.submit(player::play);
        executor.submit(player::pause);
        executor.submit(player::pause);
        executor.submit(player::play);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(MAX_PLAYBACK_TIME_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
