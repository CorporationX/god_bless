package faang.school.godbless.sprint3.ordersInAmazon;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderExecutorServiceConfig {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
