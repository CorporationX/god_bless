package school.faang.routine;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private final int MAX_WAIT_SECONDS = 10;
    private final String[] chores = {"помыть посуду", "подмести пол",
            "приготовить ужин", "погладить кота", "почистить диван"};

    public void parallelTask() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(MAX_WAIT_SECONDS, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершены за {} секунд. Завершаем принудительно...", MAX_WAIT_SECONDS);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            executor.shutdownNow();
        }

        log.info("Все задачи выполнены!");
    }
}
