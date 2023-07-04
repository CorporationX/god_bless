package faang.school.godbless.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
  public static void main(String[] args) {
    final int NOTIFICATION_LENGTH = 15;

    OrderProcessor orderProcessor = new OrderProcessor();
    List<CompletableFuture<Order>> futures = new ArrayList<>();

    for (int i = 0; i < NOTIFICATION_LENGTH; i++) {
      Order order = new Order(i+1);

      futures.add(orderProcessor.processOrder(order));
    }

    CompletableFuture<Void> tasks = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

    tasks.thenRun(() -> {
      for (CompletableFuture<Order> future : futures) {
        try {
          Order order = future.get();
          System.out.println("Order with id " + order.getId() + " was " + order.getStatus());
        } catch (InterruptedException | ExecutionException e) {
          throw new RuntimeException(e);
        }
      }

      System.out.println("Total amount of order: " + orderProcessor.getTotalProcessedOrders());
    }).join();
  }
}
