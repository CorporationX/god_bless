package big.bang.theory;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREAD_POOL_SIZE = 4;
    private static final int AWAITING_SECONDS = 3;
    private static final Map<String, String> personAndHisTask =
            Map.of("Шелдон", "подготовка теории",
                    "Леонард", "моделирование эксперимента",
                    "Говард", "разработка инструментов",
                    "Раджеш", "анализ данных");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (Map.Entry<String, String> taskData : personAndHisTask.entrySet()) {
            executorService.submit(new Task(taskData.getKey(), taskData.getValue()));
        }

        smoothShutdown(executorService);
    }

    private static void smoothShutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(AWAITING_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Principal Thread is interrupted");
            executor.shutdownNow();
        }
    }
}
