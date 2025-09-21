package school.faang.bjs2_92444;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 6;
    private static final int THREAD_AWAIT_MINUTE = 1;

    public static void main(String[] args) {
        List<Player> players = List.of(new Player("R2-D2"), new Player("C-3PO"),
                new Player("BB-8"), new Player("Chewbacca"),
                new Player("Han"), new Player("Luke"),
                new Player("Leia"), new Player("Obi-Wan"),
                new Player("Lando"), new Player("Rey"));
        ExecutorService executors = Executors.newFixedThreadPool(THREAD_COUNT);
        Boss boss = new Boss();
        for (Player player : players) {
            executors.submit(() -> player.doBattle(boss));
        }
        executors.shutdown();
        try {
            if (!executors.awaitTermination(THREAD_AWAIT_MINUTE, TimeUnit.MINUTES)) {
                log.info("Время ожидания потоков {} - минут истекло. Завершаем потоки", THREAD_AWAIT_MINUTE);
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Ошибка в ожидании завершения потоков");
            executors.shutdownNow();
        }
    }
}
