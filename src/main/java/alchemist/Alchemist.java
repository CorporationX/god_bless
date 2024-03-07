package alchemist;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class Alchemist {
    private final AtomicInteger totalIngredients;

    public Alchemist() {
        this.totalIngredients = new AtomicInteger(0);
    }

    public CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int gatheredIngredients = potion.getRequiredIngredients();
            System.out.println("Gathered " + gatheredIngredients + " ingredients for potion: " + potion.getName());
            return gatheredIngredients;
        });
    }

    public void addIngredients(int ingredients) {
        totalIngredients.addAndGet(ingredients);
    }

    public int getTotalIngredients() {
        return totalIngredients.get();
    }
}

