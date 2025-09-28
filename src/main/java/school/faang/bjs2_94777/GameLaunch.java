package school.faang.bjs2_94777;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GameLaunch {
    private static final int THREAD_COUNT = 10;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);
    private static final int AWAIT_MINUTES = 1;

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.start(EXECUTOR);
        shutdown();
    }

    private static void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(AWAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не закончили работу за {} минут. Останавливаем потоки", AWAIT_MINUTES);
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка в ожидании завершения работы потоков");
        }
    }
}
