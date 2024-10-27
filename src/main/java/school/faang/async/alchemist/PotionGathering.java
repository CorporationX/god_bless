package school.faang.async.alchemist;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PotionGathering {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    List<Potion> potions = List.of(
        new Potion("Healing Potion", 5),
        new Potion("Mana Potion", 7),
        new Potion("Stamina Potion", 4)
    );

    gatherAllIngredients(potions);

  }

  private static void gatherAllIngredients(List<Potion> potions) {
    ExecutorService potionCollectors = Executors.newFixedThreadPool(3);

    List<CompletableFuture<Integer>> futureCollections = potions.stream()
        .map(potion -> gatherIngredients(potion, potionCollectors))
        .toList();

    CompletableFuture<Integer> futureCollectedItems = CompletableFuture.allOf(
            futureCollections.toArray(new CompletableFuture[0]))
        .thenApply(totalItems -> futureCollections
            .stream()
            .map(CompletableFuture::join)
            .mapToInt(Integer::intValue)
            .sum());

    int totalItems = futureCollectedItems.join();

    System.out.println("Total collected items: " + totalItems);

    potionCollectors.shutdownNow();
  }

  private static CompletableFuture<Integer> gatherIngredients(Potion potion,
      ExecutorService executorService) {
    try {
      Thread.sleep(1000);
      log.info("items collected");
    } catch (InterruptedException | RuntimeException e) {
      log.error("Caught exception args: ", e);
    }
    return CompletableFuture.supplyAsync(potion::getRequiredIngredients, executorService);
  }

}
