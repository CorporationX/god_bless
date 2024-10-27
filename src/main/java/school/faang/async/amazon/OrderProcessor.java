package school.faang.async.amazon;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class OrderProcessor {

  private final AtomicInteger totalProcessOrders = new AtomicInteger(0);

  public void processOrder(Order order) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException | RuntimeException e) {
      log.error("Caught exception: ", e);
    }
    order.setStatus("Processed");
    totalProcessOrders.getAndIncrement();
    log.info("processed order # {}", order.getId());
  }

}
