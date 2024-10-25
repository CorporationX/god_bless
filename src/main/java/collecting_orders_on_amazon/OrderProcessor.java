package collecting_orders_on_amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;


public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders = new AtomicInteger(0);

    /**
     * Process an order asynchronously with the given executor service.
     *
     * @param order the order to process
     * @param executorService the executor service to use for the asynchronous task
     * @return a CompletableFuture that will complete with the processed order
     */
    public CompletableFuture<Order> processOrder(Order order, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            order.setStatus(OrderStatus.PROCESSING);
            totalProcessedOrders.incrementAndGet();
            return order;
        }, executorService);
    }

    /**
     * Processes all orders in the list asynchronously. The {@code executorService}
     * is used to run the order processing tasks in parallel.
     *
     * @param orders the list of orders to process
     * @param executorService the executor service that runs the tasks
     */
    public void processAllOrders(List<Order> orders, ExecutorService executorService) {
        List<CompletableFuture<Order>> futures = orders.stream()
                .map(order -> processOrder(order, executorService))
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.join();

        System.out.println("Total processed orders: " + totalProcessedOrders.get());
    }
}
