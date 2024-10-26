package school.faang.async.amazon;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AmazonOrderProcessing {

  private final static int MAX_WAITING_TIME = 5;

  public static void main(String[] args) throws InterruptedException {
    OrderProcessor processor = new OrderProcessor();

    List<Order> orders = List.of(
        new Order(1, "new"),
        new Order(2, "new"),
        new Order(3, "new"),
        new Order(4, "new"),
        new Order(5, "new")
    );

    ExecutorService ordersCollector = Executors.newFixedThreadPool(5);

    CompletableFuture[] futureProcessedOrders = new CompletableFuture[orders.size()];

    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      futureProcessedOrders[i] = CompletableFuture.runAsync(() -> processor.processOrder(order),
          ordersCollector);
    }

    CompletableFuture.allOf(futureProcessedOrders)
        .thenRun(() -> {
          System.out.println("Total orders processed: " + processor.getTotalProcessOrders());
          orders.forEach(System.out::println);
        });

    if (!ordersCollector.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
      ordersCollector.shutdownNow();
      if (!ordersCollector.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
        System.out.println("The pool did not terminate");
      }
    }
  }
}