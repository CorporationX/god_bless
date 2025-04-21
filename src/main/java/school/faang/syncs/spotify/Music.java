package school.faang.syncs.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {

    private static final int TIME_TO_TERMINATION = 5;

    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(() -> {
            player.play();
            player.pause();
            player.skip();
        });
        executor.submit(player::skip);
        executor.submit(player::skip);
        executor.submit(player::pause);
        executor.submit(player::play);
        executor.submit(player::previous);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_TO_TERMINATION, TimeUnit.MINUTES)) {
                log.info("Tasks have not been finished in {} minutes, forcing shutdown", TIME_TO_TERMINATION);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }


    }

}
