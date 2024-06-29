package faang.school.godbless.sprint3.asyncAndFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceUtil {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private ExecutorServiceUtil() {}

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
