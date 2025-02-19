package school.faang.BJS2_60771;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final Logger logger = LoggerFactory.getLogger(WeasleyFamily.class);
    private static final String COMPLETED_TASKS_MESSAGE = "All tasks are completed";
    private static final String GETTING_TASK_MESSAGE = "We have a new task: {}";
    private static final String ABORTING_TASKS_MESSAGE = "Long task completion. Forced termination";
    private static final String ERROR_TASKS_MESSAGE = "Task completion error: \n{}";
    private static final String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
            logger.info(GETTING_TASK_MESSAGE, chore);
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(50, TimeUnit.SECONDS)) {
                logger.info(COMPLETED_TASKS_MESSAGE);
            } else {
                logger.info(ABORTING_TASKS_MESSAGE);
                executorService.shutdownNow(); // Принудительное завершение, если задачи не завершились
            }
        } catch (InterruptedException e) {
            logger.info(ERROR_TASKS_MESSAGE, e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
