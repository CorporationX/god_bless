package school.faang.poor;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeaslyFamily {

    private static final int WORK_EXECUTION_TIMEOUT_MINUTES = 1;

    public void getToWork(List<String> chores) {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(chore -> executor.execute(new Chore(chore)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(WORK_EXECUTION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за {} минут", WORK_EXECUTION_TIMEOUT_MINUTES);
                executor.shutdownNow();  // Принудительное завершение, если задачи зависли
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}