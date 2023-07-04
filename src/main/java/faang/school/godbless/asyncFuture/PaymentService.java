package faang.school.godbless.asyncFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PaymentService {
  public static void doAll() {
    ExecutorService service = Executors.newSingleThreadExecutor();

    Future<Integer> collectedPayment = service.submit(() -> MasterCardService.collectPayment());

    CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, service);

    System.out.println("Main thread is not waiting 2 lines above");

    try {
      System.out.println(collectedPayment.get());
      System.out.println(analytics.get());
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    service.shutdown();
  }
}
