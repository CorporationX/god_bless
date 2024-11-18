package faang.school.godbless.BJS2_6108;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.LongStream;

public class Main {
  private static final int NUM_THREADS = 4;
  public static void main(String[] args) {
    launch();
  }
  public static Long fanOutFanIn(List<SquareRequest> requests, ResultConsumer resultConsumer) {
    ExecutorService executrs = Executors.newFixedThreadPool(NUM_THREADS);
    List<CompletableFuture<Void>> futures = new ArrayList<>();
    for (SquareRequest request: requests) {
      CompletableFuture<Void> future = CompletableFuture.runAsync(() -> request.longTimeSquare(resultConsumer), executrs);
      futures.add(future);
    }
    futures.forEach(CompletableFuture::join);
    executrs.shutdown();
    return resultConsumer.getSumOfSquaredNumbers().get();
  }

  public static void launch() {
    List<SquareRequest> requests = new ArrayList<>();
    ResultConsumer consumer = new ResultConsumer(0L);
    LongStream.range(1, 1001).forEach(i -> requests.add(new SquareRequest(i)));
    System.out.println(fanOutFanIn(requests, consumer));
  }
}
