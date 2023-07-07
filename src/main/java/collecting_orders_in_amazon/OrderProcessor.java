package collecting_orders_in_amazon;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    public static void processOrder(Order order, AtomicInteger totalProcessedOrders) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));

            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
            System.out.println("Order " + order.getId() + " processed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
