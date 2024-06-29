package faang.school.godbless.sprint3.wow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ExecutorUtils {

    private final static ExecutorService executorService = Executors.newCachedThreadPool();

    private ExecutorUtils() {}

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
