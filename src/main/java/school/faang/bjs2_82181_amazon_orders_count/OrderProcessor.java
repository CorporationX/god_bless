package school.faang.bjs2_82181_amazon_orders_count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private final AtomicInteger processedOrderCnt = new AtomicInteger();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void processOrder(Order order) {
        //TODO!
    }
}
