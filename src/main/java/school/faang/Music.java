package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {

    public static void main(String[] args) {
        final int MAX_THREADS = 4;
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        try {
            executor.submit(() -> player.play());
            executor.submit(() -> player.pause());
            executor.submit(() -> player.skip());
            executor.submit(() -> player.previous());
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                log.info("Задачи небыли завершены за 3 секунды, останавливаем потоки.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
