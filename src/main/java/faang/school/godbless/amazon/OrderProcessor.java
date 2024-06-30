package faang.school.godbless.amazon;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
@Getter
public class OrderProcessor {
    private final AtomicInteger totalProcessedOrders;

    public OrderProcessor() {
        this.totalProcessedOrders = new AtomicInteger(0);
    }

    public void processOrder(Order order) throws InterruptedException {
        Thread.sleep(500);
        order.setStatus("Completed");
        totalProcessedOrders.accumulateAndGet(1,Integer::sum);
    }
}
