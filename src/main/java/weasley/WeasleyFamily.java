package weasley;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int TIMEOUT_MINUTES = 5;

    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "почистить камин",
                "постирать мантии"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.error("Задачи не завершились за {} минут, завершаем принудительно.", TIMEOUT_MINUTES);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ошибка ожидания завершения задач: {}", e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Все задачи завершены!");
    }
}
