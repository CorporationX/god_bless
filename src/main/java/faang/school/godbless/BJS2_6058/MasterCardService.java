package faang.school.godbless.BJS2_6058;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
  private static final int NUM_THREADS = 2;

  public int collectPayment() {
    try {
      Thread.sleep(10_000);
      return 10_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  public int sendAnalytics() {
    try {
      Thread.sleep(1_000);
      return 1_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  public void doAll() {
    ExecutorService executors = Executors.newSingleThreadExecutor();

    Future<Integer> collect = executors.submit(this::collectPayment);
    CompletableFuture<Integer>send = CompletableFuture.supplyAsync(this::sendAnalytics);

    try {
      System.out.println(collect.get());
      System.out.println(send.get());
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    executors.shutdown();
  }
}
