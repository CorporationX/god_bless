package faang.school.godbless.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
    private static final AtomicInteger totalProcessedOrders = new AtomicInteger();


    public static CompletableFuture<Void> processOrder(Order order, ExecutorService pool) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            order.setStatus("Processed");
            totalProcessedOrders.incrementAndGet();
        }, pool);
    }

    public int getTotalProcessedOrders(){
        return totalProcessedOrders.get();
    }
}
