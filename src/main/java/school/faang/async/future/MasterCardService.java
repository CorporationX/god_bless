package school.faang.async.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MasterCardService {

  private final static int MAX_WAITING_TIME = 5;

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    MasterCardService service = new MasterCardService();
    service.doAll();

  }

  private void doAll() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    Future<Integer> payments = executor.submit(MasterCardService::collectPayment);
    CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(
        MasterCardService::sendAnalytics, executor);

    System.out.println("Analytics -> sent: " + analytics.join());
    System.out.println("Payments -> done: " + payments.get());
    executor.shutdownNow();

    if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
      executor.shutdownNow();
      if (!executor.awaitTermination(MAX_WAITING_TIME, TimeUnit.SECONDS)) {
        System.out.println("The pool did not terminate");
      }
    }
  }

  private static int collectPayment() {
    try {
      Thread.sleep(10_000);
      log.info("I am payments Thread :)");
      return 10_000;
    } catch (InterruptedException | RuntimeException e) {
      log.error("Caught exception @ collectPayment", e);
    }
    log.info("collect no payment");
    return 0;
  }

  private static int sendAnalytics() {
    try {
      Thread.sleep(1_000);
      log.info("I am analytics Thread :)");
      return 1_000;
    } catch (InterruptedException | RuntimeException e) {
      log.error("Caught exception @ sendAnalytics", e);
    }
    log.info("send no analytics");
    return 0;
  }

}
