package school.faang.task_60711;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private static final int WORK_TIME = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String choreTitle : CHORES) {
            Chore chore = new Chore(choreTitle);
            executorService.execute(chore);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(WORK_TIME, TimeUnit.SECONDS)) {
                log.info("Задача не завершилась за {} секунд. Принудительно остановить!", WORK_TIME);
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("awaitTermination error");
            executorService.shutdownNow();
        }
    }
}
