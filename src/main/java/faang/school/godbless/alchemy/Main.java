package faang.school.godbless.alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

  private static PotionList getPotionList() {
    Potion healing = new Potion("Healing", 3);
    Potion invisibility = new Potion("Invisibility", 5);
    Potion nightVision = new Potion("Night Vision", 4);
    Potion weakness = new Potion("Weakness", 6);

    PotionList potionList = new PotionList();

    potionList.add(healing);
    potionList.add(invisibility);
    potionList.add(nightVision);
    potionList.add(weakness);

    return potionList;
  }

  public static void main(String[] args) {
    PotionList potionList = getPotionList();

    List<CompletableFuture<Integer>> futures = potionList.getPotions().stream()
        .map(potionList::gatherIngredients)
        .toList();

    CompletableFuture<Void> tasks = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));

    tasks.thenRun(() -> {
          int totalIngredients = futures.stream().mapToInt(CompletableFuture::join).sum();
          System.out.println("Total ingredients: " + totalIngredients);
        }
    ).join();
  }
}
