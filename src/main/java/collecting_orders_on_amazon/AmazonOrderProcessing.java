package collecting_orders_on_amazon;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AmazonOrderProcessing {
    private static final int MAX_THREADS = 3;
    private static final int AWAIT_SECONDS = 30;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

    /**
     * Entry point of the program.
     *
     * Creates an instance of {@link OrderProcessor}, creates a list of 3 orders
     * with status {@link OrderStatus#NEW}, processes all orders in parallel
     * using the provided {@link ExecutorService}, and then waits for the
     * threads to finish using {@link ExecutorService#shutdown()} and
     * {@link ExecutorService#awaitTermination(long, TimeUnit)}.
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the current thread is interrupted while
     *                              waiting for the threads to finish
     */
    public static void main(String[] args) throws InterruptedException {
        OrderProcessor processor = new OrderProcessor();

        List<Order> orders = List.of(
                new Order(1, OrderStatus.NEW),
                new Order(2, OrderStatus.NEW),
                new Order(3, OrderStatus.NEW)
        );

        processor.processAllOrders(orders, executorService);

        executorService.shutdown();

        if (!executorService.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
