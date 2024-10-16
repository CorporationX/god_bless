package school.faang.blockspotify.main;

import school.faang.blockspotify.maincode.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(player::pause);
        executor.submit(player::play);
        executor.submit(player::skip);
        executor.submit(player::previous);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
