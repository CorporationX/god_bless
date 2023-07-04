package faang.school.godbless.amazon;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderProcessor {
  private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

  public CompletableFuture<Order> processOrder(Order order) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.printf(e.toString());
      }

      order.setStatus(Status.DELIVERED);

      totalProcessedOrders.incrementAndGet();
      return order;
    });
  }

  public AtomicInteger getTotalProcessedOrders() {
    return totalProcessedOrders;
  }
}
