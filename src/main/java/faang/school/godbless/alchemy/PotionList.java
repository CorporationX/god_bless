package faang.school.godbless.alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionList {
  private List<Potion> potions = new ArrayList<>();

  public List<Potion> getPotions() {
    return potions;
  }

  public void add(Potion potion) {
    potions.add(potion);
  }

  public CompletableFuture<Integer> gatherIngredients(Potion potion) {
    return CompletableFuture.supplyAsync(() -> {
      int requiredIngredientsCount = potion.getRequiredIngredients();

      for (int i = 0; i < requiredIngredientsCount; i++) {
        potion.addIngredient();
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return requiredIngredientsCount;
    });
  }
}
