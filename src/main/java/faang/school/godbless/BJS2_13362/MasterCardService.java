package faang.school.godbless.BJS2_13362;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
  private static final int THREADS = 2;

  public static void main(String[] args) {
    MasterCardService masterCardService = new MasterCardService();
    try {
      masterCardService.doAll();
    } catch (ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  static int collectPayment() {
    try {
      Thread.sleep(10_000);
      return 10_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  static int sendAnalystics() {
    try {
      Thread.sleep(1_000);
      return 1_000;
    } catch (InterruptedException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  public void doAll() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(THREADS);
    Future<Integer> collect = executor.submit(MasterCardService::collectPayment);
    CompletableFuture<Integer> send = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
    System.out.println(collect.get());
    System.out.println(send.get());

    executor.shutdown();
  }
}
