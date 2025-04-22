package school.faang.exthreadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "пропылесосить"};
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void createChore() {
        for (String chore : chores) {
            Chore choreOfHouse = new Chore(chore);
            executor.submit(choreOfHouse);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(6, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.info("распределение обязанностей ПРЕРВАНО");
            } else {
                log.info("Распределение обязанностей завершено ПОСНОСТЬЮ");
            }
        } catch (InterruptedException e) {
            log.error("Поток {} был принудительно прерван. Выброшено исключение",
                    Thread.currentThread().getName(), e);
            executor.shutdownNow();
        }
        log.info("Основной поток {} завершил работу", Thread.currentThread().getName());
    }
}