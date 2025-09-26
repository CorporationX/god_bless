package school.faang.bjs2_93197;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private AtomicInteger totalProcessedOrders = new AtomicInteger(0);
    private static final int THREAD_SLEEP_MS = 1000;

    public int getTotalProcessedOrders() {
        return totalProcessedOrders.get();
    }

    public void processOrder(Order order) {
        try {
            Thread.sleep(THREAD_SLEEP_MS);
            totalProcessedOrders.incrementAndGet();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        order.setStatus(OrderStatuses.PROCESSED);
    }
}
