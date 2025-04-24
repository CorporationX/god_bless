package school.faang.spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {

    private static final int COUNT_THREAD_POOL = 5;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREAD_POOL);
        Player player = new Player();
        service.submit(() -> {
            try {
                player.play();
            } catch (Exception e) {
                log.error("Some unexpected error occurred while trying to play music", e);
            }
        });
        service.submit(() -> {
            try {
                player.pause();
            } catch (Exception e) {
                log.error("Some unexpected error occurred while trying to pause music", e);
            }
        });
        service.submit(() -> {
            try {
                player.previous();
            } catch (Exception e) {
                log.error("Some unexpected error occurred while trying to previous music", e);
            }
        });
        service.submit(() -> {
            try {
                player.skip();
            } catch (Exception e) {
                log.error("Some unexpected error occurred while trying to skip music", e);
            }
        });
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Еще есть задачи ожидающие выполнения");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
