package school.faang.BJS2_63887;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newCachedThreadPool;

@Slf4j
public class Music {
    private static final long terminationTimeout = 10;

    public static void main(String[] args) {
        Player player = new Player();
        List<User> users = List.of(
                new User("Ramil", player),
                new User("Albert", player),
                new User("Kamil", player)
        );

        ExecutorService executor = newCachedThreadPool();
        try {
            users.forEach(executor::execute);
        } finally {
            shutdownExecutor(executor);
        }
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(terminationTimeout, TimeUnit.SECONDS)) {
                log.error("Не все потоки завершились вовремя, принудительно завершаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ошибка ожидания завершения потоков", e);
        }
    }
}
