package school.faang.bjs2_90399;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 3;
    private static final int THREAD_SLEEP_MILS = 1000;
    private static final int AWAIT_THREAD_MINUTES = 1;

    public static void main(String[] args) {
        Game game = new Game();
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        while (game.getLives() > 0) {
            executor.submit(() -> game.update(random.nextBoolean(), random.nextBoolean()));
            try {
                Thread.sleep(THREAD_SLEEP_MILS);
            } catch (InterruptedException e) {
                log.error("Ошибка при имитации игры");
            }
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_THREAD_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не успели закончить работу за {} - минут. Останавливаем принудительно",
                        AWAIT_THREAD_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка в ожидании потоков");
            executor.shutdownNow();
        }
    }
}
