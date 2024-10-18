package school.faang.broForce;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  private static final int TREAD_POOL_SIZE = 5;

  public static void main(String[] args) {
    Game game = new Game();
    ExecutorService executorService = Executors.newFixedThreadPool(TREAD_POOL_SIZE);

    while(!game.isGameOver()) {
      Random random = new Random();
      executorService.submit(() -> game.update(random.nextBoolean(), random.nextBoolean()));

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new IllegalStateException(e.getMessage(), e);
      }
    }

    executorService.shutdown();

    try {
      if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        System.out.printf("поток %s дождался заверщения других \n", Thread.currentThread().getName());
        System.out.printf("score: %s \n", game.getScore());
      } else {
        executorService.shutdownNow();
      }
    } catch (InterruptedException e) {
      executorService.shutdownNow();
      throw new IllegalStateException(e.getMessage(), e);
    }
  }
}
