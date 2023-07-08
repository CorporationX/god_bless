package alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class PotionList {
    private List<Potion> potionList = new ArrayList<>();

    public List<Potion> getPotionList() {
        return new ArrayList<>(potionList);
    }

    public void addPotion(Potion potion) {
        potionList.add(potion);
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            int numberOfIngredients = potion.getRequiredIngredients();

            for (int i = 0; i < numberOfIngredients; i++) {
                potion.addIngredient();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Potion " + potion.getName() + "'s ingredients collected. It's count - "
                    + potion.getRequiredIngredients());
            return numberOfIngredients;
        });
    }
}
