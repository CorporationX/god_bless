package school.faang.task_50019;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Новый"),
                new Order(2, "Новый"),
                new Order(3, "Новый")
        );
        OrderProcessor processor = new OrderProcessor();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        processor.processAllOrders(orders, executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
