package pumping_alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PotionGathering {
    /**
     * The main method initializes a list of potions and triggers the asynchronous gathering of their ingredients.
     *
     * @param args Command line arguments (not used)
     * @throws InterruptedException if the thread executing the gatherAllIngredients is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );

        gatherAllIngredients(potions);
    }

    /**
     * Asynchronously collects all the ingredients for the given potion. The number of collected ingredients will be the
     * value returned by the future. The amount of time it takes to gather the ingredients is proportional to the number
     * of ingredients required by the potion.
     *
     * @param potion the potion whose ingredients are to be gathered
     * @return a future that will contain the number of collected ingredients
     */
    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Gathering ingredients for " + potion.getName());
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Collected " + potion.getRequiredIngredients() + " ingredients for " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }

    /**
     * Collects all the ingredients for the given potions and prints the total amount of collected ingredients.
     *
     * @param potions the list of potions to gather ingredients for
     */
    public static void gatherAllIngredients(List<Potion> potions) {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allTasks.thenRun(() -> {
            int totalIngredients = futures.stream()
                    .map(CompletableFuture::join)
                    .reduce(0, Integer::sum);
            System.out.println("Общее количество собранных ингредиентов: " + totalIngredients);
        }).join();
    }

}
