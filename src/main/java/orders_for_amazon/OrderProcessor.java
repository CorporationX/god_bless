package orders_for_amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            order.setStatus("Processed");

            totalProcessedOrders.incrementAndGet();

            System.out.println("Order " + order.getId() + " processed");
        });
    }

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }
}
