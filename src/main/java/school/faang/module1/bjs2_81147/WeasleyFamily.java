package school.faang.module1.bjs2_81147;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    private final String[] chores = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин"
    };

    private final static int TIMEOUT = 10;

    public void doAllChores() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executorService.execute(chore);
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Задачи не завершились {} секунд", TIMEOUT);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Ожидание завершения было прервано", e);
            executorService.shutdownNow();
        }
    }
}