package school.faang.bjs2_90553;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.execute(() -> {
            player.play();
            player.skip();
            player.pause();
        });

        executor.execute(() -> {
            player.previous();
            player.play();
            player.skip();
        });

        executor.execute(() -> {
            player.pause();
            player.play();
            player.previous();
        });

        executor.execute(() -> {
            player.skip();
            player.skip();
            player.pause();
        });

        executor.execute(() -> {
            player.play();
            player.pause();
            player.play();
        });

        executor.execute(() -> {
            player.previous();
            player.skip();
            player.play();
        });

        executor.shutdown();
        if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
            log.warn("Not all tasks finished in time");
            executor.shutdownNow();
        }
        log.info("All tasks has been completed");
    }

}


