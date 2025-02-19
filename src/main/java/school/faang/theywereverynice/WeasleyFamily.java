package school.faang.theywereverynice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final int AWAIT_TERMINATION_TIME = 30;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : CHORES) {
            Chore chore = new Chore(choreName);
            executor.execute(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                log.info("Не удалось выполнить все задачи за отведенное время. Принудительное завершение...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Ожидание завершения задач было прервано.");
            executor.shutdownNow();
        }

        log.info("Все домашние дела выполнены!");
    }
}
