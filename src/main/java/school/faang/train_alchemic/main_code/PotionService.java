package school.faang.train_alchemic.main_code;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PotionService {
    private List<Potion> potions;

    public void getAllIngredients() {
        List<CompletableFuture<Integer>> futures = potions.stream()
                .map(potion -> gatherIntredients(potion))
                .collect(Collectors.toList());

        CompletableFuture<Void> allIngredients = CompletableFuture.allOf();
    }

    private CompletableFuture<Integer> gatherIntredients(Potion potion) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return potion.getRequiredIngredients();
        });
        return future;
    }
}
