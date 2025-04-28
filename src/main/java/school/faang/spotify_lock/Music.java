package school.faang.spotify_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int THREAD_COUNT = 4;
    private static final int TIME_TO_WAIT = 3;

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Player player = new Player();

        executorService.submit(() -> {
            player.play();
            player.pause();
            player.skip();
            player.previous();
            player.skip();
            player.previous();
            player.play();
            player.previous();
            player.pause();
        });

        try {
            if (!executorService.awaitTermination(TIME_TO_WAIT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Termination was interrupted.", e
            );
        }
    }
}