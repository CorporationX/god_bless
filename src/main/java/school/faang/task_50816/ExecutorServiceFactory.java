package school.faang.task_50816;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFactory {
    public static ExecutorService createExecutorService() {
        return Executors.newFixedThreadPool(Constants.NUM_THREADS);
    }
}
