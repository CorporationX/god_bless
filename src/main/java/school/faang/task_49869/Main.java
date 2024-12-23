package school.faang.task_49869;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        MasterCardService masterCardService = new MasterCardService();

        try {
            masterCardService.doAll(executorService);

            executorService.shutdown();
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                log.error("Задачи не завершены вовремя, принудительное завершение");
                executorService.shutdownNow();
            } else {
                log.info("Все задачи завершены успешно");
            }
        } catch (InterruptedException e) {
            log.error("Ошибка завершения ExecutorService: {}", e.getMessage());
        }
    }
}
