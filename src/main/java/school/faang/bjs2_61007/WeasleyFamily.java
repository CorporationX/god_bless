package school.faang.bjs2_61007;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    private static final String[] CHORES = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreTitle : CHORES) {
            Chore chore = new Chore(choreTitle);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1000, TimeUnit.SECONDS)) {
                log.info("Не удалось выполнить все задачи за отведенное время.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.info("Ожидание завершения задач было прервано.");
        }
        log.info("Все домашние дела выполнены!");
    }
}
