package school.faang.bjs2_94400;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 2;
    private static final int TIME_WAIT_IN_MINUTE = 1;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        MasterCardService cardService = new MasterCardService();
        cardService.doAll(executor);
        shutdown();
    }

    private static void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_WAIT_IN_MINUTE, TimeUnit.MINUTES)) {
                log.info("Потоки не успели завершиться за {} минут. Останавливаем принудительно", TIME_WAIT_IN_MINUTE);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка в принудительном завершении потоков");
        }
    }
}
