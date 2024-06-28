package faang.school.godbless.bjs2_13864;

import static faang.school.godbless.bjs2_13864.Util.getRandomNumber;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int POOL_SIZE = 3;
  private static final long TIME_OUT = 30;
  private static final String TERMINATED_INTERRUPTED_EXCEPTION = "Завершение executorService было прервано. ";

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
    List<Kingdom> kingdoms = createKingdoms();
    kingdoms.forEach(kingdom -> {
      CompletableFuture.supplyAsync(() -> kingdom.sendMessage(getRandomKingdom(kingdoms)), executorService)
          .handle((str, th) -> str == null ? th : str)
          .thenAccept(System.out::println);
    });
    shutdown(executorService);
  }

  private static List<Kingdom> createKingdoms() {
    return List.of(new Kingdom("Королевство Севера", 8),
        new Kingdom("Королевство Штормовых земель", 3),
        new Kingdom("Королевство Гор и Долины", 5),
        new Kingdom("Королевство Дорна", 2),
        new Kingdom("Королевство Островов и Рек", 1),
        new Kingdom("Королевство Скал", 6),
        new Kingdom("Королевство Простора", 7));
  }

  private static Kingdom getRandomKingdom(List<Kingdom> kingdoms) {
    return kingdoms.get(getRandomNumber(kingdoms.size()));
  }

  private static void shutdown(ExecutorService executorService) {
    executorService.shutdown();
    try {
      executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(TERMINATED_INTERRUPTED_EXCEPTION + e);
    }
  }

}
