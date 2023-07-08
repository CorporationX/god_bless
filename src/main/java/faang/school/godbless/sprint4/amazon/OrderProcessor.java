package faang.school.godbless.sprint4.amazon;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
@Data
public class OrderProcessor {
   private AtomicInteger totalProcessedOrders = new AtomicInteger(0);

   public void processOrder(Order order) {
          CompletableFuture future = CompletableFuture.runAsync(() -> {
              try {
                  Thread.sleep(5000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              totalProcessedOrders.incrementAndGet();
              order.setStatus(Status.COMPLETED);
          });

          try {
              future.get();
          }catch (InterruptedException | ExecutionException e) {
              e.printStackTrace();
          }
   }
}
