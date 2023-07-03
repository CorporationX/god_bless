package faang.school;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(
                new Potion("Зелье здоровья", 5),
                new Potion("Зелье силы", 3),
                new Potion("Зелье ловкости", 4)
        );
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(Main::gatherIngredients)
                .toList();
        CompletableFuture.allOf((futures.toArray(CompletableFuture[]::new)))
                .thenRun(() -> {
                            int result = futures.stream().mapToInt(CompletableFuture::join).sum();
                            System.out.println("Total count: " + result);
                        }
                ).join();
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return potion.getRequiredIngredients();
        });
    }
}
