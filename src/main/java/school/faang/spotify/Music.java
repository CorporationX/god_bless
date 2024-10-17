package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
  private static final int THREAD_POOL_SIZE = 4;

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    Player player = new Player();

    executorService.submit(player::play);
    executorService.submit(player::pause);
    executorService.submit(player::skip);
    executorService.submit(player::previous);

    executorService.shutdown();

    try {
      if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
      }else {
        System.out.printf("поток %s завершён", Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
      executorService.shutdownNow();
    }
  }
}
