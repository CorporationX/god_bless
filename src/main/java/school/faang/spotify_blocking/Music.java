package school.faang.spotify_blocking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            log.info("Поток 1 пытается воспроизвести музыку. ");
            player.play();
        });
        executorService.submit(() -> {
            log.info("Поток 2 пытается поставить музыку на паузу. ");
            player.pause();
        });
        executorService.submit(() -> {
            log.info("Поток 3 пытается пропустить трек/");
            player.skip();
        });
        executorService.submit(() -> {
            log.info("Поток 4 пытается перейти на предыдущий трек.");
            player.previous();
        });
        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.info("Поток 5 пытается воспроизвести музыку после ожидания.");
                player.play();
            } catch (InterruptedException e) {
                log.error("Поток 5 был прерван во время ожидания.");
                Thread.currentThread().interrupt();
            }
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Не все потоки завершились за 5 секунда, принудительное завершение.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения задач было прервано. ");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}